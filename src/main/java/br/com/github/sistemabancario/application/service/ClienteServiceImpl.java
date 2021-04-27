package br.com.github.sistemabancario.application.service;

import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

import br.com.github.sistemabancario.application.service.exception.CnpjClienteJaExisteException;
import br.com.github.sistemabancario.application.service.exception.CnpjInvalidoException;
import br.com.github.sistemabancario.application.service.exception.CpfClienteJaExisteException;
import br.com.github.sistemabancario.application.service.exception.CpfInvalidoException;
import br.com.github.sistemabancario.application.service.exception.EmailClienteJaExisteException;
import br.com.github.sistemabancario.application.service.exception.EmailInvalidoException;
import br.com.github.sistemabancario.domain.model.Cliente;
import br.com.github.sistemabancario.domain.service.ClienteService;
import br.com.github.sistemabancario.infrastructure.persistence.hibernate.repository.ClienteRepository;
import br.com.github.sistemabancario.infrastructure.util.CnpjUtil;
import br.com.github.sistemabancario.infrastructure.util.CpfUtil;
import br.com.github.sistemabancario.infrastructure.validator.EmailValidator;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, ClienteRepository> implements ClienteService {

	@Override
	public Cliente salvar(Cliente cliente) {
		validaNulo(cliente);
		cliente.setCpf(cliente.getCpf() != null ? CpfUtil.remove(cliente.getCpf()) : null);
		cliente.setCnpj(cliente.getCnpj() != null ? CnpjUtil.remove(cliente.getCnpj()) : null);
		validaCpfEmailAndCnpj(cliente);
		validarDuplicidade(cliente);
		return super.salvar(cliente);
	}

	@Override
	public Cliente atualizar(Long id, Cliente cliente) {
		validaNulo(cliente);
		cliente.setCpf(CpfUtil.remove(cliente.getCpf()));
		cliente.setCnpj(CnpjUtil.remove(cliente.getCnpj()));
		validaCpfEmailAndCnpj(cliente);
		validarDuplicidade(cliente);
		return super.atualizar(id, cliente);
	}

	@Override
	public Cliente alternaAtivo(Long id) {
		Cliente cliente = super.buscar(id);
		cliente.setAtivo(!cliente.getAtivo());
		return super.salvar(cliente);
	}

	private boolean cpfExists(String cpf) {
		return getRepository().existsByCpf(cpf);
	}

	private boolean emailExists(String email) {
		return getRepository().existsByEmail(email);
	}

	private boolean cnpjExists(String cnpj) {
		return getRepository().existsByCnpj(cnpj);
	}

	private void validarDuplicidade(Cliente cliente) {

		if (cpfExists(cliente.getCpf())) {
			throw new CpfClienteJaExisteException();
		}

		if (emailExists(cliente.getEmail())) {
			throw new EmailClienteJaExisteException();
		}

		if (cnpjExists(cliente.getCnpj())) {
			throw new CnpjClienteJaExisteException();
		}
	}

	private void validaCpfEmailAndCnpj(Cliente cliente) {
		String cpf = cliente.getCpf();
		if (!CpfUtil.isValid(cpf)) {
			throw new CpfInvalidoException();
		}

		String email = cliente.getEmail();
		if (!EmailValidator.isValidoEmail(email)) {
			throw new EmailInvalidoException();
		}

		String cnpj = cliente.getCnpj();
		if (!Strings.isNullOrEmpty(cnpj) && !CnpjUtil.isValid(cnpj)) {
			throw new CnpjInvalidoException();
		}
	}

}

package br.com.github.sistemabancario.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

import br.com.github.sistemabancario.application.service.exception.CampoObrigatorioException;
import br.com.github.sistemabancario.application.service.exception.CampoTamanhoMaximoException;
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
		validaObrigatoriedadeDosCampos(cliente);
		validaCpfEmailAndCnpj(cliente);
		validarDuplicidade(cliente);
		return super.salvar(cliente);
	}

	@Override
	public Cliente atualizar(Long id, Cliente cliente) {
		validaNulo(cliente);
		cliente.setCpf(cliente.getCpf() != null ? CpfUtil.remove(cliente.getCpf()) : null);
		cliente.setCnpj(cliente.getCnpj() != null ? CnpjUtil.remove(cliente.getCnpj()) : null);
		validaObrigatoriedadeDosCampos(cliente);
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

	private void validaObrigatoriedadeDosCampos(Cliente cliente) {
		if (cliente.getCpf() == null) {
			throw new CampoObrigatorioException("CPF");
		} else if (cliente.getCpf().length() > 14) {
			throw new CampoTamanhoMaximoException("CPF", 14);
		}

		if (cliente.getNome() == null) {
			throw new CampoObrigatorioException("Nome");
		}

		if (cliente.getCep() == null) {
			throw new CampoObrigatorioException("CEP");
		}

		if (cliente.getRua() == null) {
			throw new CampoObrigatorioException("Rua");
		}

		if (cliente.getBairro() == null) {
			throw new CampoObrigatorioException("Bairro");
		}
	}

	public List<Cliente> buscarPorEmail(String email) {
		List<Cliente> clientes = new ArrayList<>();
		getRepository().findByEmail(email).forEach(cliente -> {
			if (cliente != null) {
				clientes.add(cliente);
			}
		});
		return clientes;
	}

	public List<Cliente> buscarPorNomeLike(String nome) {
		List<Cliente> clientes = new ArrayList<>();
		getRepository().findByNomeLike(nome).forEach(cliente -> {
			if (cliente != null) {
				clientes.add(cliente);
			}
		});
		return clientes;
	}

	public List<Cliente> buscarPorCpf(String cpf) {
		List<Cliente> clientes = new ArrayList<>();
		getRepository().findByNomeLike(cpf).forEach(cliente -> {
			if (cliente != null) {
				clientes.add(cliente);
			}
		});
		return clientes;
	}

	public List<Cliente> buscarPorCnpj(String cnpj) {
		List<Cliente> clientes = new ArrayList<>();
		getRepository().findByCnpj(cnpj).forEach(cliente -> {
			if (cliente != null) {
				clientes.add(cliente);
			}
		});
		return clientes;
	}

}

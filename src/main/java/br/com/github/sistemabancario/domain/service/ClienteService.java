package br.com.github.sistemabancario.domain.service;

import java.util.List;

import br.com.github.sistemabancario.domain.model.Cliente;

public interface ClienteService extends BaseService<Cliente> {

	public List<Cliente> buscarPorEmail(String email);
	
	public List<Cliente> buscarPorNomeLike(String nome);
	
	public List<Cliente> buscarPorCpf(String cpf);
	
	public List<Cliente> buscarPorCnpj(String cnpj);
}

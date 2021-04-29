package br.com.github.sistemabancario.domain.service;

import java.util.List;

import br.com.github.sistemabancario.domain.model.Uf;

public interface UfService extends BaseService<Uf> {

	List<Uf> buscarPorCodigoUf(Integer codigoUf);
	
	List<Uf> buscarPorNome(String nomePt);
	
	List<Uf> buscarPorSigla(String sigla);
	
	List<Uf> buscarPorRegiao(Integer regiao);
}

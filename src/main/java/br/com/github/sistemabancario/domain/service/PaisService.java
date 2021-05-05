package br.com.github.sistemabancario.domain.service;

import java.util.List;

import br.com.github.sistemabancario.domain.model.Pais;

public interface PaisService extends BaseService<Pais> {

	List<Pais> buscarPorNomePt(String nomePt);
	
	List<Pais> buscarPorSigla(String sigla);
}

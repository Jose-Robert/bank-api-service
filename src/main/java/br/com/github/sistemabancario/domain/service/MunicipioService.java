package br.com.github.sistemabancario.domain.service;

import java.util.List;

import br.com.github.sistemabancario.domain.model.Municipio;

public interface MunicipioService extends BaseService<Municipio> {
	
	public List<Municipio> buscarPorCodigoIbge(String codigoIbge);
	
	public List<Municipio> buscarPorNome(String nome);
	
	public List<Municipio> buscarPorUf(String uf);

}

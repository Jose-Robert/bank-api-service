package br.com.github.sistemabancario.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.github.sistemabancario.domain.model.Municipio;
import br.com.github.sistemabancario.domain.service.MunicipioService;
import br.com.github.sistemabancario.infrastructure.persistence.hibernate.repository.MunicipioRepository;

@Service
public class MunicipioServiceImpl extends BaseServiceImpl<Municipio, MunicipioRepository> implements MunicipioService {

	@Override
	public List<Municipio> buscarPorCodigoIbge(String codigoIbge) {
		return getRepository().findByCodigoIbge(codigoIbge);
	}

	@Override
	public List<Municipio> buscarPorNome(String nome) {
		return getRepository().findByNomeContainingIgnoreCase(nome);
	}

	@Override
	public List<Municipio> buscarPorUf(String uf) {
		return getRepository().findByUfContainingIgnoreCase(uf);
	}

}

package br.com.github.sistemabancario.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.github.sistemabancario.domain.model.Uf;
import br.com.github.sistemabancario.domain.service.UfService;
import br.com.github.sistemabancario.infrastructure.persistence.hibernate.repository.UfRepository;

@Service
public class UfServiceImpl extends BaseServiceImpl<Uf, UfRepository> implements UfService {

	@Override
	public List<Uf> buscarPorCodigoUf(Integer codigoUf) {
		return getRepository().findByCodigoUf(codigoUf);
	}

	@Override
	public List<Uf> buscarPorNome(String nome) {
		return getRepository().findByNomeContainingIgnoreCase(nome);
	}

	@Override
	public List<Uf> buscarPorSigla(String sigla) {
		return getRepository().findBySiglaContainingIgnoreCase(sigla);
	}

	@Override
	public List<Uf> buscarPorRegiao(Integer regiao) {
		return getRepository().findByRegiao(regiao);
	}

}

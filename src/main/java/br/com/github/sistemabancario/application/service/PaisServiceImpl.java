package br.com.github.sistemabancario.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.github.sistemabancario.domain.model.Pais;
import br.com.github.sistemabancario.domain.service.PaisService;
import br.com.github.sistemabancario.infrastructure.persistence.hibernate.repository.PaisRepository;

@Service
public class PaisServiceImpl extends BaseServiceImpl<Pais, PaisRepository> implements PaisService {

	@Override
	public List<Pais> buscarPorNomePt(String nomePt) {
		return getRepository().findByNomePtContainingIgnoreCase(nomePt);
	}

	@Override
	public List<Pais> buscarPorSigla(String sigla) {
		return getRepository().findBySiglaContainingIgnoreCase(sigla);
	}

}

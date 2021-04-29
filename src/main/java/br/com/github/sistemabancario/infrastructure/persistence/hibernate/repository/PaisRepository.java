package br.com.github.sistemabancario.infrastructure.persistence.hibernate.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.github.sistemabancario.domain.model.Pais;

@Repository
public interface PaisRepository extends BaseRepository<Pais> {

	List<Pais> findByNomePtContainingIgnoreCase(String nomePt);
	
	List<Pais> findBySiglaContainingIgnoreCase(String sigla);
}

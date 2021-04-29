package br.com.github.sistemabancario.infrastructure.persistence.hibernate.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.github.sistemabancario.domain.model.Uf;

@Repository
public interface UfRepository extends BaseRepository<Uf> {
	
	List<Uf> findByCodigoUf(Integer codigoUf);
	
	List<Uf> findByNomeContainingIgnoreCase(String nome);
	
	List<Uf> findBySiglaContainingIgnoreCase(String sigla);
	
	List<Uf> findByRegiao(Integer regiao);
	
}

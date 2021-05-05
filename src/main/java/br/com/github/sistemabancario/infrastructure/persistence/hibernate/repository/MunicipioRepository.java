package br.com.github.sistemabancario.infrastructure.persistence.hibernate.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.github.sistemabancario.domain.model.Municipio;

@Repository
public interface MunicipioRepository extends BaseRepository<Municipio> {
	
	List<Municipio> findByCodigoIbge(String codigoIbge);
	
	List<Municipio> findByNomeContainingIgnoreCase(String nome);
	
	List<Municipio> findByUfContainingIgnoreCase(String uf);

}

package br.com.github.sistemabancario.infrastructure.persistence.hibernate.repository;

import java.util.Optional;

import br.com.github.sistemabancario.domain.shared.Anexo;

public interface AnexoRepository extends BaseRepository<Anexo> {

	public Optional<Anexo> findFirstByCaminho(String caminho);
	
	public Optional<Anexo> findByNome(String nome);

}

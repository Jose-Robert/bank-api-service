package br.com.github.sistemabancario.infrastructure.persistence.hibernate.repository;

import org.springframework.stereotype.Repository;

import br.com.github.sistemabancario.domain.model.Cliente;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente> {

	boolean existsByCpf(String cpf);
	
	public boolean existsByEmail(String email);

}

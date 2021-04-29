package br.com.github.sistemabancario.infrastructure.persistence.hibernate.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.github.sistemabancario.domain.model.Cliente;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente> {

	boolean existsByCpf(String cpf);
	
	boolean existsByEmail(String email);

	boolean existsByCnpj(String cnpj);

	List<Cliente> findByEmail(String email);

	List<Cliente> findByNomeLike(String nome);

	List<Cliente> findByCpf(String cpf);

	List<Cliente> findByCnpj(String cnpj);

}

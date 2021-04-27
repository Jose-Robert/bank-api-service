package br.com.github.sistemabancario.presentation.dto.cliente;

import java.io.Serializable;

import br.com.github.sistemabancario.domain.model.Cliente;
import br.com.github.sistemabancario.infrastructure.annotation.specification.SpecificationEntity;
import br.com.github.sistemabancario.infrastructure.annotation.specification.SpecificationField;
import br.com.github.sistemabancario.infrastructure.persistence.hibernate.specification.SpecificationOperation;
import lombok.Getter;
import lombok.Setter;

@SpecificationEntity(Cliente.class)
@Getter
@Setter
public class ClienteFilterRequestTO implements Serializable {

	private static final long serialVersionUID = 6260088059566028993L;

	@SpecificationField(property = "id")
	private Long id;

	@SpecificationField(property = "nome", operation = SpecificationOperation.LIKE_IGNORE_CASE)
	private String nome;

	@SpecificationField(property = "cpf", operation = SpecificationOperation.LIKE_IGNORE_CASE)
	private String cpf;
	
	@SpecificationField(property = "cnpj", operation = SpecificationOperation.LIKE_IGNORE_CASE)
	private String cnpj;
	
	@SpecificationField(property = "telefone")
	private String telefone;
	
	@SpecificationField(property = "email", operation = SpecificationOperation.LIKE_IGNORE_CASE)
	private String email;
	
	@SpecificationField(property = "estadoCivil")
	private Integer estadoCivil;

	@SpecificationField(property = "ativo")
	private boolean ativo;

	public ClienteFilterRequestTO() {
		super();
	}

}
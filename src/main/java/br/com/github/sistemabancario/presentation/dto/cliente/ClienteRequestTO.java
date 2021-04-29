package br.com.github.sistemabancario.presentation.dto.cliente;

import java.io.Serializable;

import br.com.github.sistemabancario.domain.model.Municipio;
import br.com.github.sistemabancario.domain.model.Pais;
import br.com.github.sistemabancario.domain.model.TipoLogradouro;
import br.com.github.sistemabancario.domain.model.Uf;
import br.com.github.sistemabancario.infrastructure.annotation.converter.IdReference;
import lombok.Data;

@Data
public class ClienteRequestTO implements Serializable {

	private static final long serialVersionUID = -5230486751798529175L;
	
	private DadosPessoasRequestTO dadosPessoas;
	
	private String cep;

	@IdReference(target = TipoLogradouro.class, property = "tipoLogradouro")
	private Long tipoLogradouro;

	private String rua;

	private String numero;

	private String complemento;

	private String bairro;

	@IdReference(target = Municipio.class, property = "municipio")
	private Long municipio;

	@IdReference(target = Uf.class, property = "uf")
	private Long uf;

	@IdReference(target = Pais.class, property = "pais")
	private Long pais;
	
	private boolean ativo;
	
}

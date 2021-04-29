package br.com.github.sistemabancario.presentation.dto.cliente;

import java.io.Serializable;

import br.com.github.sistemabancario.domain.shared.EstadoCivil;
import br.com.github.sistemabancario.domain.shared.GrauParentesco;
import br.com.github.sistemabancario.domain.shared.RacaCor;
import br.com.github.sistemabancario.domain.shared.Sexo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosPessoasRequestTO implements Serializable {

	private static final long serialVersionUID = -3669499644879085450L;
	
	private String nome;

	private String cpf;
	
	private String cnpj;
	
	private String telefone;
	
	private String email;
	
	private EstadoCivil estadoCivil;
	
	private Sexo sexo;

	private RacaCor racaCor;

	private GrauParentesco grauParentesco;
}

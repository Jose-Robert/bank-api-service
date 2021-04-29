package br.com.github.sistemabancario.presentation.dto.cliente;

import java.io.Serializable;

import br.com.github.sistemabancario.presentation.dto.shared.EnumResponseTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosPessoasResponseTO implements Serializable {

	private static final long serialVersionUID = 272001956119375374L;
	
	private String nome;

	private String cpf;
	
	private String cnpj;
	
	private String telefone;
	
	private String email;
	
	private EnumResponseTO estadoCivil;
	
	private EnumResponseTO sexo;

	private EnumResponseTO racaCor;

	private EnumResponseTO grauParentesco;
}

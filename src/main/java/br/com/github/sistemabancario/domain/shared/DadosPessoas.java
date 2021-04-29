package br.com.github.sistemabancario.domain.shared;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class DadosPessoas implements Serializable {

	private static final long serialVersionUID = 9122069565754687625L;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "CPF")
	private String cpf;

	@Column(name = "CNPJ")
	private String cnpj;

	@Column(name = "TELEFONE")
	private String telefone;

	@Column(name = "EMAIL")
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(name = "ESTADOCIVIL")
	private EstadoCivil estadoCivil;

	@Enumerated(EnumType.STRING)
	@Column(name = "SEXO")
	private Sexo sexo;

	@Enumerated(EnumType.STRING)
	@Column(name = "RACACOR")
	private RacaCor racaCor;

	@Enumerated(EnumType.STRING)
	@Column(name = "GRAUPARENTESCO")
	private GrauParentesco grauParentesco;

	public EstadoCivil getEstadoCivil(Integer id) {
		estadoCivil = EstadoCivil.carregarPorId(id);
		return estadoCivil;
	}

	public Sexo getSexo(Integer id) {
		sexo = Sexo.carregarPorId(id);
		return sexo;
	}
	
	public RacaCor getRacaCor(Integer id) {
		racaCor = RacaCor.carregarPorId(id);
		return racaCor;
	}
	
	public GrauParentesco getGrauParentesco(Integer id) {
		grauParentesco = GrauParentesco.carregarPorId(id);
		return grauParentesco;
	}
}

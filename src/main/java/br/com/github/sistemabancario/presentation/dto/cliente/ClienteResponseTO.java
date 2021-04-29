package br.com.github.sistemabancario.presentation.dto.cliente;

import java.io.Serializable;

import br.com.github.sistemabancario.presentation.dto.shared.MunicipioResponseTO;
import br.com.github.sistemabancario.presentation.dto.shared.PaisResponseTO;
import br.com.github.sistemabancario.presentation.dto.shared.TipoLogradouroResponseTO;
import br.com.github.sistemabancario.presentation.dto.shared.UfResponseTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResponseTO implements Serializable {

	private static final long serialVersionUID = -5230486751798529175L;

	private Long id;

	private DadosPessoasResponseTO dadosPessoas;
	
	private String cep;

	private TipoLogradouroResponseTO tipoLogradouro;

	private String rua;

	private String numero;

	private String complemento;

	private String bairro;

	private MunicipioResponseTO municipio;

	private UfResponseTO uf;

	private PaisResponseTO pais;
	
	private boolean ativo;
	
}

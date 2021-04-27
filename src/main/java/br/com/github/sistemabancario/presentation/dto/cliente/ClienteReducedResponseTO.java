package br.com.github.sistemabancario.presentation.dto.cliente;

import java.io.Serializable;

import br.com.github.sistemabancario.domain.shared.EstadoCivil;
import br.com.github.sistemabancario.presentation.dto.shared.EnumResponseTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteReducedResponseTO implements Serializable {

	private static final long serialVersionUID = 3529315043658391184L;

	private Long id;

    private String nome;
    
    private String cpf;
    
	private String cnpj;
	
	private String telefone;
	
	private String email;
	
	private EnumResponseTO estadoCivil;
    
    private boolean ativo;
    
	public String getEstadoCivil() {
        return EstadoCivil.carregarPorId(estadoCivil.getId()).getDescricao();
    }

}

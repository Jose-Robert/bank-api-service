package br.com.github.sistemabancario.presentation.dto.shared;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnexoResponseTO implements Serializable{
    
    private static final long serialVersionUID = -5407136080990299157L;

    private Long id;

    private String nome;
    
    private String formato;
    
}

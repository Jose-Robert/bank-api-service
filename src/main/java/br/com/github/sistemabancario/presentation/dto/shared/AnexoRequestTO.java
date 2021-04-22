package br.com.github.sistemabancario.presentation.dto.shared;

import java.io.Serializable;

import lombok.Data;

@Data
public class AnexoRequestTO implements Serializable{
    
    private static final long serialVersionUID = -1556656629210152605L;
    
    private String nome;
    
    private String url;
    
    private String formato;

}

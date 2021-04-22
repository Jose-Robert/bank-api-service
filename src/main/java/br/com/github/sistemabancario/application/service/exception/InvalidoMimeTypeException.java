package br.com.github.sistemabancario.application.service.exception;

import lombok.Getter;

@Getter
public class InvalidoMimeTypeException extends RuntimeException {

    private static final long serialVersionUID = 1421945173112297550L;
    
    public InvalidoMimeTypeException() {
        super();
    }

}

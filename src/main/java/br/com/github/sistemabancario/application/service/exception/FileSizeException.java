package br.com.github.sistemabancario.application.service.exception;

import lombok.Getter;

@Getter
public class FileSizeException extends RuntimeException {

    private static final long serialVersionUID = -6059457337843772374L;

    public FileSizeException() {
        super();
    }

}

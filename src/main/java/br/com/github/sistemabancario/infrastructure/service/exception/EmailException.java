package br.com.github.sistemabancario.infrastructure.service.exception;

public class EmailException extends RuntimeException {

    private static final long serialVersionUID = -7744152858352688043L;
    
    public EmailException(Throwable cause) {
        super(cause);
    }

}

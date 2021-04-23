package br.com.github.sistemabancario.application.service.exception;

public class EmailInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 2208248846096483465L;

	public EmailInvalidoException() {
		super();
	}

	public EmailInvalidoException(String message) {
		super(message);
	}

}

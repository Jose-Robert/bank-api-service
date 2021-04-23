package br.com.github.sistemabancario.application.service.exception;

public class EmailClienteJaExisteException extends RuntimeException {

	private static final long serialVersionUID = -1472266016500767375L;

	public EmailClienteJaExisteException() {
		super();
	}

	public EmailClienteJaExisteException(String message) {
		super(message);
	}
}

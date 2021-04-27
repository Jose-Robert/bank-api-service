package br.com.github.sistemabancario.application.service.exception;

public class CnpjClienteJaExisteException extends RuntimeException {

	private static final long serialVersionUID = -6872814763609499858L;

	public CnpjClienteJaExisteException() {
		super();
	}

	public CnpjClienteJaExisteException(String message) {
		super(message);
	}

}

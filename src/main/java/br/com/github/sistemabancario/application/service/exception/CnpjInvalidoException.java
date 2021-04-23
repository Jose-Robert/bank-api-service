package br.com.github.sistemabancario.application.service.exception;

public class CnpjInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 4454909813867166700L;

	public CnpjInvalidoException() {
		super();
	}

	public CnpjInvalidoException(String message) {
		super(message);
	}

}

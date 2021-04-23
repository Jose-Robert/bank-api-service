package br.com.github.sistemabancario.application.service.exception;

public class CpfInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 2573522650376129569L;

	public CpfInvalidoException() {
		super();
	}

	public CpfInvalidoException(String message) {
		super(message);
	}
}

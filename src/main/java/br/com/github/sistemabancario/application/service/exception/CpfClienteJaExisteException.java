package br.com.github.sistemabancario.application.service.exception;

public class CpfClienteJaExisteException extends RuntimeException {

	private static final long serialVersionUID = -2954113580894305975L;

	public CpfClienteJaExisteException() {
		super();
	}

	public CpfClienteJaExisteException(String message) {
		super(message);
	}

}

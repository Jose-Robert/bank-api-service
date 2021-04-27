package br.com.github.sistemabancario.application.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import br.com.github.sistemabancario.application.service.exception.CnpjClienteJaExisteException;
import br.com.github.sistemabancario.application.service.exception.CnpjInvalidoException;
import br.com.github.sistemabancario.application.service.exception.CpfClienteJaExisteException;
import br.com.github.sistemabancario.application.service.exception.CpfInvalidoException;
import br.com.github.sistemabancario.application.service.exception.EmailClienteJaExisteException;
import br.com.github.sistemabancario.application.service.exception.EmailInvalidoException;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ClienteExceptionHandler extends BaseExceptionHandler {

	@ExceptionHandler({ CpfClienteJaExisteException.class })
	public ResponseEntity<Object> handleCpfClienteJaExisteException(CpfClienteJaExisteException exception,
			WebRequest request) {
		return handleException(exception, HttpStatus.BAD_REQUEST, request, "cliente.cpf-existente");
	}

	@ExceptionHandler({ CpfInvalidoException.class })
	public ResponseEntity<Object> handleCpfInvalidoException(CpfInvalidoException exception, WebRequest request) {
		return handleException(exception, HttpStatus.BAD_REQUEST, request, "cliente.cpf-invalido");
	}

	@ExceptionHandler({ EmailClienteJaExisteException.class })
	public ResponseEntity<Object> handleEmailClienteJaExisteException(EmailClienteJaExisteException exception, WebRequest request) {
		return handleException(exception, HttpStatus.BAD_REQUEST, request, "cliente.email-existente");
	}

	@ExceptionHandler({ EmailInvalidoException.class })
	public ResponseEntity<Object> handleEmailInvalidoException(EmailInvalidoException exception, WebRequest request) {
		return handleException(exception, HttpStatus.BAD_REQUEST, request, "cliente.email-invalido");
	}
	
	@ExceptionHandler({ CnpjInvalidoException.class })
	public ResponseEntity<Object> handleCnpjInvalidoException(CnpjInvalidoException exception, WebRequest request) {
		return handleException(exception, HttpStatus.BAD_REQUEST, request, "cliente.cnpj-invalido");
	}
	
	@ExceptionHandler({ CnpjClienteJaExisteException.class })
	public ResponseEntity<Object> handleCnpjClienteJaExisteException(CnpjClienteJaExisteException exception, WebRequest request) {
		return handleException(exception, HttpStatus.BAD_REQUEST, request, "cliente.cnpj-existente");
	}

}

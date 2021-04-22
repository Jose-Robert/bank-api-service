package br.com.github.sistemabancario.infrastructure.util;

import org.springframework.stereotype.Component;

import br.com.github.sistemabancario.infrastructure.validator.CpfValidator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Component(value = "cpfUtil")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CpfUtil {

	public static final String CPF_INVALIDO = "CPF inválido.";

	public static boolean isValid(String cpf) {
		cpf = remove(String.valueOf(cpf));
		return CpfValidator.validaCPF(cpf);
	}

	public static String remove(String cpf) {
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");
		return cpf;
	}

}

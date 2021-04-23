package br.com.github.sistemabancario.infrastructure.util;

import org.springframework.stereotype.Component;

import br.com.github.sistemabancario.infrastructure.validator.CnpjValidator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Component(value = "cnpjUtil")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CnpjUtil {

	public static final String CNPJ_INVALIDO = "CNPJ inválido.";

	public static boolean isValid(String cnpj) {
		cnpj = remove(String.valueOf(cnpj));
		return CnpjValidator.validaCNPJ(cnpj);
	}

	public static String remove(String cnpj) {
		cnpj = cnpj.replace(".", "");
		cnpj = cnpj.replace("/", "");
		cnpj = cnpj.replace("-", "");
		return cnpj;
	}

}

package br.com.github.sistemabancario.infrastructure.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Component(value = "emailValidator")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailValidator {

	public static final String EMAIL_INVALIDO = "Email inválido.";

	public static boolean isValidoEmail(String email) {
		boolean isEmailValido = false;
		if (email != null && email.length() > 0) {
			String expression = ".+@.+\\.[a-z]+";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher mt = pattern.matcher(email);
			if (mt.matches()) {
				isEmailValido = true;
			}
		}
		return isEmailValido;
	}

}

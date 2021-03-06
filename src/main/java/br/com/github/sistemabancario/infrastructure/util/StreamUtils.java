package br.com.github.sistemabancario.infrastructure.util;

import java.util.concurrent.Callable;

public class StreamUtils {

	public static <T> T propagate(Callable<T> callable) {
		try {
			return callable.call();
		} catch (RuntimeException runtimeException) {
			throw runtimeException;
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

}
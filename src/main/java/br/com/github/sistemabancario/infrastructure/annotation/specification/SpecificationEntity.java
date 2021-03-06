package br.com.github.sistemabancario.infrastructure.annotation.specification;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ TYPE })
public @interface SpecificationEntity {

    public Class<?> value();

}

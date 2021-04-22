package br.com.github.sistemabancario.application.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
@ConfigurationProperties("sistema-bancario.cors")
public class CorsProperties {

    private String allowedOrigin;

    public String getAllowedOrigin() {
        if(allowedOrigin == null) {
            setAllowedOrigin("*");
        }
        return allowedOrigin;
    }

    public void setAllowedOrigin(String allowedOrigin) {
        this.allowedOrigin = allowedOrigin;
    }

}

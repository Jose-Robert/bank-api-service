package br.com.github.sistemabancario.domain.shared;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Data implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "DTINICIO")
    private LocalDateTime inicio;

    @Column(name = "DTFINAL")
    private LocalDateTime encerramento;
    
    public Data() {
    }

    public Data(@NotNull LocalDateTime inicio) {
        super();
        this.inicio = inicio;
    }
    
    public void encerra() {
        if(encerramento == null) {
            encerramento = LocalDateTime.now();
        }
    }

}

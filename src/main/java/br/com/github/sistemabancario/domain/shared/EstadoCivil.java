package br.com.github.sistemabancario.domain.shared;

import br.com.github.sistemabancario.application.service.exception.RecursoNaoEncontradoException;
import lombok.Getter;

@Getter
public enum EstadoCivil {
    
    SOLTEIRO(1, "Solteiro(a)"),
    CASADO(2, "Casado(a)"),
    DIVORCIADO(3, "Divorciado(a)"),
    VIUVO(4, "Viúvo(a)"),
    SEPARADO(5, "Separado(a)");
    
    private Integer id;
    private String descricao;
    
    public static EstadoCivil carregarPorId(Integer id) {
        for (EstadoCivil tipo : EstadoCivil.values()) {
            if (tipo.getId().equals(id)) {
                return tipo;
            }
        }
        throw new RecursoNaoEncontradoException();
    }

    private EstadoCivil(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
}

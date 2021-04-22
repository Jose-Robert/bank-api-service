package br.com.github.sistemabancario.domain.shared;

import br.com.github.sistemabancario.application.service.exception.RecursoNaoEncontradoException;
import lombok.Getter;

@Getter
public enum Deficiencia {
    
    VISUAL(1, "Visual"),
    AUDITIVA(2, "Auditiva"),
    MENTAL(3, "Mental"),
    FISICA(4, "Física"),
    MULTIPLA(5, "Múltipla");
    
    private Integer id;
    private String descricao;
    
    public static Deficiencia carregarPorId(Integer id) {
        for (Deficiencia tipo : Deficiencia.values()) {
            if (tipo.getId().equals(id)) {
                return tipo;
            }
        }
        throw new RecursoNaoEncontradoException();
    }

    private Deficiencia(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

}

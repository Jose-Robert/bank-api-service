package br.com.github.sistemabancario.domain.shared;

import br.com.github.sistemabancario.application.service.exception.RecursoNaoEncontradoException;
import lombok.Getter;

@Getter
public enum Sexo {

    MASCULINO(1, "Masculino"),
    FEMININO(2, "Feminino");
    
    private Integer id;
    private String descricao;
    
    public static Sexo carregarPorId(Integer id) {
        for (Sexo tipo : Sexo.values()) {
            if (tipo.getId().equals(id)) {
                return tipo;
            }
        }
        throw new RecursoNaoEncontradoException();
    }
    
    public static Sexo carregarPorDescricao(String descricao) {
        for (Sexo tipo : Sexo.values()) {
            if (tipo.getDescricao().equalsIgnoreCase(descricao)) {
                return tipo;
            }
        }
        throw new RecursoNaoEncontradoException();
    }

    private Sexo(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    
}

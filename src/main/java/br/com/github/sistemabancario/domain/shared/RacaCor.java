package br.com.github.sistemabancario.domain.shared;

import br.com.github.sistemabancario.application.service.exception.RecursoNaoEncontradoException;
import lombok.Getter;

@Getter
public enum RacaCor {
    
    NAO_INFORMADO(0, "Não informado"),
    BRANCO(1, "Branco"),
    NEGRO(2, "Negro"),
    AMARELO(3, "Amarelo"),
    PARDO(7, "Pardo"),
    INDIGENA(8, "Indígena");
    
    private Integer id;
    private String descricao;
    
    public static RacaCor carregarPorId(Integer id) {
        for (RacaCor tipo : RacaCor.values()) {
            if (tipo.getId().equals(id)) {
                return tipo;
            }
        }
        throw new RecursoNaoEncontradoException();
    }
    
    public static RacaCor carregarPorDescricao(String descricao) {
        for (RacaCor tipo : RacaCor.values()) {
            if (tipo.getDescricao().equalsIgnoreCase(descricao)) {
                return tipo;
            }
        }
        throw new RecursoNaoEncontradoException();
    }

    private RacaCor(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

}

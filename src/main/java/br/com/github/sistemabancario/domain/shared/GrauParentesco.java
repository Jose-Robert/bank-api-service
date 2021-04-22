package br.com.github.sistemabancario.domain.shared;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public enum GrauParentesco {

    CONJUGE(1, "Cônjuge"), 
    FILHO(2, "Filho(a)"), 
    PAI_MAE(3, "Pai/Mãe"), 
    SOGRO_SOGRA(4, "Sogro/Sogra"),
    OUTROS(5, "Outros"), 
    GUARDA_JUDICIAL(6, "Guarda Judicial"), 
    GUARDA_PROVISORIA(7, "Guarda Provisória"),
    TUTELA(8, "Tutela"),
    CURATELA(8, "Curatela"),
    ENTEADO(9, "Enteado(a)"), 
    COMPANHEIRO(10, "Companheiro(a)"),
    AVO_BISAVO(11, "Avô(a)/Bisavô(a)"), 
    EX_CONJUGE(12, "Ex cônjuge - Pensão Alimentícia");

    private Integer id;
    private String descricao;

    public static GrauParentesco carregarPorId(Integer id) {
        for (GrauParentesco grauParentesco : GrauParentesco.values()) {
            if (grauParentesco.getId().equals(id)) {
                return grauParentesco;
            }
        }
        return null;
    }
    
    public static List<GrauParentesco> listarGrauParentescoParaInclusaoDeDependentes() {
        return Arrays.asList(
                CONJUGE, 
                FILHO, 
                PAI_MAE, 
                SOGRO_SOGRA, 
                GUARDA_JUDICIAL, 
                GUARDA_PROVISORIA, 
                TUTELA, 
                CURATELA, 
                ENTEADO, 
                COMPANHEIRO
               );
    }

    private GrauParentesco(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
}

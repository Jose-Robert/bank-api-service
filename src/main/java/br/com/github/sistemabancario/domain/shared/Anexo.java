package br.com.github.sistemabancario.domain.shared;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ANEXO")
public class Anexo extends BaseEntity {
    
    private static final long serialVersionUID = -5407136080990299157L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDANEXO")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CAMINHO")
    private String caminho;
    
    @Column(name = "EXTENSAO")
    private String formato;
    
    public Anexo() {
    }

    public Anexo(String nome, String caminho, String formato) {
        super();
        this.nome = nome;
        this.caminho = caminho;
        this.formato = formato;
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((super.getId() == null) ? 0 : super.getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anexo other = (Anexo) obj;
		if (super.getId() == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

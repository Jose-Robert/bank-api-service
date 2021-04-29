package br.com.github.sistemabancario.domain.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.github.sistemabancario.domain.shared.BaseEntity;
import br.com.github.sistemabancario.domain.shared.DadosPessoas;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "CLIENTE")
public class Cliente extends BaseEntity {

	private static final long serialVersionUID = -6144057776638633753L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CDCLIENTE")
	private Long id;
	
	@Embedded
	private DadosPessoas dadosPessoas;

	@Column(name = "CEP", length = 8)
	private String cep;

	@ManyToOne
	@JoinColumn(name = "TIPOLOGRADOURO_ID", referencedColumnName = "CDTIPOLOG")
	private TipoLogradouro tipoLogradouro;

	@Column(name = "RUA")
	private String rua;

	@Column(name = "NUMERO")
	private String numero;

	@Column(name = "COMPLEMENTO")
	private String complemento;

	@Column(name = "BAIRRO")
	private String bairro;

	@ManyToOne
	@JoinColumn(name = "MUNICIPIO_ID", referencedColumnName = "CDMUNICIPIO")
	private Municipio municipio;

	@ManyToOne
	@JoinColumn(name = "UF_ID")
	private Uf uf;

	@ManyToOne
	@JoinColumn(name = "PAIS_ID")
	private Pais pais;
	

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
		Cliente other = (Cliente) obj;
		if (super.getId() == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "Funcionario [id=" + id + ", nome=" + dadosPessoas.getNome() + ", cpf=" + dadosPessoas.getCpf() + "]";
    }
}

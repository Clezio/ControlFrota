package br.com.abcdario.controlfrota.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "pessoajuridica")
@PrimaryKeyJoinColumn(name = "pessoa")
public class PessoaJuridica extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "cnpj")
	private Long cnpj;

	@Column(name = "inscricaoEstadual")
	private Long inscricaoEstadual;

	@Column(name = "inscricaoMunicipal")
	private Long inscricaoMunicipal;

	@Column(name = "fax")
	private String fax;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoaJuridica")
	private Posto posto;

	public PessoaJuridica() {

	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public Long getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(Long inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public Long getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(Long inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Posto getPosto() {
		return posto;
	}

	public void setPosto(Posto posto) {
		this.posto = posto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		PessoaJuridica other = (PessoaJuridica) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getNome() == null ? "" : getNome();
	}

}

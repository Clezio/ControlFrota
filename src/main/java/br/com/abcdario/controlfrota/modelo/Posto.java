package br.com.abcdario.controlfrota.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "posto")
public class Posto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigoPosto")
	private Integer codigo;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pessoa")
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	private PessoaJuridica pessoaJuridica;

	@Column(name = "registroFuncionamento", unique = true)
	private Long registroFuncionamento;

	public Posto() {

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Long getRegistroFuncionamento() {
		return registroFuncionamento;
	}

	public void setRegistroFuncionamento(Long registroFuncionamento) {
		this.registroFuncionamento = registroFuncionamento;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
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
		Posto other = (Posto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return pessoaJuridica.getNome() == null ? "" : pessoaJuridica.getNome();
	}

}

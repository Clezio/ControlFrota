package br.com.abcdario.controlfrota.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.abcdario.controlfrota.util.EntidadeBase;

@Entity
@Table(name = "cidade")
public class Cidade implements Serializable, EntidadeBase {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codigoCidade", insertable = false, updatable = false)
	private Integer codigo;

	@Column(name = "nome", insertable = false, updatable = false)
	private String nome;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estado", insertable = false, updatable = false)
	private Estado estado;

	public Cidade() {

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public String getIdEntity() {
		return nome == null ? "" : nome;
	}

}

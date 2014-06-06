package br.com.abcdario.controlfrota.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.abcdario.controlfrota.util.EntidadeBase;

@Entity
@Table(name = "estado")
public class Estado implements Serializable, EntidadeBase {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codigoEstado", insertable = false, updatable = false)
	private Integer codigo;

	@Column(name = "uf", insertable = false, updatable = false, unique = true, length = 2)
	private String uf;

	@Column(name = "nome", insertable = false, updatable = false)
	private String nome;

	public Estado() {

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// public List<Cidade> getCidades() {
	// return cidades;
	// }
	//
	// public void setCidades(List<Cidade> cidades) {
	// this.cidades = cidades;
	// }
	//
	// public PessoaFisica getPessoaFisica() {
	// return pessoaFisica;
	// }
	//
	// public void setPessoaFisica(PessoaFisica pessoaFisica) {
	// this.pessoaFisica = pessoaFisica;
	// }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
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
		Estado other = (Estado) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return uf == null ? "" : uf;
	}

	@Override
	public String getIdEntity() {
		return toString();
	}

}

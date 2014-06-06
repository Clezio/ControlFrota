package br.com.abcdario.controlfrota.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import br.com.abcdario.controlfrota.util.EntidadeBase;

@Entity
@Table(name = "perfil")
public class Perfil implements Serializable, EntidadeBase {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigoPerfil")
	private Integer codigo;

	@Column(name = "descricao")
	private String descricao;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "perfilusuario", joinColumns = { @JoinColumn(name = "perfil") }, inverseJoinColumns = { @JoinColumn(name = "usuario") })
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	private List<Usuario> usuarios;

	public Perfil() {

	}

	public String getAuthority() {
		return this.descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
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
		Perfil other = (Perfil) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return descricao == null ? "" : descricao;
	}

	@Override
	public String getIdEntity() {
		return toString();
	}

}

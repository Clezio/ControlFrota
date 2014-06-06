package br.com.abcdario.controlfrota.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pessoafisica")
@PrimaryKeyJoinColumn(name = "pessoa")
public class PessoaFisica extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "cpf", unique = true)
	private Long cpf;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataNascimento")
	private Calendar dataNascimento;

	@Column(name = "estadoCivil")
	private String estadoCivil;

	@Column(name = "sexo", length = 1)
	private String sexo;

	@Column(name = "rg", unique = true)
	private BigInteger rg;

	@Column(name = "orgaoEmissor")
	private String orgaoEmissor;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estado")
	private Estado ufOrgaoEmissor;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataExpedicaoRg")
	private Calendar dataExpedicaoRg;

	@Column(name = "celular")
	private String celular;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoaFisica")
	private Motorista motorista;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoaFisica")
	private Usuario usuario;

	public PessoaFisica() {

	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public BigInteger getRg() {
		return rg;
	}

	public void setRg(BigInteger rg) {
		this.rg = rg;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public Estado getUfOrgaoEmissor() {
		return ufOrgaoEmissor;
	}

	public void setUfOrgaoEmissor(Estado ufOrgaoEmissor) {
		this.ufOrgaoEmissor = ufOrgaoEmissor;
	}

	public Calendar getDataExpedicaoRg() {
		return dataExpedicaoRg;
	}

	public void setDataExpedicaoRg(Calendar dataExpedicaoRg) {
		this.dataExpedicaoRg = dataExpedicaoRg;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setInstrutor(Motorista motorista) {
		this.motorista = motorista;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		PessoaFisica other = (PessoaFisica) obj;
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

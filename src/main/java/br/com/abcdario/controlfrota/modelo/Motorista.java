package br.com.abcdario.controlfrota.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "motorista")
public class Motorista implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigoMotorista")
	private Integer codigo;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pessoaFisica")
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	private PessoaFisica pessoaFisica;

	@Column(name = "cnh", unique = true)
	private Long cnh;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "dataAdmissao")
	private Calendar dataAdmissao;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "dataValidadeCnh")
	private Calendar dataValidadeCnh;

	@Column(name = "categoriaCnh", length = 3)
	private String categoriaCnh;

	@Column(name = "observacao")
	private String observacao;

	@OneToMany(mappedBy = "motorista")
	private List<MotoristaVeiculo> listaMotoristaVeiculo;

	public Motorista() {

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public Long getCnh() {
		return cnh;
	}

	public void setCnh(Long cnh) {
		this.cnh = cnh;
	}

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Calendar getDataValidadeCnh() {
		return dataValidadeCnh;
	}

	public void setDataValidadeCnh(Calendar dataValidadeCnh) {
		this.dataValidadeCnh = dataValidadeCnh;
	}

	public String getCategoriaCnh() {
		return categoriaCnh;
	}

	public void setCategoriaCnh(String categoriaCnh) {
		this.categoriaCnh = categoriaCnh;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<MotoristaVeiculo> getListaMotoristaVeiculo() {
		return listaMotoristaVeiculo;
	}

	public void setListaMotoristaVeiculo(List<MotoristaVeiculo> listaMotoristaVeiculo) {
		this.listaMotoristaVeiculo = listaMotoristaVeiculo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnh == null) ? 0 : cnh.hashCode());
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
		Motorista other = (Motorista) obj;
		if (cnh == null) {
			if (other.cnh != null)
				return false;
		} else if (!cnh.equals(other.cnh))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return pessoaFisica.getNome() == null ? "" : pessoaFisica.getNome();
	}

}
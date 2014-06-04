package br.com.abcdario.controlfrota.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigoVeiculo")
	private Integer codigo;

	@Column(name = "placa", unique = true, length = 7)
	private String placa;

	@Column(name = "marca", length = 45)
	private String marca;

	@Column(name = "modelo", length = 45)
	private String modelo;

	@Column(name = "ano", length = 4)
	private Integer ano;

	@Column(name = "cor", length = 45)
	private String cor;

	@Column(name = "categoria", length = 3)
	private String categoria;

	@Column(name = "observacao")
	private String observacao;

	@OneToMany(mappedBy = "veiculo")
	private List<MotoristaVeiculo> listaMotoristaVeiculo;

	@OneToMany(mappedBy = "veiculo")
	private List<NotaAbastecimento> listaNotasAbastecimento;

	public Veiculo() {

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public void setListaInstrutorsVeiculo(List<MotoristaVeiculo> listaMotoristaVeiculo) {
		this.listaMotoristaVeiculo = listaMotoristaVeiculo;
	}

	public List<NotaAbastecimento> getListaNotasAbastecimento() {
		return listaNotasAbastecimento;
	}

	public void setListaNotasAbastecimento(List<NotaAbastecimento> listaNotasAbastecimento) {
		this.listaNotasAbastecimento = listaNotasAbastecimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
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
		Veiculo other = (Veiculo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return placa == null ? "" : placa;
	}

}

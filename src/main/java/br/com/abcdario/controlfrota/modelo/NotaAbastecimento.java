package br.com.abcdario.controlfrota.modelo;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "notaabastecimento")
public class NotaAbastecimento implements Serializable, Comparable<NotaAbastecimento> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigoNota")
	private Integer codigo;

	@Column(name = "combustivel")
	private String combustivel;

	@Column(name = "quantidadeLitro")
	private Long quantidadeLitro;

	@Column(name = "kilometragemInicial")
	private Long kilometragemInicial;

	@Column(name = "kilometragemFinal")
	private Long kilometragemFinal;

	@Column(name = "valorLitro")
	private Double valorLitro;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataAbastecimento")
	private Calendar dataAbastecimento;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "posto")
	private Posto posto;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "veiculo")
	private Veiculo veiculo;

	public NotaAbastecimento() {

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public Long getQuantidadeLitro() {
		return quantidadeLitro;
	}

	public void setQuantidadeLitro(Long quantidadeLitro) {
		this.quantidadeLitro = quantidadeLitro;
	}

	public Long getKilometragemInicial() {
		return kilometragemInicial;
	}

	public void setKilometragemInicial(Long kilometragemInicial) {
		this.kilometragemInicial = kilometragemInicial;
	}

	public Long getKilometragemFinal() {
		return kilometragemFinal;
	}

	public void setKilometragemFinal(Long kilometragemFinal) {
		this.kilometragemFinal = kilometragemFinal;
	}

	public Double getValorLitro() {
		return valorLitro;
	}

	public void setValorLitro(Double valorLitro) {
		this.valorLitro = valorLitro;
	}

	public Calendar getDataAbastecimento() {
		return dataAbastecimento;
	}

	public void setDataAbastecimento(Calendar dataAbastecimento) {
		this.dataAbastecimento = dataAbastecimento;
	}

	public Posto getPosto() {
		return posto;
	}

	public void setPosto(Posto posto) {
		this.posto = posto;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
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
		NotaAbastecimento other = (NotaAbastecimento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return codigo.toString() == null ? "" : codigo.toString();
	}

	@Override
	public int compareTo(NotaAbastecimento o) {
		int compare = this.getDataAbastecimento().compareTo(o.getDataAbastecimento());
		if (compare != 0) {
			return compare;
		} else {
			return compare = this.getDataAbastecimento().compareTo(o.getDataAbastecimento());
		}

	}

}

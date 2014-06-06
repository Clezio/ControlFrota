package br.com.abcdario.controlfrota.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "motoristaVeiculo")
public class MotoristaVeiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigoMotoristaVeiculo")
	private Integer codigo;

	@ManyToOne
	@JoinColumn(name = "motorista")
	private Motorista motorista;

	@ManyToOne
	@JoinColumn(name = "veiculo")
	private Veiculo veiculo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataInicio")
	private Calendar dataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataFim")
	private Calendar dataFim;

	@Column(name = "ativo")
	private boolean ativo;

	@Column(name = "observacao")
	private String observacao;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "motoristaVeiculo")
	private List<Rota> listaRota;

	public MotoristaVeiculo() {

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<Rota> getListaRota() {
		return listaRota;
	}

	public void setListaAgendamento(List<Rota> listaRota) {
		this.listaRota = listaRota;
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
		MotoristaVeiculo other = (MotoristaVeiculo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return motorista == null && veiculo == null ? "" : motorista.toString() + "/" + veiculo.toString();
	}
}

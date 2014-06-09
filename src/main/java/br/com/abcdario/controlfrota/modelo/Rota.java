package br.com.abcdario.controlfrota.modelo;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.primefaces.model.ScheduleEvent;

@Entity
@Table(name = "rota")
public class Rota implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigoAgenda")
	private Integer codigo;

	@ManyToOne
	@JoinColumn(name = "motoristaVeiculo")
	private MotoristaVeiculo motoristaVeiculo;

	@Column(name = "dataCancelamento")
	private Calendar dataCancelamento;

	@Column(name = "dataAgendada")
	private Calendar dataAgendada;

	@Column(name = "horaInicial")
	private Calendar horaInicial;

	@Column(name = "horaFinal")
	private Calendar horaFinal;

	@Column(name = "realizada")
	private Boolean realizada;

	@Column(name = "observacao")
	private String observacao;

	@Transient
	private ScheduleEvent dadosAgenda;

	public Rota() {

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public MotoristaVeiculo getMotoristaVeiculo() {
		return motoristaVeiculo;
	}

	public void setMotoristaVeiculo(MotoristaVeiculo motoristaVeiculo) {
		this.motoristaVeiculo = motoristaVeiculo;
	}

	public Calendar getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(Calendar dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}

	public Calendar getDataAgendada() {
		return dataAgendada;
	}

	public void setDataAgendada(Calendar dataAgendada) {
		this.dataAgendada = dataAgendada;
	}

	public Calendar getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(Calendar horaInicial) {
		this.horaInicial = horaInicial;
	}

	public Calendar getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Calendar horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Boolean getRealizada() {
		return realizada;
	}

	public void setRealizada(Boolean realizada) {
		this.realizada = realizada;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public ScheduleEvent getDadosAgenda() {
		return dadosAgenda;
	}

	public void setDadosAgenda(ScheduleEvent dadosAgenda) {
		this.dadosAgenda = dadosAgenda;
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
		Rota other = (Rota) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agenda - Veiculo = " + motoristaVeiculo.getVeiculo().toString() + "\nAgenda - Instrutor = "
				+ motoristaVeiculo.getMotorista().getPessoaFisica().toString();
	}

}

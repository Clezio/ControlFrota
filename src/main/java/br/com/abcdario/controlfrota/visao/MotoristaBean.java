package br.com.abcdario.controlfrota.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.abcdario.controlfrota.fachada.FachadaControlFrota;
import br.com.abcdario.controlfrota.modelo.Cidade;
import br.com.abcdario.controlfrota.modelo.Endereco;
import br.com.abcdario.controlfrota.modelo.Estado;
import br.com.abcdario.controlfrota.modelo.Motorista;
import br.com.abcdario.controlfrota.modelo.PessoaFisica;
import br.com.abcdario.controlfrota.util.FacesUtil;
import br.com.abcdario.controlfrota.util.ValidacaoUtil;

@ManagedBean(name = "motoristaBean")
@Controller("motoristaBean")
@Scope("view")
public class MotoristaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Log LOGGER = LogFactory.getLog(MotoristaBean.class);

	private final FachadaControlFrota fachadaControlFrota;

	private Motorista motorista;
	private List<Motorista> listaMotoristas;
	private PessoaFisica pessoaFisica;
	private Estado estado;
	private List<Estado> estados;
	private List<SelectItem> listaEstados;
	private Cidade cidade;
	private List<Cidade> cidades;
	private List<SelectItem> listaCidades;

	private String nome;

	@Autowired
	public MotoristaBean(FachadaControlFrota fachadaControlFrota) {
		this.fachadaControlFrota = fachadaControlFrota;
		inicializar();
	}

	private void inicializar() {
		motorista = new Motorista();
		listaMotoristas = new ArrayList<Motorista>();
		pessoaFisica = new PessoaFisica();
		pessoaFisica.setEndereco(new Endereco());
		estado = new Estado();
		estados = fachadaControlFrota.recuperarEstados();
		listaEstados = FacesUtil.toListSelectItem(estados);
		cidade = new Cidade();
		cidades = new ArrayList<Cidade>();
		listaCidades = new ArrayList<SelectItem>();
	}

	/* ########################## Métodos de Ação ########################### */

	public void excluir() {
		try {
			fachadaControlFrota.excluirMotorista(motorista);
			listaMotoristas.remove(motorista);
		} catch (Exception e) {
			LOGGER.debug("Erro: " + e);
			FacesUtil.errorMessage("Erro ao excluir motorista!");
		}
	}

	public void limparListaMotoristas() {
		listaMotoristas.clear();
		nome = new String();
	}

	public void limparTela() {
		inicializar();
	}

	private void preencheDados(Motorista motorista) {
		pessoaFisica = motorista.getPessoaFisica();
		cidade = pessoaFisica.getEndereco().getCidade();
		estado = cidade.getEstado();
		recuperarCidadesPorEstado();
	}

	public void recuperarCidadesPorEstado() {
		try {
			cidades = fachadaControlFrota.recuperarCidades(estado);
			listaCidades = FacesUtil.toListSelectItem(cidades);
		} catch (Exception e) {
			LOGGER.debug("Erro: " + e);
			FacesUtil.errorMessage("Erro ao recuperar cidades!");
		}
	}

	public void recuperarMotoristasPorNome() {
		try {
			listaMotoristas = fachadaControlFrota.recuperarMotoristas(nome);
		} catch (Exception e) {
			LOGGER.debug("Erro: " + e);
			FacesUtil.errorMessage("Erro ao recuperar lista de motoristas!");
		}
	}

	public void recuperarMotoristaPorCnh() {
		try {
			motorista = fachadaControlFrota.recuperarMotorista(motorista.getCnh());
		} catch (Exception e) {
			LOGGER.debug("Erro: " + e);
			FacesUtil.errorMessage("Erro ao recuperar motorista!");
		}
	}

	public void recuperarMotoristaPorCpf() {
		if (ValidacaoUtil.validarCPF(pessoaFisica.getCpf())) {
			try {
				motorista = fachadaControlFrota.recuperarMotoristaPorCpf(pessoaFisica.getCpf());
				if (motorista == null) {
					motorista = new Motorista();
				} else {
					preencheDados(motorista);
				}
			} catch (Exception e) {
				LOGGER.debug("Erro: " + e);
				FacesUtil.errorMessage("Erro ao recuperar motorista!");
			}
		} else {
			limparTela();
			FacesUtil.errorMessage("CPF inválido!");
		}
	}

	public void salvar() {
		if (ValidacaoUtil.validarCPF(pessoaFisica.getCpf())) {
			try {
				pessoaFisica.getEndereco().setCidade(cidade);
				motorista.setPessoaFisica(pessoaFisica);
				fachadaControlFrota.salvarOuAtualizarMotorista(motorista);
				limparTela();
				FacesUtil.informationMessage("Motorista salvo/atualizado com sucesso.");
			} catch (Exception e) {
				LOGGER.debug("Erro: " + e);
				FacesUtil.errorMessage("Erro ao salvar/atualizar motorista!");
			}
		} else {
			limparTela();
			FacesUtil.errorMessage("CPF inválido!");
		}
	}

	/* ############################ Gets e Sets ############################# */

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		if (motorista.getCodigo() != null) {
			preencheDados(motorista);
		}
		this.motorista = motorista;
	}

	public List<Motorista> getListaMotoristas() {
		return listaMotoristas;
	}

	public void setListaMotoristas(List<Motorista> listaMotoristas) {
		this.listaMotoristas = listaMotoristas;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<SelectItem> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(List<SelectItem> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<SelectItem> getListaCidades() {
		return listaCidades;
	}

	public void setListaCidades(List<SelectItem> listaCidades) {
		this.listaCidades = listaCidades;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

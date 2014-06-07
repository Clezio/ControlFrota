package br.com.abcdario.controlfrota.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.abcdario.controlfrota.fachada.FachadaControlFrota;
import br.com.abcdario.controlfrota.modelo.Veiculo;
import br.com.abcdario.controlfrota.util.FacesUtil;

@ManagedBean(name = "veiculoBean")
@Controller("veiculoBean")
@Scope("view")
public class VeiculoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Log LOGGER = LogFactory.getLog(VeiculoBean.class);

	private final FachadaControlFrota fachadaControlFrota;

	private Veiculo veiculo;
	private List<Veiculo> listaVeiculos;

	private String placa;

	@Autowired
	public VeiculoBean(FachadaControlFrota fachadaControlFrota) {
		this.fachadaControlFrota = fachadaControlFrota;
		inicializar();
	}

	private void inicializar() {
		veiculo = new Veiculo();
		listaVeiculos = new ArrayList<Veiculo>();
	}

	/* ########################## Métodos de Ação ########################### */

	public void excluir() {
		try {
			fachadaControlFrota.excluirVeiculo(veiculo);
			listaVeiculos.remove(veiculo);
		} catch (Exception e) {
			LOGGER.debug("Erro: " + e);
			FacesUtil.errorMessage("Erro ao excluir veículo!");
		}
	}

	public void limparListaVeiculos() {
		listaVeiculos.clear();
		placa = new String();
	}

	public void limparTela() {
		inicializar();
	}

	public void recuperarVeiculos() {
		try {
			listaVeiculos = fachadaControlFrota.recuperarVeiculoPorPartePlaca(placa);
		} catch (Exception e) {
			LOGGER.debug("Erro: " + e);
			FacesUtil.errorMessage("Erro ao recuperar lista de veículos!");
		}
	}

	public void recuperarVeiculo() {
		try {
			veiculo = fachadaControlFrota.recuperarVeiculoPorPlaca(veiculo.getPlaca());
			if (veiculo == null) {
				veiculo = new Veiculo();
			}
		} catch (Exception e) {
			LOGGER.debug("Erro: " + e);
			FacesUtil.errorMessage("Erro ao recuperar veículo!");
		}
	}

	public void salvar() {
		try {
			veiculo.setPlaca(veiculo.getPlaca().replace("-", ""));
			fachadaControlFrota.salvarOuAtualizarVeiculo(veiculo);
			limparTela();
			FacesUtil.informationMessage("Veículo salvo/atualizado com sucesso.");
		} catch (Exception e) {
			LOGGER.debug("Erro: " + e);
			FacesUtil.errorMessage("Erro ao salvar/atualizar veículo!");
		}
	}

	/* ############################ Gets e Sets ############################# */

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

}

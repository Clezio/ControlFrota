package br.com.abcdario.controlfrota.visao;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.abcdario.controlfrota.fachada.FachadaControlFrota;
import br.com.abcdario.controlfrota.modelo.Veiculo;
import br.com.abcdario.controlfrota.util.FacesUtil;

@ManagedBean(name = "autorizarSolicitacaoBean")
@Controller("autorizarSolicitacaoBean")
@Scope("view")
public class AutorizarSolicitacaoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Log LOGGER = LogFactory.getLog(AutorizarSolicitacaoBean.class);

	private Veiculo veiculo;
	private List<Veiculo> veiculos;
	private List<SelectItem> listaVeiculos;

	private final FachadaControlFrota fachadaControlFrota;

	@Autowired
	public AutorizarSolicitacaoBean(FachadaControlFrota fachadaControlFrota) {
		this.fachadaControlFrota = fachadaControlFrota;
		inicializar();
	}

	private void inicializar() {
		veiculos = fachadaControlFrota.recuperarVeiculos();
		listaVeiculos = FacesUtil.toListSelectItem(veiculos);
	}

	/* ########################## Métodos de Ação ########################### */

	public void excluir() {
		try {

		} catch (Exception e) {
			LOGGER.debug("Erro: " + e);
			FacesUtil.errorMessage("Erro ao excluir solicitação!");
		}
	}

	/* ############################ Gets e Sets ############################# */

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public List<SelectItem> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(List<SelectItem> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}

}

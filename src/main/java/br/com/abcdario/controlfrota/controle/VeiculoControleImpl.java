package br.com.abcdario.controlfrota.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.abcdario.controlfrota.dao.VeiculoDAO;
import br.com.abcdario.controlfrota.modelo.Veiculo;

@Component
@Transactional(propagation = Propagation.MANDATORY)
public class VeiculoControleImpl implements VeiculoControle {

	private final VeiculoDAO veiculoDAO;

	@Autowired
	public VeiculoControleImpl(VeiculoDAO veiculoDAO) {
		this.veiculoDAO = veiculoDAO;
	}

	@Override
	public void salvarOuAtualizar(Veiculo veiculo) {
		veiculoDAO.salvarOuAtualizar(veiculo);
	}

	@Override
	public void excluir(Veiculo veiculo) {
		veiculoDAO.excluir(veiculo);
	}

	@Override
	public Veiculo recuperar(Integer codigo) {
		return veiculoDAO.recuperar(codigo);
	}

	@Override
	public List<Veiculo> recuperar() {
		return veiculoDAO.recuperar();
	}

	@Override
	public Veiculo recuperarPorPlaca(String placa) {
		return veiculoDAO.recuperarPorPlaca(placa);
	}

	@Override
	public List<Veiculo> recuperar(String partePlaca) {
		return veiculoDAO.recuperar(partePlaca);
	}

	@Override
	public Veiculo recuperarComNotas(Veiculo veiculo) {
		return veiculoDAO.recuperarComNotas(veiculo);
	}

}

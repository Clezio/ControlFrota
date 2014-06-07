package br.com.abcdario.controlfrota.controle;

import java.util.List;

import br.com.abcdario.controlfrota.modelo.Veiculo;

public interface VeiculoControle {

	void salvarOuAtualizar(Veiculo veiculo);

	void excluir(Veiculo veiculo);

	Veiculo recuperar(Integer codigo);

	List<Veiculo> recuperar();

	Veiculo recuperarPorPlaca(String placa);

	List<Veiculo> recuperar(String partePlaca);

	Veiculo recuperarComNotas(Veiculo veiculo);

}

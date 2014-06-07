package br.com.abcdario.controlfrota.dao;

import java.util.List;

import br.com.abcdario.controlfrota.modelo.Veiculo;

public interface VeiculoDAO extends GenericDAO<Veiculo, Integer> {

	Veiculo recuperarPorPlaca(String placa);

	List<Veiculo> recuperar(String partePlaca);

	Veiculo recuperarComNotas(Veiculo veiculo);

}

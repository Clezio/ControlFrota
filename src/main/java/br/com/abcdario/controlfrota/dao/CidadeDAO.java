package br.com.abcdario.controlfrota.dao;

import java.util.List;

import br.com.abcdario.controlfrota.modelo.Cidade;
import br.com.abcdario.controlfrota.modelo.Estado;

public interface CidadeDAO extends GenericDAO<Cidade, Integer> {

	List<Cidade> recuperar(Estado estado);

}

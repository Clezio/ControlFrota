package br.com.abcdario.controlfrota.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, K extends Serializable> {

	void salvar(T objeto);

	void atualizar(T objeto);

	void salvarOuAtualizar(T objeto);

	void excluir(T objeto);

	T recuperar(K codigo);

	List<T> recuperar();

}

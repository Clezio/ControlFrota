package br.com.abcdario.controlfrota.controle;

import java.util.List;

import br.com.abcdario.controlfrota.modelo.Perfil;

public interface PerfilControle {

	void salvarOuAtualizar(Perfil perfil);

	void excluir(Perfil perfil);

	Perfil recuperar(Integer codigo);

	List<Perfil> recuperar();

}

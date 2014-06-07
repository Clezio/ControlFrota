package br.com.abcdario.controlfrota.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.abcdario.controlfrota.dao.PerfilDAO;
import br.com.abcdario.controlfrota.modelo.Perfil;

@Component
@Transactional(propagation = Propagation.MANDATORY)
public class PerfilControleImpl implements PerfilControle {

	private final PerfilDAO perfilDAO;

	@Autowired
	public PerfilControleImpl(PerfilDAO perfilDAO) {
		this.perfilDAO = perfilDAO;
	}

	@Override
	public void salvarOuAtualizar(Perfil perfil) {
		perfilDAO.salvarOuAtualizar(perfil);
	}

	@Override
	public void excluir(Perfil perfil) {
		perfilDAO.excluir(perfil);
	}

	@Override
	public Perfil recuperar(Integer codigo) {
		return perfilDAO.recuperar(codigo);
	}

	@Override
	public List<Perfil> recuperar() {
		return perfilDAO.recuperar();
	}

}

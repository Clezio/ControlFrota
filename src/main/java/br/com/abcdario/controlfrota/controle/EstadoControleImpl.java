package br.com.abcdario.controlfrota.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.abcdario.controlfrota.dao.EstadoDAO;
import br.com.abcdario.controlfrota.modelo.Estado;

@Component
@Transactional(propagation = Propagation.MANDATORY)
public class EstadoControleImpl implements EstadoControle {

	private final EstadoDAO estadoDAO;

	@Autowired
	public EstadoControleImpl(EstadoDAO estadoDAO) {
		this.estadoDAO = estadoDAO;
	}

	@Override
	public Estado recuperar(Integer codigo) {
		return estadoDAO.recuperar(codigo);
	}

	@Override
	public List<Estado> recuperar() {
		return estadoDAO.recuperar();
	}

}

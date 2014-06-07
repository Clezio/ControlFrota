package br.com.abcdario.controlfrota.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.abcdario.controlfrota.dao.CidadeDAO;
import br.com.abcdario.controlfrota.modelo.Cidade;
import br.com.abcdario.controlfrota.modelo.Estado;

@Component
@Transactional(propagation = Propagation.MANDATORY)
public class CidadeControleImpl implements CidadeControle {

	private final CidadeDAO cidadeDAO;

	@Autowired
	public CidadeControleImpl(CidadeDAO cidadeDAO) {
		this.cidadeDAO = cidadeDAO;
	}

	@Override
	public Cidade recuperar(Integer codigo) {
		return cidadeDAO.recuperar(codigo);
	}

	@Override
	public List<Cidade> recuperar() {
		return cidadeDAO.recuperar();
	}

	@Override
	public List<Cidade> recuperar(Estado estado) {
		return cidadeDAO.recuperar(estado);
	}

}

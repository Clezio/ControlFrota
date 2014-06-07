package br.com.abcdario.controlfrota.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.abcdario.controlfrota.modelo.Perfil;

@Component
public class PerfilDAOImpl extends GenericDAOImpl<Perfil, Integer> implements PerfilDAO {

	@Autowired
	public PerfilDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

}

package br.com.abcdario.controlfrota.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.abcdario.controlfrota.modelo.Estado;

@Component
public class EstadoDAOImpl extends GenericDAOImpl<Estado, Integer> implements EstadoDAO {

	@Autowired
	public EstadoDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

}

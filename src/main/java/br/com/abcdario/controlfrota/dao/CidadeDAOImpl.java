package br.com.abcdario.controlfrota.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.abcdario.controlfrota.modelo.Cidade;
import br.com.abcdario.controlfrota.modelo.Estado;

@Component
public class CidadeDAOImpl extends GenericDAOImpl<Cidade, Integer> implements CidadeDAO {

	@Autowired
	public CidadeDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> recuperar(Estado estado) {
		return getSession().createCriteria(Cidade.class).add(Restrictions.eq("estado", estado)).list();
	}

}
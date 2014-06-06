package br.com.abcdario.controlfrota.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class GenericDAOImpl<T, K extends Serializable> implements GenericDAO<T, K> {

	protected Class<T> claz;
	protected SessionFactory sessionFactory;
	private static final Log LOGGER = LogFactory.getLog(GenericDAOImpl.class);

	@SuppressWarnings("unchecked")
	public GenericDAOImpl(SessionFactory sessionFactory) {
		this.claz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY, readOnly = false)
	public void salvar(T objeto) {
		try {
			getSession().save(objeto);
		} catch (HibernateException e) {
			LOGGER.debug("Erro: " + e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY, readOnly = false)
	public void atualizar(T objeto) {
		try {
			getSession().update(objeto);
		} catch (HibernateException e) {
			LOGGER.debug("Erro: " + e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY, readOnly = false)
	public void salvarOuAtualizar(T objeto) {
		try {
			getSession().saveOrUpdate(objeto);
		} catch (HibernateException e) {
			LOGGER.debug("Erro: " + e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY, readOnly = false)
	public void excluir(T objeto) {
		try {
			getSession().delete(objeto);
		} catch (HibernateException e) {
			LOGGER.debug("Erro: " + e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T recuperar(K codigo) {
		return (T) getSession().get(claz, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> recuperar() {
		return getSession().createCriteria(claz).list();
	}

}

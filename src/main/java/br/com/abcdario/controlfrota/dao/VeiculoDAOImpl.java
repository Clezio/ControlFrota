package br.com.abcdario.controlfrota.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.abcdario.controlfrota.modelo.Veiculo;

@Component
public class VeiculoDAOImpl extends GenericDAOImpl<Veiculo, Integer> implements VeiculoDAO {

	@Autowired
	public VeiculoDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public Veiculo recuperarPorPlaca(String placa) {
		return (Veiculo) getSession().createCriteria(Veiculo.class).add(Restrictions.eq("placa", placa)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Veiculo> recuperar(String partePlaca) {
		return getSession().createCriteria(Veiculo.class).add(Restrictions.like("placa", partePlaca, MatchMode.ANYWHERE))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	@Override
	public Veiculo recuperarComNotas(Veiculo veiculo) {
		return (Veiculo) getSession().createCriteria(Veiculo.class).add(Restrictions.eq("codigo", veiculo.getCodigo()))
				.setFetchMode("listaNotasAbastecimento", FetchMode.JOIN).uniqueResult();
	}

}

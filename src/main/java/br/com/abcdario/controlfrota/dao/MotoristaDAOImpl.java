package br.com.abcdario.controlfrota.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.abcdario.controlfrota.modelo.Motorista;
import br.com.abcdario.controlfrota.modelo.PessoaFisica;

@Component
public class MotoristaDAOImpl extends GenericDAOImpl<Motorista, Integer> implements MotoristaDAO {

	@Autowired
	public MotoristaDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public Motorista recuperarCpf(Long cpf) {
		PessoaFisica pessoaFisica = (PessoaFisica) getSession().createCriteria(PessoaFisica.class)
				.add(Restrictions.eq("cpf", cpf)).uniqueResult();
		if (pessoaFisica != null) {
			if (pessoaFisica.getMotorista() == null) {
				Motorista motorista = new Motorista();
				pessoaFisica.setInstrutor(motorista);
				motorista.setPessoaFisica(pessoaFisica);
				return motorista;
			} else {
				return pessoaFisica.getMotorista();
			}
		}
		return null;
	}

	@Override
	public Motorista recuperar(Long cnh) {
		return (Motorista) getSession().createCriteria(Motorista.class).add(Restrictions.eq("cnh", cnh)).uniqueResult();
	}

	@Override
	public Motorista recuperar(PessoaFisica pessoaFisica) {
		return (Motorista) getSession().createCriteria(Motorista.class).add(Restrictions.eq("pessoaFisica", pessoaFisica))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Motorista> recuperar(String nome) {
		List<PessoaFisica> pessoasFisicas = getSession().createCriteria(PessoaFisica.class)
				.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE)).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
		if (pessoasFisicas != null) {
			List<Motorista> motoristas = new ArrayList<Motorista>();
			for (PessoaFisica pessoaFisica : pessoasFisicas) {
				if (pessoaFisica.getMotorista() != null) {
					motoristas.add(pessoaFisica.getMotorista());
				}
			}
			return motoristas;
		}
		return null;
	}

}

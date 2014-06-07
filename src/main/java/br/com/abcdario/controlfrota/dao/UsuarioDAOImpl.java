package br.com.abcdario.controlfrota.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.abcdario.controlfrota.modelo.PessoaFisica;
import br.com.abcdario.controlfrota.modelo.Usuario;

@Component
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO {

	@Autowired
	public UsuarioDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public Usuario recuperarCpf(Long cpf) {
		PessoaFisica pessoaFisica = (PessoaFisica) getSession().createCriteria(PessoaFisica.class)
				.add(Restrictions.eq("cpf", cpf)).uniqueResult();
		if (pessoaFisica == null) {
			return null;
		}
		return pessoaFisica.getUsuario();
	}

	@Override
	public Usuario recuperar(PessoaFisica pessoaFisica) {
		return (Usuario) getSession().createCriteria(Usuario.class).add(Restrictions.eq("pessoa", pessoaFisica)).uniqueResult();
	}

	@Override
	public Usuario recuperarPorLogin(String login) {
		return (Usuario) getSession().createCriteria(Usuario.class).add(Restrictions.eq("login", login)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> recuperarPorNome(String nome) {
		List<PessoaFisica> pessoasFisicas = getSession().createCriteria(PessoaFisica.class)
				.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE)).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
		if (pessoasFisicas != null) {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			for (PessoaFisica pessoaFisica : pessoasFisicas) {
				if (pessoaFisica.getUsuario() != null) {
					usuarios.add(pessoaFisica.getUsuario());
				}
			}
			return usuarios;
		}
		return null;
	}

}

package br.com.abcdario.controlfrota.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.abcdario.controlfrota.dao.UsuarioDAO;
import br.com.abcdario.controlfrota.modelo.PessoaFisica;
import br.com.abcdario.controlfrota.modelo.Usuario;

@Component
@Transactional(propagation = Propagation.MANDATORY)
public class UsuarioControleImpl implements UsuarioControle {

	private final UsuarioDAO usuarioDAO;

	@Autowired
	public UsuarioControleImpl(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	public void salvarOuAtualizar(Usuario usuario) {
		usuarioDAO.salvarOuAtualizar(usuario);
	}

	@Override
	public void excluir(Usuario usuario) {
		usuario.setAtivo(false);
		usuarioDAO.salvarOuAtualizar(usuario);
	}

	@Override
	public Usuario recuperar(Integer codigo) {
		return usuarioDAO.recuperar(codigo);
	}

	@Override
	public List<Usuario> recuperar() {
		return usuarioDAO.recuperar();
	}

	@Override
	public Usuario recuperarCpf(Long cpf) {
		return usuarioDAO.recuperarCpf(cpf);
	}

	@Override
	public Usuario recuperar(PessoaFisica pessoaFisica) {
		return usuarioDAO.recuperar(pessoaFisica);
	}

	@Override
	public Usuario recuperarPorLogin(String login) {
		return usuarioDAO.recuperarPorLogin(login);
	}

	@Override
	public List<Usuario> recuperarPorNome(String nome) {
		return usuarioDAO.recuperarPorNome(nome);
	}

}

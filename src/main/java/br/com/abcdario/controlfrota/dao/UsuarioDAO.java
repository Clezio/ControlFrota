package br.com.abcdario.controlfrota.dao;

import java.util.List;

import br.com.abcdario.controlfrota.modelo.PessoaFisica;
import br.com.abcdario.controlfrota.modelo.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, Integer> {

	Usuario recuperarCpf(Long cpf);

	Usuario recuperar(PessoaFisica pessoaFisica);

	Usuario recuperarPorLogin(String login);

	List<Usuario> recuperarPorNome(String nome);
}

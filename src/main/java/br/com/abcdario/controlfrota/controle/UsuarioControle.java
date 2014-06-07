package br.com.abcdario.controlfrota.controle;

import java.util.List;

import br.com.abcdario.controlfrota.modelo.PessoaFisica;
import br.com.abcdario.controlfrota.modelo.Usuario;

public interface UsuarioControle {

	void salvarOuAtualizar(Usuario usuario);

	void excluir(Usuario usuario);

	Usuario recuperar(Integer codigo);

	List<Usuario> recuperar();

	Usuario recuperarCpf(Long cpf);

	Usuario recuperar(PessoaFisica pessoaFisica);

	Usuario recuperarPorLogin(String login);

	List<Usuario> recuperarPorNome(String nome);

}

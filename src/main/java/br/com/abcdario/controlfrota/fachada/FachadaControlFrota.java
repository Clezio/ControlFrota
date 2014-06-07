package br.com.abcdario.controlfrota.fachada;

import java.util.List;

import br.com.abcdario.controlfrota.modelo.Cidade;
import br.com.abcdario.controlfrota.modelo.Estado;
import br.com.abcdario.controlfrota.modelo.Perfil;
import br.com.abcdario.controlfrota.modelo.PessoaFisica;
import br.com.abcdario.controlfrota.modelo.Usuario;
import br.com.abcdario.controlfrota.modelo.Veiculo;

public interface FachadaControlFrota {

	/* ############################### Cidade ############################### */

	Cidade recuperarCidade(Integer codigo);

	List<Cidade> recuperarCidade();

	List<Cidade> recuperarCidades(Estado estado);

	/* ############################### Estado ############################### */

	Estado recuperarEstado(Integer codigo);

	List<Estado> recuperarEstados();

	/* ############################### Perfil ############################### */

	void salvarOuAtualizarPerfil(Perfil perfil);

	void excluirPerfil(Perfil perfil);

	Perfil recuperarPerfil(Integer codigo);

	List<Perfil> recuperarPerfis();

	/* ############################## Usuário ############################### */

	void salvarOuAtualizarUsuario(Usuario usuario);

	void excluirUsuario(Usuario usuario);

	Usuario recuperarUsuario(Integer codigo);

	List<Usuario> recuperarUsuarios();

	Usuario recuperarUsuarioPorCpf(Long cpf);

	Usuario recuperarUsuario(PessoaFisica pessoaFisica);

	Usuario recuperarUsuarioPorLogin(String login);

	List<Usuario> recuperarUsuarioPorNome(String nome);

	/* ############################## Veículo ############################### */

	void salvarOuAtualizarVeiculo(Veiculo veiculo);

	void excluirVeiculo(Veiculo veiculo);

	Veiculo recuperarVeiculo(Integer codigo);

	List<Veiculo> recuperarVeiculos();

	Veiculo recuperarVeiculoPorPlaca(String placa);

	List<Veiculo> recuperarVeiculoPorPartePlaca(String partePlaca);
}

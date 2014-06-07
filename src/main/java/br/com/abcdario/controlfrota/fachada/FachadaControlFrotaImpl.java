package br.com.abcdario.controlfrota.fachada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.abcdario.controlfrota.controle.CidadeControle;
import br.com.abcdario.controlfrota.controle.EstadoControle;
import br.com.abcdario.controlfrota.controle.MotoristaControle;
import br.com.abcdario.controlfrota.controle.PerfilControle;
import br.com.abcdario.controlfrota.controle.UsuarioControle;
import br.com.abcdario.controlfrota.controle.VeiculoControle;
import br.com.abcdario.controlfrota.modelo.Cidade;
import br.com.abcdario.controlfrota.modelo.Estado;
import br.com.abcdario.controlfrota.modelo.Motorista;
import br.com.abcdario.controlfrota.modelo.Perfil;
import br.com.abcdario.controlfrota.modelo.PessoaFisica;
import br.com.abcdario.controlfrota.modelo.Usuario;
import br.com.abcdario.controlfrota.modelo.Veiculo;

@Component
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class FachadaControlFrotaImpl implements FachadaControlFrota {

	@Autowired
	private CidadeControle cidadeControle;
	@Autowired
	private EstadoControle estadoControle;
	@Autowired
	private MotoristaControle motoristaControle;
	@Autowired
	private PerfilControle perfilControle;
	@Autowired
	private UsuarioControle usuarioControle;
	@Autowired
	private VeiculoControle veiculoControle;

	/* ############################### Cidade ############################### */

	@Override
	public Cidade recuperarCidade(Integer codigo) {
		return cidadeControle.recuperar(codigo);
	}

	@Override
	public List<Cidade> recuperarCidade() {
		return cidadeControle.recuperar();
	}

	@Override
	public List<Cidade> recuperarCidades(Estado estado) {
		return cidadeControle.recuperar(estado);
	}

	/* ############################### Estado ############################### */

	@Override
	public Estado recuperarEstado(Integer codigo) {
		return estadoControle.recuperar(codigo);
	}

	@Override
	public List<Estado> recuperarEstados() {
		return estadoControle.recuperar();
	}

	/* ############################# Motorista ############################## */

	@Override
	public void salvarOuAtualizarMotorista(Motorista motorista) {
		motoristaControle.salvarOuAtualizar(motorista);
	}

	@Override
	public void excluirMotorista(Motorista motorista) {
		motoristaControle.excluir(motorista);
	}

	@Override
	public Motorista recuperarMotorista(Integer codigo) {
		return motoristaControle.recuperar(codigo);
	}

	@Override
	public List<Motorista> recuperarMotoristas() {
		return motoristaControle.recuperar();
	}

	@Override
	public Motorista recuperarMotorista(Long cnh) {
		return motoristaControle.recuperar(cnh);
	}

	@Override
	public Motorista recuperarMotoristaPorCpf(Long cpf) {
		return motoristaControle.recuperarCpf(cpf);
	}

	@Override
	public Motorista recuperarMotorista(PessoaFisica pessoaFisica) {
		return motoristaControle.recuperar(pessoaFisica);
	}

	@Override
	public List<Motorista> recuperarMotoristas(String nome) {
		return motoristaControle.recuperar(nome);
	}

	/* ############################### Perfil ############################### */

	@Override
	public void salvarOuAtualizarPerfil(Perfil perfil) {
		perfilControle.salvarOuAtualizar(perfil);
	}

	@Override
	public void excluirPerfil(Perfil perfil) {
		perfilControle.excluir(perfil);
	}

	@Override
	public Perfil recuperarPerfil(Integer codigo) {
		return perfilControle.recuperar(codigo);
	}

	@Override
	public List<Perfil> recuperarPerfis() {
		return perfilControle.recuperar();
	}

	/* ############################## Usuário ############################### */

	@Override
	public void salvarOuAtualizarUsuario(Usuario usuario) {
		usuarioControle.salvarOuAtualizar(usuario);
	}

	@Override
	public void excluirUsuario(Usuario usuario) {
		usuarioControle.excluir(usuario);
	}

	@Override
	public Usuario recuperarUsuario(Integer codigo) {
		return usuarioControle.recuperar(codigo);
	}

	@Override
	public List<Usuario> recuperarUsuarios() {
		return usuarioControle.recuperar();
	}

	@Override
	public Usuario recuperarUsuarioPorCpf(Long cpf) {
		return usuarioControle.recuperarCpf(cpf);
	}

	@Override
	public Usuario recuperarUsuario(PessoaFisica pessoaFisica) {
		return usuarioControle.recuperar(pessoaFisica);
	}

	@Override
	public Usuario recuperarUsuarioPorLogin(String login) {
		return usuarioControle.recuperarPorLogin(login);
	}

	@Override
	public List<Usuario> recuperarUsuarioPorNome(String nome) {
		return usuarioControle.recuperarPorNome(nome);
	}

	/* ############################## Veículo ############################### */

	@Override
	public void salvarOuAtualizarVeiculo(Veiculo veiculo) {
		veiculoControle.salvarOuAtualizar(veiculo);
	}

	@Override
	public void excluirVeiculo(Veiculo veiculo) {
		veiculoControle.excluir(veiculo);
	}

	@Override
	public Veiculo recuperarVeiculo(Integer codigo) {
		return veiculoControle.recuperar(codigo);
	}

	@Override
	public List<Veiculo> recuperarVeiculos() {
		return veiculoControle.recuperar();
	}

	@Override
	public Veiculo recuperarVeiculoPorPlaca(String placa) {
		return veiculoControle.recuperarPorPlaca(placa);
	}

	@Override
	public List<Veiculo> recuperarVeiculoPorPartePlaca(String partePlaca) {
		return veiculoControle.recuperar(partePlaca);
	}

}

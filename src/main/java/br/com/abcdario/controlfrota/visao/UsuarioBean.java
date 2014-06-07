package br.com.abcdario.controlfrota.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;

import br.com.abcdario.controlfrota.fachada.FachadaControlFrota;
import br.com.abcdario.controlfrota.modelo.Cidade;
import br.com.abcdario.controlfrota.modelo.Endereco;
import br.com.abcdario.controlfrota.modelo.Estado;
import br.com.abcdario.controlfrota.modelo.Perfil;
import br.com.abcdario.controlfrota.modelo.PessoaFisica;
import br.com.abcdario.controlfrota.modelo.Usuario;
import br.com.abcdario.controlfrota.util.FacesUtil;
import br.com.abcdario.controlfrota.util.ValidacaoUtil;

@ManagedBean(name = "usuarioBean")
@Controller("usuarioBean")
@Scope("view")
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Log LOGGER = LogFactory.getLog(UsuarioBean.class);

	private final FachadaControlFrota fachadaControlFrota;

	private Usuario usuario;
	private List<Usuario> listaUsuarios;
	private PessoaFisica pessoaFisica;
	private Estado estado;
	private List<Estado> estados;
	private List<SelectItem> listaEstados;
	private Cidade cidade;
	private List<Cidade> cidades;
	private List<SelectItem> listaCidades;
	private List<Perfil> listaPerfis;
	private DualListModel<Perfil> perfis;

	private String nome;
	private boolean alterarSenha;

	private Md5PasswordEncoder geradorSenhaMD5;

	@Autowired
	public UsuarioBean(FachadaControlFrota fachadaControlFrota) {
		this.fachadaControlFrota = fachadaControlFrota;
		inicializar();
	}

	private void inicializar() {
		usuario = new Usuario();
		usuario.setPerfis(new ArrayList<Perfil>());
		listaUsuarios = new ArrayList<Usuario>();
		pessoaFisica = new PessoaFisica();
		pessoaFisica.setEndereco(new Endereco());
		estado = new Estado();
		estados = fachadaControlFrota.recuperarEstados();
		listaEstados = FacesUtil.toListSelectItem(estados);
		cidade = new Cidade();
		cidades = new ArrayList<Cidade>();
		listaCidades = new ArrayList<SelectItem>();
		listaPerfis = fachadaControlFrota.recuperarPerfis();
		perfis = new DualListModel<Perfil>(listaPerfis, usuario.getPerfis());

		geradorSenhaMD5 = new Md5PasswordEncoder();
	}

	/* ########################## Métodos de Ação ########################### */

	public void excluir() {
		try {
			fachadaControlFrota.excluirUsuario(usuario);
			listaUsuarios.remove(usuario);
		} catch (Exception e) {
			LOGGER.debug("Erro: " + e);
			FacesUtil.errorMessage("Erro ao excluir usuário!");
		}
	}

	public void limparListaUsuarios() {
		listaUsuarios.clear();
		nome = new String();
	}

	public void limparTela() {
		inicializar();
	}

	private void preencheDados(Usuario usuario) {
		pessoaFisica = usuario.getPessoaFisica();
		perfis.setSource(fachadaControlFrota.recuperarPerfis());
		perfis.setTarget(usuario.getPerfis());
		for (Perfil perfil : perfis.getTarget()) {
			perfis.getSource().remove(perfil);
		}
		cidade = pessoaFisica.getEndereco().getCidade();
		estado = cidade.getEstado();
		recuperarCidadesPorEstado();
	}

	public void recuperarCidadesPorEstado() {
		try {
			cidades = fachadaControlFrota.recuperarCidades(estado);
			listaCidades = FacesUtil.toListSelectItem(cidades);
		} catch (Exception e) {
			LOGGER.debug("Erro: " + e);
			FacesUtil.errorMessage("Erro ao recuperar cidades!");
		}
	}

	public void recuperarUsuariosPorNome() {
		try {
			listaUsuarios = fachadaControlFrota.recuperarUsuarioPorNome(nome);
		} catch (Exception e) {
			LOGGER.debug("Erro: " + e);
			FacesUtil.errorMessage("Erro ao recuperar lista de usuários!");
		}
	}

	public void recuperarUsuarioPorCpf() {
		if (ValidacaoUtil.validarCPF(pessoaFisica.getCpf())) {
			try {
				usuario = fachadaControlFrota.recuperarUsuarioPorCpf(pessoaFisica.getCpf());
				if (usuario == null) {
					usuario = new Usuario();
				} else {
					preencheDados(usuario);
				}
			} catch (Exception e) {
				LOGGER.debug("Erro: " + e);
				FacesUtil.errorMessage("Erro ao recuperar usuário!");
			}
		} else {
			limparTela();
			FacesUtil.errorMessage("CPF inválido!");
		}
	}

	public void salvar() {
		if (ValidacaoUtil.validarCPF(pessoaFisica.getCpf())) {
			if (usuario.getSenha().length() >= 6) {
				try {
					pessoaFisica.getEndereco().setCidade(cidade);
					usuario.setPessoaFisica(pessoaFisica);
					usuario.setAtivo(true);
					usuario.setPerfis(perfis.getTarget());

					usuario.setSenha(geradorSenhaMD5.encodePassword(usuario.getSenha(), null));

					fachadaControlFrota.salvarOuAtualizarUsuario(usuario);
					limparTela();
					FacesUtil.informationMessage("Usuario salvo/atualizado com sucesso.");
				} catch (Exception e) {
					LOGGER.debug("Erro: " + e);
					FacesUtil.errorMessage("Erro ao salvar/atualizar usuário!");
				}
			} else {
				FacesUtil.errorMessage("Senha: valor menor que 6!");
			}
		} else {
			FacesUtil.errorMessage("CPF inválido!");
		}

	}

	/* ############################ Gets e Sets ############################# */

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		if (usuario.getCodigo() != null) {
			preencheDados(usuario);
		}
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<SelectItem> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(List<SelectItem> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<SelectItem> getListaCidades() {
		return listaCidades;
	}

	public void setListaCidades(List<SelectItem> listaCidades) {
		this.listaCidades = listaCidades;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public DualListModel<Perfil> getPerfis() {
		for (Perfil perfil : perfis.getSource()) {
			if (perfil.getDescricao().equals("ROLE_ADM")) {
				perfil.setDescricao("Administrador");
			} else if (perfil.getDescricao().equals("ROLE_USER")) {
				perfil.setDescricao("Usuário Comum");
			}
		}
		for (Perfil perfil : perfis.getTarget()) {
			if (perfil.getDescricao().equals("ROLE_ADM")) {
				perfil.setDescricao("Administrador");
			} else if (perfil.getDescricao().equals("ROLE_USER")) {
				perfil.setDescricao("Usuário Comum");
			}
		}
		return perfis;
	}

	public void setPerfis(DualListModel<Perfil> perfis) {
		for (Perfil perfil : perfis.getSource()) {
			if (perfil.getDescricao().equals("Administrador")) {
				perfil.setDescricao("ROLE_ADM");
			} else if (perfil.getDescricao().equals("Usuário Comum")) {
				perfil.setDescricao("ROLE_USER");
			}
		}
		for (Perfil perfil : perfis.getTarget()) {
			if (perfil.getDescricao().equals("Administrador")) {
				perfil.setDescricao("ROLE_ADM");
			} else if (perfil.getDescricao().equals("Usuário Comum")) {
				perfil.setDescricao("ROLE_USER");
			}
		}
		this.perfis = perfis;
	}

	public boolean isAlterarSenha() {
		return alterarSenha;
	}

	public void setAlterarSenha(boolean alterarSenha) {
		this.alterarSenha = alterarSenha;
	}

}

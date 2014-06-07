package br.com.abcdario.controlfrota.visao;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import br.com.abcdario.controlfrota.modelo.Usuario;
import br.com.abcdario.controlfrota.util.FacesUtil;

@ManagedBean(name = "loginBean")
@Controller("loginBean")
@Scope("session")
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Log LOGGER = LogFactory.getLog(LoginBean.class);

	private Usuario usuario;

	public LoginBean() {

	}

	/* ########################## Métodos de Ação ########################### */

	public void logar() {
		try {
			RequestDispatcher dispatcher = FacesUtil.getRequest().getRequestDispatcher("/j_spring_security_check");
			dispatcher.forward(FacesUtil.getRequest(), FacesUtil.getResponse());
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception e) {
			FacesUtil.errorMessage(e.getMessage());
			LOGGER.debug("Erro: " + e);
		}
	}

	public void logout() {
		FacesUtil.informationMessage("Sessão finalizada com sucesso");
		try {
			RequestDispatcher dispatcher = FacesUtil.getRequest().getRequestDispatcher("/j_spring_security_logout");
			dispatcher.forward(FacesUtil.getRequest(), FacesUtil.getResponse());
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception e) {
			FacesUtil.errorMessage("Erro ao sair do sistema");
			LOGGER.debug("Erro: " + e);
		}
	}

	public Usuario getUsuario() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			Object obj = authentication.getPrincipal();
			if (obj instanceof Usuario) {
				return (Usuario) obj;
			}
		}
		return usuario;
	}

}

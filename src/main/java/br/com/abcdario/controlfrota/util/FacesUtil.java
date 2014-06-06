package br.com.abcdario.controlfrota.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public final class FacesUtil {

	private FacesUtil() {
	}

	/**
	 * Método utilizado para retornar o caminho real de um diretório
	 * 
	 * @param diretorio
	 *            um diretório qualquer cujo caminho real quer ser obtido
	 * @return
	 */
	public static String getDiretorioReal(String diretorio) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
		return servletContext.getRealPath(diretorio);
	}

	/**
	 * Método para recuperar um objeto form a partir da sessão.
	 * 
	 * @param obj
	 *            o nome do objeto na sessão
	 * @return o objeto que se encontra na sessão
	 */
	public Object getObjectFormSession(String obj) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		return session.getAttribute(obj);
	}

	/**
	 * Método responsável por recuperar algum parâmetro da solicitação do usuário.
	 * 
	 * @param param
	 *            o nome do parâmetro a ser recuperado
	 * @return o valor do parâmetro
	 */
	public static String getParameter(String param) {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(param);
	}

	/**
	 * Método responsável por retornar a requisição do contexto atual
	 * 
	 * @return um objeto que implementa a interface HttpServletRequest
	 */
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	/**
	 * Método responsável por retornar a resposta do contexto atual
	 * 
	 * @return um objeto que implementa a interface HttpServletResponse
	 */
	public static HttpServletResponse getResponse() {
		return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	}

	/**
	 * Método responsável por retornar a sessão do contexto atual
	 * 
	 * @return um objeto que implementa a interface HttpSession
	 */
	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	}

	public static void setSessionAttribute(String attributeName, Object value) {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession session = (HttpSession) externalContext.getSession(false);
		session.setAttribute(attributeName, value);
	}

	@SuppressWarnings("rawtypes")
	public static Map getSessionMap() {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	}

	/**
	 * Método responsável pelo envio de mensagens de erros através do objeto da classe FacesContext
	 * 
	 * @param message
	 */
	public static void errorMessage(String message) {
		message(message, FacesMessage.SEVERITY_ERROR);
	}

	/**
	 * Método responsável pelo envio de mensagens de erros irrecuperáveis através do objeto da classe FacesContext
	 * 
	 * @param message
	 */
	public static void fatalMessage(String message) {
		message(message, FacesMessage.SEVERITY_FATAL);
	}

	/**
	 * Método responsável pelo envio de mensagens de informação através do objeto da classe FacesContext
	 * 
	 * @param message
	 */
	public static void informationMessage(String message) {
		message(message, FacesMessage.SEVERITY_INFO);
	}

	/**
	 * Método responsável pelo envio de mensagens de qualquer gênero através do objeto da classe FacesContext
	 * 
	 * @param message
	 * @param severity
	 */
	public static void message(String message, FacesMessage.Severity severity) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, message, null));
	}

	/**
	 * Método responsável pelo envio de mensagens de alerta através do objeto da classe FacesContext
	 * 
	 * @param message
	 */
	public static void warningMessage(String message) {
		message(message, FacesMessage.SEVERITY_WARN);
	}

	/**
	 * Método responsável por popular uma lista de selectItens a partir de uma lista de objetos.
	 * 
	 * @param lista
	 *            Lista de objetos que irá popular a lista de selectItem
	 * @return uma lista de selectItem
	 */
	public static List<SelectItem> toListSelectItem(List<? extends Object> lista) {
		List<SelectItem> items = new ArrayList<SelectItem>();
		for (Object o : lista) {
			items.add(new SelectItem(o, o.toString()));
		}
		return items;
	}

}
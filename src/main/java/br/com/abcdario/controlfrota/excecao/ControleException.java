package br.com.abcdario.controlfrota.excecao;

public class ControleException extends Exception {

	private static final long serialVersionUID = 1L;

	private final String mensagem;

	public ControleException(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String getMessage() {
		return mensagem;
	}

}

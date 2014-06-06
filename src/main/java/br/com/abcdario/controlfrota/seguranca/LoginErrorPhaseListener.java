package br.com.abcdario.controlfrota.seguranca;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.springframework.security.web.WebAttributes;

import br.com.abcdario.controlfrota.util.FacesUtil;

@SuppressWarnings("serial")
public class LoginErrorPhaseListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent arg0) {

	}

	@SuppressWarnings("unchecked")
	@Override
	public void beforePhase(PhaseEvent arg0) {
		Exception dadosIncorretosException = (Exception) FacesUtil.getSessionMap().get(WebAttributes.AUTHENTICATION_EXCEPTION);

		if (dadosIncorretosException instanceof Exception) {
			FacesUtil.getSessionMap().put(WebAttributes.AUTHENTICATION_EXCEPTION, null);
			FacesUtil.errorMessage("Dados incorretos!");
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}

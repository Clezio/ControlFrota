package br.com.abcdario.controlfrota.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "conversorCPFCNPJ")
public class ConversorCPFCNPJ implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
		if (value != null && !"".equals(value)) {
			return StringUtil.retirarCaracteresNaoNumericos(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
		if (value != null && !"".equals(value) && (value instanceof String)) {
			String valorCPFCNPJ = (String) value;

			if (valorCPFCNPJ.length() == FormatadorUtil.TAMANHO_CNPJ) {
				return FormatadorUtil.formatarCNPJ(valorCPFCNPJ);
			} else if (valorCPFCNPJ.length() == FormatadorUtil.TAMANHO_CPF) {
				return FormatadorUtil.formatarCPF(valorCPFCNPJ);
			}
		}
		return null;
	}

}

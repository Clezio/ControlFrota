package br.com.abcdario.controlfrota.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class ConversorCep implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
		if (value != null && !"".equals(value)) {
			return Integer.valueOf(StringUtil.retirarCaracteresEspeciais(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
		if (value != null && !"".equals(value) && (value instanceof Integer)) {
			return value.toString();
		}
		return null;
	}

}

package br.com.abcdario.controlfrota.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "cpfConverter")
public final class ConversorCPF implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
		if (value != null && !"".equals(value)) {
			return Long.valueOf(StringUtil.retirarCaracteresNaoNumericos(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
		if (value != null && !"".equals(value) && (value instanceof Long)) {
			return FormatadorUtil.formatarCPF((Long) value);
		}
		return null;
	}

}

package br.com.abcdario.controlfrota.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "conversorDouble")
public class ConversorDouble implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
		if (value != null && !"".equals(value)) {
			return Double.parseDouble(value.replace(".", "").replace(",", "."));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
		if (value != null && !"".equals(value) && !(value instanceof String)) {
			return FormatadorUtil.formatarNumeroMoeda((Double) (value));
		}
		return null;
	}

}

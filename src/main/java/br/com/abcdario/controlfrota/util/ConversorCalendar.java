package br.com.abcdario.controlfrota.util;

import java.util.Calendar;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "conversorCalendar", forClass = Calendar.class)
public class ConversorCalendar implements Converter {

	private final String FORMATO_PADRAO = "dd/MM/yyyy";

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
		if (value != null && !"".equals(value)) {
			try {
				return DateUtil.toCalendar(value, getFormato(component));
			} catch (Exception e) {
				throw new ConverterException();
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
		if (value != null && !"".equals(value) && !(value instanceof String)) {
			return FormatadorUtil.formatarData((Calendar) value, getFormato(component));
		}
		return null;
	}

	private String getFormato(UIComponent component) {
		/* Caso o framework de applicação rica seja primefaces */
		if (component.getAttributes().get("pattern") != null) {
			return (String) component.getAttributes().get("pattern");
		}

		/* Caso o framework de applicação rica seja richfaces */
		if (component.getAttributes().get("datePattern") != null) {
			return (String) component.getAttributes().get("datePattern");
		}

		return FORMATO_PADRAO;
	}
}
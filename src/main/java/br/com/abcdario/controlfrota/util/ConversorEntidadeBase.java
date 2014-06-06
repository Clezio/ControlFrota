package br.com.abcdario.controlfrota.util;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "conversorEntidadeBase", forClass = EntidadeBase.class)
public class ConversorEntidadeBase implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !"".equals(value)) {
			return this.getAttributesFrom(component).get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !"".equals(value) && !(value instanceof String)) {
			EntidadeBase entity = (EntidadeBase) value;
			this.addAttribute(component, entity);

			String desc = entity.getIdEntity();
			if (desc != null) {
				return desc;
			}
		}
		return (String) value;
	}

	protected void addAttribute(UIComponent component, EntidadeBase entidade) {
		this.getAttributesFrom(component).put(entidade.getIdEntity(), entidade);
	}

	protected Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}
}
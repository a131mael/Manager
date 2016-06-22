/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aaf.uiweb.util;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.aaf.dto.PlayerDTO;

@FacesConverter(value = "converterPlayer")
public class ConverterPlayer implements Converter {

	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {                

		if (value != null) {
            return this.getAttributesFrom(component).get(value);
        }
        return null;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,Object value) {
    	if (value != null && !"".equals(value)) {

    		if(value instanceof String){
    			return null;
    		}
            PlayerDTO entity = (PlayerDTO) value;

            // adiciona item como atributo do componente
            if (entity.getId() != null) {
                this.addAttribute(component, entity);

                Long codigo = entity.getId();
                if (codigo != null) {
                    return String.valueOf(codigo);
                }
            }

        }

        if(value == null){
            return null;
        }
            
        return value.toString();

    }
    
    protected void addAttribute(UIComponent component, PlayerDTO o) {
        String key = o.getId().toString(); // codigo da empresa como chave neste caso
        this.getAttributesFrom(component).put(key, o);
    }

    protected Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }

   
}
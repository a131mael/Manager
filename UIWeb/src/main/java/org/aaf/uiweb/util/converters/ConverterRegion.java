/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aaf.uiweb.util.converters;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.aaf.dto.RegionDTO;

@FacesConverter(value = "converterRegion")
public class ConverterRegion implements Converter {

	@Override
    public RegionDTO getAsObject(FacesContext context, UIComponent component, String value) {                

		if (value != null) {
            return (RegionDTO)this.getAttributesFrom(component).get(value);
        }
        return null;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,Object value) {
    	if (value != null && !"".equals(value)) {

    		if(value instanceof String){
    			return null;
    		}
            RegionDTO entity = (RegionDTO) value;

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
    
    protected void addAttribute(UIComponent component, RegionDTO o) {
        String key = o.getId().toString(); // codigo da empresa como chave neste caso
        this.getAttributesFrom(component).put(key, o);
    }

    protected Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }

   
}
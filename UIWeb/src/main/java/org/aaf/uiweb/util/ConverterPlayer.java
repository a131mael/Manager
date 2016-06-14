/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aaf.uiweb.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "converterPlayer")
public class ConverterPlayer implements Converter {

	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {                

        if(value == null || value.isEmpty()){
            return HabilityEnum.AGILITY;
        }else{

            System.out.println(value);
            return 	HabilityEnum.valueOf(value);
        }

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,Object value) {
    	if(value != null && !value.toString().equalsIgnoreCase("")){
    		HabilityEnum unidade = (HabilityEnum)value;
            if(unidade != null){
                return String.valueOf(unidade);
            }	
    	}
    	return "";

    }

   
}
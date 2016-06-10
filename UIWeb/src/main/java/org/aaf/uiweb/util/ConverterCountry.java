/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aaf.uiweb.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "ConverterCountry")
public class ConverterCountry implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value != null) {
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {

        if (value != null && !"".equals(value)) {


        }

        if(value == null){
            return null;
        }
            
        return value.toString();
    }

   
}
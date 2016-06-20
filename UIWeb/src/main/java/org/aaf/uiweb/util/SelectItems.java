package org.aaf.uiweb.util;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.ejb.LocalBean;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import javax.persistence.Entity;

/**
 *
 *
 *
 * @author Edimar Chipil
 * @param
 * @return
 * @exception
 * @throws
 *
 */
@Model
public class SelectItems implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList<SelectItem> getHabilityEnum(){
		return HabilityEnum.getEnuns();
	}
	
	public ArrayList<SelectItem> getPositionEnum(){
		return PositionEnum.getEnuns();
	}
   
}

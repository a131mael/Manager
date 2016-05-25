package org.aaf.webInterface.util;


import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.inject.Model;
import javax.faces.model.SelectItem;

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
   
}

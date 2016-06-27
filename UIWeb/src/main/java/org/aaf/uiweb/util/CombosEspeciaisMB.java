/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aaf.uiweb.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import org.aaf.dto.CountryDTO;
import org.aaf.uiweb.service.UserService;

/**
 *
 * @author abimael Fidencio Combos na aplicação.
 */
@ManagedBean(name = "CombosEspeciaisMB")
@LocalBean
@ApplicationScoped
public class CombosEspeciaisMB implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
    private UserService userRegistration;
	
	@PostConstruct
	private void init (){
		userRegistration =  userRegistration!= null ? userRegistration:new UserService();
	}

	public ArrayList<SelectItem> getCountries() {
		ArrayList<SelectItem> items  = new ArrayList<SelectItem>();
		try {
			List<CountryDTO> countries = userRegistration.getCountries();
			for (CountryDTO m : countries) {
				items.add(new SelectItem(m, m.getName()));
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return items;
	}

}

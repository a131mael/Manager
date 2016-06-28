/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aaf.uiweb.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import org.aaf.dto.CountryDTO;
import org.aaf.dto.RegionDTO;
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

	private Map<Long, ArrayList<SelectItem>> regioes = new HashMap<Long, ArrayList<SelectItem>>();

	@PostConstruct
	private void init() {
		userRegistration = userRegistration != null ? userRegistration : new UserService();
	}

	public ArrayList<SelectItem> getCountries() {
		ArrayList<SelectItem> items = new ArrayList<SelectItem>();
		try {
			items.add(new SelectItem(null, "Selecione um País"));
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

	public ArrayList<SelectItem> getRegions(CountryDTO countryDTO) {
		ArrayList<SelectItem> regions = new ArrayList<SelectItem>();
		if (countryDTO != null ) {
			ArrayList<SelectItem> regMemory = regioes.get(countryDTO.getId());
			if (regMemory != null && regMemory.size() >0) {
				return regMemory;
			} else {
				try {
					List<RegionDTO> regsDTO = userRegistration.getRegions(countryDTO.getId());
					for (RegionDTO m : regsDTO) {
						regions.add(new SelectItem(m, m.getName()));
					}
					regioes.put(countryDTO.getId(), regions);
					return regions;
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		return regions;
	}

}

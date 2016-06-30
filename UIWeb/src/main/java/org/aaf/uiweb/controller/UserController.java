/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.aaf.uiweb.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.aaf.dto.CountryDTO;
import org.aaf.dto.RegionDTO;
import org.aaf.dto.TeamDTO;
import org.aaf.dto.UserDTO;
import org.aaf.uiweb.service.UserService;

@Model
@ViewScoped
public class UserController extends AuthController{

	@Inject
	private UserService userRegistration;

	@Produces
	@Named
	private UserDTO newUser;

	@Produces
	@Named
	private CountryDTO countryDTO;

	@Produces
	@Named
	private RegionDTO regionDTO;
	
	@PostConstruct
	public void initNewMember() {
		setNewUser(new UserDTO());
		TeamDTO team = new TeamDTO();
		getNewUser().setTeam(team);
	}

	public void register() throws Exception {
		try {
			CountryDTO c = (CountryDTO) getAtributoSessao("country");
			RegionDTO r = (RegionDTO) getAtributoSessao("region");
			userRegistration.register(getNewUser(), r);
			// FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,
			// "Registered!", "Registration successful");
			// facesContext.addMessage(null, m);
			initNewMember();
		} catch (Exception e) {
			// String errorMessage = getRootErrorMessage(e);
			// FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR,
			// errorMessage, "Registration unsuccessful");
			// facesContext.addMessage(null, m);
		}
	}

	public List<CountryDTO> getCountries() throws Exception {
		try {
			// FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,
			// "Registered!", "Registration successful");

			return userRegistration.getCountries();
		} catch (Exception e) {
			// String errorMessage = getRootErrorMessage(e);
			// FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR,
			// errorMessage, "Registration unsuccessful");
			// facesContext.addMessage(null, m);
		}
		return null;
	}

	@SuppressWarnings("unused")
	private String getRootErrorMessage(Exception e) {
		// Default to general error message that registration failed.
		String errorMessage = "Registration failed. See server log for more information";
		if (e == null) {
			// This shouldn't happen, but return the default messages
			return errorMessage;
		}

		// Start with the exception and recurse to find the root cause
		Throwable t = e;
		while (t != null) {
			// Get the message from the Throwable class instance
			errorMessage = t.getLocalizedMessage();
			t = t.getCause();
		}
		// This is the root cause message
		return errorMessage;
	}

	public UserDTO getNewUser() {
		return newUser;
	}

	public void setNewUser(UserDTO newUser) {
		this.newUser = newUser;
	}

	public CountryDTO getCountryDTO() {
		return countryDTO;
	}

	public void setCountryDTO(CountryDTO countryDTO) {
		this.countryDTO = countryDTO;
		addAtributoSessao("country", countryDTO);
	}

	public RegionDTO getRegionDTO() {
		return regionDTO;
	}

	public void setRegionDTO(RegionDTO regionDTO) {
		this.regionDTO = regionDTO;
		addAtributoSessao("region", regionDTO);
	}

}

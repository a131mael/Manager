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
package org.aaf.uiweb.service;

import java.time.LocalDate;
import java.util.List;

import org.aaf.dto.CountryDTO;
import org.aaf.dto.RegionDTO;
import org.aaf.dto.TeamDTO;
import org.aaf.dto.UserDTO;
import org.aaf.uiweb.util.EndPoints;
import org.aaf.uiweb.util.JSONPPost;

import com.cedarsoftware.util.io.JsonWriter;

public class UserService extends Service{

	private TeamService teamService;

	public UserService() {
		teamService = new TeamService();
	}

	public void register(UserDTO user, RegionDTO region) throws Exception {
		user.setEnteredInto(LocalDate.now());
		user.setIdiom(region.getCountry().getIdiom());
		
		TeamDTO team = teamService.getAvailableTeam(region.getCountry());
		team.setIdiom(region.getCountry().getIdiom());
		team.setRegion(region);
		team.setName(user.getTeam().getName());
		team.setOwner(user);
		

		JSONPPost.sendJson(JsonWriter.objectToJson(team), EndPoints.REGISTER_TEAM);
	}

	public UserDTO login(UserDTO m) throws Exception {
		String endPoint =  EndPoints.LOGIN+m.getLogin();
		return (UserDTO)getObject(endPoint);
	}
	
	@SuppressWarnings("unchecked")
	public List<CountryDTO> getCountries() throws Exception {
		String endPoint = EndPoints.GET_COUNTRIES;
		return (List<CountryDTO>) getObject(endPoint);
	}
	
	@SuppressWarnings("unchecked")
	public List<RegionDTO> getRegions(Long id) throws Exception {
		String endPoint = EndPoints.GET_REGIONS_COUNTRY + id;
		return (List<RegionDTO>) getObject(endPoint);
	}

}

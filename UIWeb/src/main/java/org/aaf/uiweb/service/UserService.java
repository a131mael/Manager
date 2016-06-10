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

import java.util.ArrayList;
import java.util.List;

import org.aaf.dto.CountryDTO;
import org.aaf.dto.TeamDTO;
import org.aaf.dto.UserDTO;
import org.aaf.uiweb.util.EndPoints;
import org.aaf.uiweb.util.JSONPPost;
import org.aaf.uiweb.util.JsonReader;
import org.json.JSONArray;

import com.cedarsoftware.util.io.JsonWriter;

public class UserService {

	// @Inject
	// private Logger log;

	// @Inject
	// private EntityManager em;

	// @Inject
	// private Event<Member> memberEventSrc;

	private TeamService teamService;

	public UserService() {
		teamService = new TeamService();
	}

	public void register(UserDTO user, CountryDTO countryDTO) throws Exception {

		// log.info("Registering " + user.getName());

		TeamDTO team = teamService.getAvailableTeam(countryDTO);
		team.setName(user.getTeam().getName());
		team.setOwner(user);

		JSONPPost.sendJson(JsonWriter.objectToJson(team), EndPoints.REGISTER_TEAM);

		// TODO POST para criar time
	}

	public UserDTO login(UserDTO m) throws Exception {
		//JSONObject jo = JsonReader.getObject(EndPoints.AVALIABLE_TEAM);
		
//		TeamDTO time = new TeamDTO(jo);
//		
		JSONPPost.postJson(JsonWriter.objectToJson(m), EndPoints.LOGIN);
		
		//TODO - remover
		m.setId(1L);
		
		return m;
	}
	
	public List<CountryDTO> getCountries() throws Exception {
		JSONArray jo = JsonReader.getList(EndPoints.GET_COUNTRIES);
		List<CountryDTO> objs = new ArrayList<CountryDTO>();
		for(int i = 0; i<jo.length();i++){
			CountryDTO co = new CountryDTO();
			
			co.setName(jo.getJSONObject(i).getString("name"));
			co.setId(jo.getJSONObject(i).getLong("id"));
			//co.setCod(jo.getJSONObject(i).getString("cod"));
			
			objs.add(co);
		}
		
		return objs;
	}

}

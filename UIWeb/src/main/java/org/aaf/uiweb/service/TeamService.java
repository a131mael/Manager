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

import java.util.List;

import org.aaf.dto.CountryDTO;
import org.aaf.dto.StadiumDTO;
import org.aaf.dto.TeamDTO;
import org.aaf.uiweb.util.EndPoints;
import org.aaf.uiweb.util.JsonReader;
import org.json.JSONObject;

public class TeamService {

	public TeamDTO getAvailableTeam(CountryDTO country) throws Exception {
		
		String endPoint = EndPoints.AVALIABLE_TEAM;
		
		if (country != null) {
			endPoint += country.getId();
		}else{
			endPoint +=1;;
		}
		JSONObject jo = JsonReader.getObject(endPoint);
		TeamDTO time = new TeamDTO(jo);

		return time;
	}

	@SuppressWarnings("unchecked")
	public List<TeamDTO> getTeans(Long idLeague) {
		JSONObject jo = JsonReader.getObject(EndPoints.GET_TEAMS + idLeague);
		List<TeamDTO> matches = ((List<TeamDTO>) com.cedarsoftware.util.io.JsonReader.jsonToJava(jo.toString()));
		return matches;
	}

	public TeamDTO getTean(Long id) {
		// StringBuilder sql = new StringBuilder();
		// sql.append("SELECT t from Team t ");
		// sql.append("left join t.league l ");
		// sql.append("where 1=1 ");
		// sql.append("and t.id = :id ");
		//
		// Query query = em.createQuery(sql.toString());
		// query.setParameter("id", id);
		// return (TeamDTO) query.getSingleResult();
		return null;
	}

	public StadiumDTO getStadium(Long idTeam) {
		JSONObject jo = JsonReader.getObject(EndPoints.GET_STADIUM_TEAM + idTeam);
		StadiumDTO stadiumDTO = (StadiumDTO) com.cedarsoftware.util.io.JsonReader.jsonToJava(jo.toString());
		return stadiumDTO;
	}
}

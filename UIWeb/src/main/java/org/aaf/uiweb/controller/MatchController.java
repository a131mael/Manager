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

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.aaf.dto.LineUpDTO;
import org.aaf.dto.MatchDTO;
import org.aaf.dto.PlayerDTO;
import org.aaf.uiweb.service.MatchService;
import org.aaf.uiweb.service.PlayerService;

@Model
public class MatchController extends AuthController {

	// @Inject
	// private FacesContext facesContext;

	@Inject
	private MatchService matchService;
	
	@Inject
	private PlayerService playerService;

	//
	public List<MatchDTO> getTeamMatchs(int round) throws Exception {

		return matchService.getMatches(getLoggedUser().getTeam().getId(), getLoggedUser().getCountryDTO().getSession());
	}

	public String lineupLink(long id) {
		StringBuilder sb = new StringBuilder();
		sb.append(getLoggedUser().getId());
		sb.append("&match=");
		
		sb.append(id);

		return sb.toString();
	}

	public String saveLineUp() {
		Long matchId = Long.valueOf((String) getQueryValue("match"));
		MatchDTO match = new MatchDTO();
		match.setId(matchId);
		
		LineUpDTO lineUpDTO = new LineUpDTO();
		
		lineUpDTO.setTeamDTO(getLoggedUser().getTeam());
		lineUpDTO.setMatch(match);
		
		
		Object valor = FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("math");
		return "";
	}
	
	public List<PlayerDTO> getTeamPlayers() throws Exception {
		return playerService.getPlayers(getLoggedUser().getId(), "name", "asc");

	}

	//
	public List<Object> getLastTeamMatchs() throws Exception {
		// return matchService.getLastMatches(getLoggedUser().getId());
		return null;
	}

	public List<Integer> getWeeks() throws Exception {
		List<Integer> semanas = new ArrayList<Integer>();
		for (int i = 0; i < 14; i++) {
			semanas.add(i);
		}
		return semanas;

	}

}

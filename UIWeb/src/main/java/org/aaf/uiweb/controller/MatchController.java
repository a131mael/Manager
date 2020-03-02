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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import org.aaf.dto.LineUpDTO;
import org.aaf.dto.MatchDTO;
import org.aaf.dto.PlayerDTO;
import org.aaf.uiweb.service.MatchService;
import org.aaf.uiweb.service.PlayerService;

@ViewScoped
@ManagedBean
public class MatchController extends AuthController {

	// @Inject
	// private FacesContext facesContext;

	@Inject
	private MatchService matchService;
	
	@Inject
	private PlayerService playerService;
	
	private LineUpDTO lineUP;
	
	private Long matchId;
	
	@PostConstruct
	private void init(){
		matchId = getQueryValue("match") != null ? Long.valueOf((String)getQueryValue("match")): null;
		if(matchId != null){
			lineUP = matchService.getLineUp(matchId, getLoggedUser().getTeam().getId());
		}
		
		if(lineUP == null){
			lineUP = new LineUpDTO();
		}
	}

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
		MatchDTO match = new MatchDTO();
		match.setId(matchId);
		lineUP.setTeamDTO(getLoggedUser().getTeam());
		lineUP.setMatch(match);
		lineUP.setDate(LocalDateTime.now());
		matchService.saveLineUp(lineUP);
		return "matches";
	}
	
	public ArrayList<SelectItem> getTeamPlayersItems() {
		ArrayList<SelectItem> items  = new ArrayList<SelectItem>();
		try {
			List<PlayerDTO> countries = getTeamPlayers();
			items.add(new SelectItem(null, ""));
			for (PlayerDTO m : countries) {
				items.add(new SelectItem(m, m.getName()));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return items;
	}
	
	public List<PlayerDTO> getTeamPlayers() throws Exception {
		return playerService.getPlayers(getLoggedUser().getId(), "name", "asc");

	}
	public List<MatchDTO> getLastTeamMatchs() throws Exception {
		 return matchService.getLastMatches(getLoggedUser().getTeam().getId());
	}
	
	public MatchDTO getLastTeamMatch() throws Exception {
		 return matchService.getLastMatch(getLoggedUser().getTeam().getId());
	}
	
	public MatchDTO getMatchPenultimate() throws Exception {
		 return matchService.getLastMatchPenultimate(getLoggedUser().getTeam().getId());
	}

	public List<Integer> getWeeks() throws Exception {
		List<Integer> semanas = new ArrayList<Integer>();
		for (int i = 0; i < 14; i++) {
			semanas.add(i);
		}
		return semanas;

	}

	public LineUpDTO getLineUP() {
		return lineUP;
	}

	public void setLineUP(LineUpDTO lineUP) {
		this.lineUP = lineUP;
	}

}

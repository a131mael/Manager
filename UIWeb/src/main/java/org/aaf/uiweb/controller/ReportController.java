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

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.aaf.dto.LineUpDTO;
import org.aaf.dto.MatchDTO;
import org.aaf.uiweb.service.MatchService;
import org.aaf.uiweb.service.ReportService;

@Model
@ViewScoped
public class ReportController extends AuthController {

	private ReportService reportService;
	
	@Inject
	private MatchService matchService;
	

	private MatchDTO match;
	
	private LineUpDTO lineUP; 

	@PostConstruct
	private void init() {
		matchService = new MatchService(); 
		reportService = new ReportService();
		String id = getRequestParam("matchID");
		addAtributoSessao("matchID",id);
		
		String teamID = getRequestParam("teamID");
		addAtributoSessao("teamID",teamID);
		
		match = id!= null? (reportService.getMatch(Long.parseLong(id))):null;
		if(match != null){
			match.setLineUpHomeTeam(getLineUpHomeTeam());
			match.setLineUpVisitTeam(getLineUpVisitTeam());
		}
		if(id != null && teamID != null){
			lineUP = matchService.getLineUp(Long.parseLong(id), Long.parseLong(teamID) );
		}
	}

	public MatchDTO getMatch() {
		return match;
	}
	
	private LineUpDTO getLineUpHomeTeam() {
		LineUpDTO lineUP = matchService.getLineUp(match.getId(), match.getHomeTeam().getId());
		return lineUP;
	}
	
	private LineUpDTO getLineUpVisitTeam() {
		LineUpDTO lineUP = matchService.getLineUp(match.getId(), match.getVisitTeam().getId());
		return  lineUP;
	}
	
	public void setMatch(MatchDTO match) {
		this.match = match;
	}

	public LineUpDTO getLineUP() {
		return lineUP;
	}

	public void setLineUP(LineUpDTO lineUP) {
		this.lineUP = lineUP;
	}
	

}

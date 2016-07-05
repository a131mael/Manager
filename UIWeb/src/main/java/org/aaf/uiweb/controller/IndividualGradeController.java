package org.aaf.uiweb.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Model;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.aaf.dto.LineUpDTO;
import org.aaf.dto.MatchDTO;
import org.aaf.uiweb.service.MatchService;
import org.aaf.uiweb.service.ReportService;

@Model
@ViewScoped
public class IndividualGradeController extends AuthController {

	private ReportService reportService;
	
	@Inject
	private MatchService matchService;
	

	private MatchDTO match;

	@PreDestroy
	private void destroied(){
		cleanSession();
	}
	
	@PostConstruct
	private void init() {
		
		matchService = new MatchService(); 
		reportService = new ReportService();
		String id = getRequestParam("teamID");
		addAtributoSessao("teamID",id);
		
		String idMatch = getRequestParam("matchID");
		addAtributoSessao("matchID",idMatch);
		
		match = id!= null? (reportService.getMatch(Long.parseLong(id))):null;
		if(match != null){
			match.setLineUpHomeTeam(matchService.getLineUp(Long.parseLong(idMatch), Long.parseLong(id)));
		}
	}

	public MatchDTO getMatch() {
		return match;
	}
	
	
	public void setMatch(MatchDTO match) {
		this.match = match;
	}

}

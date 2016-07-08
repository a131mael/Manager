package org.aaf.uiweb.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.aaf.dto.EconomyDTO;
import org.aaf.uiweb.service.EconomyService;

@Model
@ViewScoped
public class EconomyController extends AuthController{

    @Inject
    private EconomyService economyService; 
    
    private EconomyDTO dto;
    
    EconomyController(){
    	//init();
    }

    @PostConstruct
    public void init(){
    	//economyService = new EconomyService(); //ver fluxo de vida, injecao do service eh feita apos o contrututor
		dto = economyService.getEconomy(getLoggedUser().getTeam().getId(),getLoggedUser().getCountryDTO().getSession(),getLoggedUser().getCountryDTO().getWeek()) ;
    }
    
    public EconomyDTO getDto(){
    	return dto;
    }
    
}

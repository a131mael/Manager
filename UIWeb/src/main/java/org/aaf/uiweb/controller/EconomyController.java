package org.aaf.uiweb.controller;

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
    	dto = new EconomyDTO();
    	init(10L);
    }
    

    public void init(Long teamID){
    	dto.setTotalIncreaseSupportes(economyService.getTotalIncreaseSupporters(teamID));
    }
    
    public EconomyDTO getDto(){
    	return dto;
    }
    
}

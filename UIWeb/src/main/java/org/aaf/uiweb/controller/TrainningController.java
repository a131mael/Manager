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

import org.aaf.dto.StadiumDTO;
import org.aaf.uiweb.service.StadiumService;

@Model
@ViewScoped
public class TrainningController extends AuthController {

	@Inject
	private StadiumService stadiumService;
	
	private StadiumDTO stadium; 
	
	@PostConstruct
	private void init() {
		stadiumService = new StadiumService(); 
		String id = getRequestParam("teamID");
		addAtributoSessao("teamID",id);
		if(id == null){
			stadium = stadiumService.getStadium(getLoggedUser().getTeam().getId());
		}else{
			stadium = stadiumService.getStadium(Long.parseLong(id));
		}
	}

	public StadiumDTO getStadium() {
		return stadium;
	}

	public void setStadium(StadiumDTO stadium) {
		this.stadium = stadium;
	}
	
}

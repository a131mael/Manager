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
package org.aaf.webInterface.controller;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.aaf.webInterface.model.Player;
import org.aaf.webInterface.service.PlayerService;
import org.aaf.webInterface.util.HabilityEnum;

@Model
public class PlayerController extends AuthController{

    @Inject
    private FacesContext facesContext;

    @Inject
    private PlayerService playerService;
    
    private HabilityEnum selectedHability;
    
    public List<Player> getTeamPlayers() throws Exception {
    	return playerService.getPlayers(getLoggedUser().getId(), selectedHability != null ?selectedHability.getLabel():null,"");
    
    }

	public HabilityEnum getSelectedHability() {
		return selectedHability;
	}

	public void setSelectedHability(HabilityEnum selectedHability) {
		this.selectedHability = selectedHability;
	}

}

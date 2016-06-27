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

import org.aaf.dto.PlayerDTO;
import org.aaf.uiweb.util.EndPoints;
import org.aaf.uiweb.util.JsonReader;

public class PlayerService extends Service{

//    @Inject
//    private Logger log;

	@SuppressWarnings("unchecked")
	public List<PlayerDTO> getPlayers(Long teamID, String orderBy, String orderByType) {
		StringBuilder parans = new StringBuilder();
		if(orderBy != null){
			parans.append("?");
			parans.append("orderBy=");
			parans.append(orderBy);
			parans.append("&orderByType=");
			parans.append(orderByType);
		}
		
		String endPoint =  EndPoints.GET_PLAYERS_USER+teamID+parans;
		return (List<PlayerDTO>)getObject(endPoint);
	}
    
	public PlayerDTO getPlayer(Long id, Long idTeam) { 
		String endPoint =  EndPoints.GET_PLAYER.replace("*1", idTeam.toString()).replace("*2", id.toString());
		return (PlayerDTO)getObject(endPoint);
	}

	public String dismiss(long id) {
		String jo = JsonReader.getText( EndPoints.PLAYER_DISMISS+id);
		return jo;		
	}
}

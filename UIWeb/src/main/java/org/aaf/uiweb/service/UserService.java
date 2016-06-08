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


import javax.inject.Inject;

import org.aaf.dto.TeamDTO;
import org.aaf.dto.UserDTO;
import org.aaf.uiweb.util.EndPoints;
import org.aaf.uiweb.util.JSONPPost;
import org.json.JSONWriter;
import org.primefaces.push.impl.JSONDecoder;

import com.cedarsoftware.util.io.JsonWriter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class UserService {

//    @Inject
//    private Logger log;

//    @Inject
//    private EntityManager em;

//    @Inject
//    private Event<Member> memberEventSrc;
    
    
    private TeamService teamService;
    

    public UserService(){
    	teamService = new TeamService();
    }
    
    
    public void register(UserDTO user) throws Exception {
    	
    	//	log.info("Registering " + user.getName());

    	TeamDTO team = teamService.getAvailableTeam(null);
    	team.setName(user.getTeam().getName());
    	team.setOwner(user);
  
    	
    	JSONPPost.sendJson(JsonWriter.objectToJson(team), EndPoints.REGISTER_TEAM);
    	
//TODO POST para criar time    	
    }

	public UserDTO login(UserDTO m) {
//		StringBuilder query = new StringBuilder();
//		query.append("SELECT u from USER u ");
//		query.append("where 1=1 ");
//		query.append("and u.login = : login ");
//		Query query2 = em.createQuery(query.toString());
//		query2.setParameter("login", m.getLogin());
//		
//		UserDTO user = (UserDTO) query2.getSingleResult();
//		return user;
		return null;
	}
}

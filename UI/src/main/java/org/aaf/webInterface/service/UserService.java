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
package org.aaf.webInterface.service;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.aaf.webInterface.model.Member;
import org.aaf.webInterface.model.Team;
import org.aaf.webInterface.model.UserFM;

@Stateless
public class UserService {

	@PersistenceContext(unitName = "PostgresDS")
    private EntityManager em;

    @SuppressWarnings("unused")
	@Inject
    private Event<Member> memberEventSrc;
    
    @Inject
    private TeamService teamService;
    

    public void register(UserFM user) throws Exception {

    	Team team = teamService.getAvailableTeam(null);
    	team.setName(user.getTeam().getName());
    	team.setOwner(user);
    	
    	user.setTeam(null);
    	em.persist(user);

        em.persist(team);
        user.setTeam(team);
    }

	public UserFM login(UserFM m) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT u from UserFM u ");
		query.append("where 1=1 ");
		query.append("and u.login = :login ");
		Query query2 = em.createQuery(query.toString());
		query2.setParameter("login", m.getLogin());
		
		UserFM user = (UserFM) query2.getSingleResult();
		return user;
	}
}

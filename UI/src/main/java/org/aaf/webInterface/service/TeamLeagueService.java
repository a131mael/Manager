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

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.aaf.model.TeamLeague;

@Stateless
public class TeamLeagueService {

	@PersistenceContext(unitName = "PostgresDS")
    private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<TeamLeague> getTeamLeagueByLeague(long idLeague) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT tl from TeamLeague tl ");
		query.append("left join tl.league l ");
		query.append("left join tl.team t ");
		query.append("where 1=1 ");
		query.append("and l.id = :idLeague ");
		Query query2 = em.createQuery(query.toString());
		query2.setParameter("idLeague", idLeague);
		
		List<TeamLeague> teamLeague =  query2.getResultList();
		return teamLeague;
	}

}

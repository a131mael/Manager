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

import org.aaf.model.League;
import org.aaf.model.Team;

@Stateless
public class LeagueService {

	@PersistenceContext(unitName = "PostgresDS")
    private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Team> getTeams(long idLeague) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t from  TeamLeague tl ");
		sql.append("left join tl.league l ");
		sql.append("left join tl.team t ");
		sql.append("where 1=1 ");
		sql.append("and l.id = :idLeague ");

		Query query = em.createQuery(sql.toString());
		query.setParameter("idLeague", idLeague);
		return query.getResultList();
	}

	public League getLeagueByUser(long idUser) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT l from TeamLeague tl ");
		query.append("left join tl.league l ");
		query.append("left join tl.team t ");
		query.append("left join t.owner user ");
		query.append("where 1=1 ");
		query.append("and user.id = :idUser ");
		Query query2 = em.createQuery(query.toString());
		query2.setParameter("idUser", idUser);
		
		League user = (League) query2.getSingleResult();
		return user;
	}
}

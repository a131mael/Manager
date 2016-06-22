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

import org.aaf.webInterface.model.LineUp;
import org.aaf.webInterface.model.Match;
import org.aaf.webInterface.model.Team;

@Stateless
public class MatchService {

	@PersistenceContext(unitName = "PostgresDS")
    private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Match> getLastMatches(Long idTeam) {
		StringBuilder sql = new StringBuilder();
		sql.append("Select m from Match m  ");
		sql.append("left join m.homeTeam ht ");
		sql.append("left join m.visitTeam vt ");
		sql.append("where 1=1 ");
		sql.append("and (");
		sql.append("vt.id = :idTeam ");
		sql.append("or ht.id = :idTeam ");
		sql.append(") ");
		Query query = em.createQuery(sql.toString());
		query.setParameter("idTeam", idTeam);
		return  query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Match> getMatches(Long id,int session, int week) {
		StringBuilder sql = new StringBuilder();
		sql.append("Select m from Match m  ");
		sql.append("left join m.homeTeam ht ");
		sql.append("left join m.visitTeam vt ");
		sql.append("where 1=1 ");
		sql.append("and (");
		sql.append("vt.id = :idTeam ");
		sql.append("or ht.id = :idTeam ");
		sql.append(") ");
		sql.append("and m.session = :session");
		sql.append("and m.week = :week");
		Query query = em.createQuery(sql.toString());
		query.setParameter("session", session);
		query.setParameter("idTeam", id);
		query.setParameter("week", week);
		return  query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Match> getMatches(Long id,int session) {
		StringBuilder sql = new StringBuilder();
		sql.append("Select m from Match m  ");
		sql.append("left join m.homeTeam ht ");
		sql.append("left join m.visitTeam vt ");
		sql.append("where 1=1 ");
		sql.append("and (");
		sql.append("vt.id = :idTeam ");
		sql.append("or ht.id = :idTeam ");
		sql.append(") ");
		sql.append("and m.session = :session");
		Query query = em.createQuery(sql.toString());
		query.setParameter("session", String.valueOf(session));
		query.setParameter("idTeam", id);
		return  query.getResultList();
		
		
	}

	public Match getLastMatch(Long id) {
		StringBuilder sql = new StringBuilder();
		sql.append("Select m from Match m  ");
		sql.append("left join m.homeTeam ht ");
		sql.append("left join m.visitTeam vt ");
		sql.append("where 1=1 ");
		sql.append("and (");
		sql.append("vt.id = :idTeam ");
		sql.append("or m.id = :id ");
		sql.append(") ");
		Query query = em.createQuery(sql.toString());
		query.setParameter("id", id);
		return  (Match) query.getResultList();
	}

	public void save(LineUp lineUp) {
		em.find(Match.class, lineUp.getMatch().getId());
		em.find(Team.class, lineUp.getTeam().getId());
		
		if(lineUp.getId() != null){
			em.merge(lineUp);
		}else{
			em.persist(lineUp);
		}
		
		
	}

}

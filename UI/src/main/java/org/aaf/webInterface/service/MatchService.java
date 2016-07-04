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

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.aaf.model.Country;
import org.aaf.model.LineUp;
import org.aaf.model.Match;
import org.aaf.model.Team;

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

	public LineUp getLineUp(long idMatch, long idTeam) {
		StringBuilder sql = new StringBuilder();
		sql.append("Select lu from LineUp lu  ");
		sql.append("left join lu.team t ");
		sql.append("left join lu.match m ");
		sql.append("where 1=1 ");
		sql.append("and (");
		sql.append("t.id = :idTeam ");
		sql.append("and m.id = :idMatch ");
		sql.append(") ");
		Query query = em.createQuery(sql.toString());
		query.setParameter("idMatch", idMatch);
		query.setParameter("idTeam", idTeam);
		
		LineUp lineUp = null;
		try{
			lineUp = (LineUp) query.getSingleResult();
			
		}catch(NoResultException nre){
			System.out.println("Escalação nâo encontrada.");
		}
		
		return lineUp;
	}

	public LocalDateTime getDateLastLineUp(Long idTeam){
		StringBuilder sql = new StringBuilder();
		sql.append("Select max(lu.date) from LineUp lu  ");
		sql.append("left join lu.team t ");
		sql.append("where 1=1 ");
		sql.append("and ");
		sql.append("t.id = :idTeam ");
		Query query = em.createQuery(sql.toString());
		query.setParameter("idTeam", idTeam);
		
		System.out.println("QUERY: " + sql);
		
		LocalDateTime date = null;
		try{
			date = (LocalDateTime) query.getSingleResult();
			
		}catch(NoResultException nre){
			System.out.println("Nenhuma Escalacao encontrada");
		}
		
		return date;
	}
	
	public LineUp getLastLineUp(long idTeam) {
		LineUp lineUp = null;
		System.out.println("XXXXXXX");
		LocalDateTime lastDate = getDateLastLineUp(idTeam);
		System.out.println("YYYYYYY ");
		System.out.println("YYYYYYY " + lastDate);
		if(lastDate != null){
			StringBuilder sql = new StringBuilder();
			sql.append("Select lu from LineUp lu  ");
			sql.append("left join lu.team t ");
			sql.append("left join lu.match m ");
			sql.append("where 1=1 ");
			sql.append("and (");
			sql.append("t.id = :idTeam ");
			sql.append("and lu.date = :lastDate ");
			sql.append(") ");
			Query query = em.createQuery(sql.toString());
			query.setParameter("idTeam", idTeam);
			query.setParameter("lastDate", lastDate);
			
			try{
				lineUp = (LineUp) query.getSingleResult();
				
			}catch(NoResultException nre){
				System.out.println("Escalação nâo encontrada.");
			}
			System.out.println("kkkkkkk ");
		}
		return lineUp;
	}

	public Match findById(long idMatch) {
		return em.find(Match.class, idMatch);
	}

}

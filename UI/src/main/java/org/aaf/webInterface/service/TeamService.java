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

import org.aaf.model.Stadium;
import org.aaf.model.Team;
import org.aaf.model.UserFM;

@Stateless
public class TeamService {

	@PersistenceContext(unitName = "PostgresDS")
	private EntityManager em;

	public Team getAvailableTeam(Long idcountry) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t from TeamLeague tl ");
		sql.append("left join tl.league l ");
		sql.append("left join tl.team t ");
		sql.append("left join l.country c ");
		sql.append("where 1=1 ");
		sql.append("and c.id = :idCountry ");
		sql.append("and l.level = :level");

		Query query = em.createQuery(sql.toString());
		query.setParameter("idCountry", idcountry);
		query.setMaxResults(1);
		query.setParameter("level", 3); // TODO - Important colocado valor
										// arbitrario, 3, deve-se pegar o ultimo
										// level, fazer rotina para buscar o
										// ultimo
		return (Team) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Team> getTeans(Long idLeague) {
		//TODO what
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t from  Team t ");
		sql.append("left join t.league l ");
		sql.append("where 1=1 ");
		sql.append("and l.id = :idLeague ");

		Query query = em.createQuery(sql.toString());
		query.setParameter("idLeague", idLeague);
		return query.getResultList();
	}

	public Team getTean(Long id) {
		//TODO what
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t from  Team t ");
		sql.append("left join t.league l ");
		sql.append("where 1=1 ");
		sql.append("and t.id = :id ");

		Query query = em.createQuery(sql.toString());
		query.setParameter("id", id);
		return (Team) query.getSingleResult();
	}

	public void save(Team team) {
		em.persist(team);
	}

	public void registerTeam(Team t) {
		try {
			UserFM userTeam = t.getOwner(); 
			userTeam.setTeam(null);
			em.persist(userTeam);
			
			t.setOwner(userTeam);
			
			userTeam.setTeam(t);
			em.persist(userTeam);
			em.merge(t);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Stadium getStadium(long id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT s from  Stadium s ");
		sql.append("left join s.team t ");
		sql.append("where 1=1 ");
		sql.append("and t.id = :id ");

		Query query = em.createQuery(sql.toString());
		query.setParameter("id", id);
		return (Stadium) query.getSingleResult();
	}

	public Long getSumSalaryPlayers(long idTeam) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT SUM(p.salary) from  Player p ");
		sql.append("left join p.team t ");
		sql.append("where 1=1 ");
		sql.append("and t.id = :id ");

		Query query = em.createQuery(sql.toString());
		query.setParameter("id", idTeam);
		return Double.doubleToLongBits((double) query.getSingleResult()) ;
	}
	
}

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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.aaf.model.Economy;

@Stateless
public class EconomyService {

	@PersistenceContext(unitName = "PostgresDS")
    private EntityManager em;
	
	public Long getTotalSalary(Long teamID) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p from  Player p ");
		sql.append("left join p.team t ");
		sql.append("where 1 = 1 ");
		sql.append("and t.id = :teamID ");
		
		Query query = em.createQuery(sql.toString());
		query.setParameter("teamID", teamID);
		return  (Long) query.getSingleResult();
	}
	
	public Economy getEconomyBySessionWeek(Long teamID,int session, int week) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT e from  Economy e ");
		sql.append("left join e.team t ");
		sql.append("where 1 = 1 ");
		sql.append("and t.id = :teamID ");
		sql.append("and e.session = :session ");
		sql.append("and e.week = :week ");
		
		Query query = em.createQuery(sql.toString());
		query.setParameter("teamID", teamID);
		query.setParameter("session", session);
		query.setParameter("week", week);
		return  (Economy) query.getSingleResult();
	}
   
}

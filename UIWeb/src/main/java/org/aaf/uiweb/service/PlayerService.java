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

public class PlayerService {

//    @Inject
//    private Logger log;

//    @Inject
//    private EntityManager em;

    @SuppressWarnings("unchecked")
	public List<PlayerDTO> getPlayers(Long teamID, String orderBy, String orderByType) {
//		StringBuilder sql = new StringBuilder();
//		sql.append("SELECT p from  Player p ");
//		sql.append("left join p.team t ");
//		sql.append("where 1 = 1 ");
//		sql.append("and t.id = :teamID ");
//		
//		Query query = em.createQuery(sql.toString());
//		query.setParameter("teamID", teamID);
//		return  query.getResultList();
    	return null;
		
	}
    
	public PlayerDTO getPlayer(Long id) {
//		StringBuilder sql = new StringBuilder();
//		sql.append("SELECT p from  Player p ");
//		sql.append("left join p.team t ");
//		sql.append("where 1 = 1 ");
//		sql.append("and p.id = :teamID ");
//		
//		Query query = em.createQuery(sql.toString());
//		query.setParameter("teamID", id);
//		return  (PlayerDTO) query.getSingleResult();
		return null;
		
	}
}

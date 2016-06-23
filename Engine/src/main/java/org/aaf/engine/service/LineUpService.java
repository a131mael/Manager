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
package org.aaf.engine.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.aaf.engine.model.LineUp;
import org.aaf.engine.model.Match;
import org.aaf.engine.model.Team;

@Stateless
public class LineUpService {

	@PersistenceContext(unitName = "PostgresDS")
	private EntityManager em;

	public LineUp getLineUp(long idMatch, long idTeam) {
		try {
			return null;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public LineUp save(LineUp lineUp) {
		em.find(Match.class, lineUp.getMatch().getId());
		em.find(Team.class, lineUp.getTeam().getId());

		if (lineUp.getId() != null) {
			em.merge(lineUp);
		} else {
			em.persist(lineUp);
		}
		return lineUp;
	}

}

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

import org.aaf.dto.CountryDTO;
import org.aaf.webInterface.model.Country;

@Stateless
public class CountryService {

	@PersistenceContext(unitName = "PostgresDS")
	private EntityManager em;

	public Country findById(Long id) {
		return em.find(Country.class, id);
	}

	public List<Country> findAllOrderedByName() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT c from  Country c ");
		sql.append("where 1 = 1 ");
		sql.append("ORDER BY  name ");
		
		Query query = em.createQuery(sql.toString());
		return  query.getResultList();
	}
}
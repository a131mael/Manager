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
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.aaf.ui.DTO.CountryDTO;
import org.aaf.ui.DTO.TeamDTO;
import org.aaf.uiweb.util.ConectionRest;


public class TeamService {

//    @Inject
//    private Logger log;

//    @Inject
//    private EntityManager em;
    private final static int  HTTP_COD_SUCESSO = 200;

	public TeamDTO getAvailableTeam(CountryDTO country) throws Exception {
//		try {
//			//TODO - Importante
//			URL url = new URL("http://localhost/UI/rest/teams/avaliable/1");
//			HttpURLConnection con = (HttpURLConnection) url.openConnection();
//			
//			if (con.getResponseCode() != HTTP_COD_SUCESSO) {
//				throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
//			}
//
//			BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
//						
//			JAXBContext jaxbContext = JAXBContext.newInstance(TeamDTO.class);
//
//			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//			TeamDTO banda = (TeamDTO) jaxbUnmarshaller.unmarshal(br);
//			
//			System.out.println("------  Dados da Banda  -------- \n");
//			
//			int count = 1;
//			
//
//			con.disconnect();
//
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		ConectionRest conectionRest = new ConectionRest();
		conectionRest.setUrl("http://localhost/UI/rest/teams/avaliable/1");
		conectionRest.getObject(TeamDTO.class);
		
		return null;
    }
	    
	@SuppressWarnings("unchecked")
	public List<TeamDTO> getTeans(Long idLeague) {
//		StringBuilder sql = new StringBuilder();
//		sql.append("SELECT t from  Team t ");
//		sql.append("left join t.league l ");
//		sql.append("where 1=1 ");
//		sql.append("and l.id = :idLeague ");
//  
//		Query query = em.createQuery(sql.toString());
//		query.setParameter("idLeague", idLeague);
//		return  query.getResultList();
		return null;
	}
	
	public TeamDTO getTean(Long id) {
//		StringBuilder sql = new StringBuilder();
//		sql.append("SELECT t from  Team t ");
//		sql.append("left join t.league l ");
//		sql.append("where 1=1 ");
//		sql.append("and t.id = :id ");
//  
//		Query query = em.createQuery(sql.toString());
//		query.setParameter("id", id);
//		return  (TeamDTO) query.getSingleResult();
		return null;
	}
}

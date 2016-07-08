package org.aaf.engine.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.aaf.model.Economy;

@Stateless
public class EconomyService {

	@PersistenceContext(unitName = "PostgresDS")
	private EntityManager em;
	

	public Economy save(Economy economy){
		if(economy.getId() == null){
			em.persist(economy);
		}else{
			em.merge(economy);
			
		}
		return economy;
	}

}
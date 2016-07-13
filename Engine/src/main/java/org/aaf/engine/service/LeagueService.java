package org.aaf.engine.service;

import java.time.LocalDateTime;
import java.time.Month;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.aaf.engine.dto.CountryDTO;
import org.aaf.engine.names.RegisterCountry;
import org.aaf.model.Country;
import org.aaf.model.League;
import org.aaf.model.Region;

@Stateless
public class LeagueService {

	@PersistenceContext(unitName = "PostgresDS")
	private EntityManager em;

//	@Inject
//	private Logger log;

	@Inject
	private TeamService teamService;
	
	@Inject
	private MatchService matchService;

	public void register(Country country) throws Exception {

	//	log.info("Registering " + country.getName());
		em.persist(country);
	}

	public void save(Country country) throws Exception {

	//	log.info("Registering " + country.getName());
		em.persist(country);
	}

	public void createLeague(CountryDTO country) {
		try {
			Country c = country.getCountry();
			RegisterCountry rc = new RegisterCountry(c.getName());
			
			LocalDateTime startDate = LocalDateTime.of(2016, Month.JUNE, 21, 17, 40, 30);//TODO data arbitraria colocar no formulario a data de inicio.
			c.setDateTimeStart(startDate); 
			c.setIdiom(rc.getIdiom());
			c.setGMT(rc.getGMT());

			em.persist(c);

			registerRegions(c,rc);
			
			Integer indiceJogador = 0;
			for(int i = 1 ; i<=37; i++){
				teamService.register(createLeague(i, country),indiceJogador,rc);	;
			}
			matchService.createMatches(country.getCountry());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	private void registerRegions(Country c, RegisterCountry rc) {
		for(String name :rc.regions.split(";")){
			Region region = new Region();
			region.setCountry(c);
			region.setName(name);
			em.persist(region);
		}
	}

	private League createLeague(int index, CountryDTO country) {

		League league = new League();
		league.setCod(index+"");
		league.setCountry(country.getCountry());
		if(index == 1){
			league.setLevel(1);	
			league.setName(country.getFirtLeague());
		}else if(index > 1 && index < 6){
			league.setLevel(2);
			league.setName("League B " + (index -1));
		}else{
			league.setLevel(3);
			league.setName("League C " + (index -5));
		}
		
		return league;
	}

}
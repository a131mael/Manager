package org.aaf.engine.service;

import java.util.Random;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.aaf.engine.model.Country;
import org.aaf.engine.model.Player;
import org.aaf.engine.model.Team;
import org.aaf.engine.model.TeamLeague;
import org.aaf.engine.names.Brasil;

@Stateless
public class PlayerService {

	@PersistenceContext(unitName = "PostgresDS")
	private EntityManager em;

//	@Inject
//	private Logger log;


	public void save(Country country) throws Exception {

		//log.info("Registering " + country.getName());
		em.persist(country);
	}
	
	public void register(Team team) throws Exception {
		em.persist(team);
		
		for(int i=1; i<=22; i++){
			//em.persist(createPlayer(i, team));
		}

		//log.info("Registering " + team.getName());
		
	}
	
	public void register(TeamLeague teamLeague, Integer indiceJogador) throws Exception {
		Team team = teamLeague.getTeam();
		em.persist(team);
		teamLeague.setTeam(team);
		em.persist(teamLeague);
		
		for(int i=1; i<=22; i++){
			indiceJogador++;
			em.persist(createPlayer(i, teamLeague.getTeam(), teamLeague.getLeague().getCountry(),indiceJogador));
		}

		//log.info("Registering " + team.getName());
		
	}
	
	private Player createPlayer(int index, Team team, Country country, Integer indiceJogador){
		Random gerador = new Random();
		Player player = new Player();
		
		player.setCod(index+"");
		player.setName(country.getName().equalsIgnoreCase(Brasil.nameCountry)?Brasil.getNamesPlayeres().get(indiceJogador):"Jogador " + index);
		player.setTeam(team);
		player.setCountry(country);
		
		
		player.setAge((float) (gerador.nextDouble() * 15)+ 18);
		player.setAggressiveness((float) (gerador.nextDouble() * 8)+ 3);
		player.setAgility((float) (gerador.nextDouble() * 8)+ 4);
		player.setDecision((float) (gerador.nextDouble() * 1)+ 3);
		player.setDisarm((float) (gerador.nextDouble() * 8)+ 3);
		player.setGoalkeaper((float) (gerador.nextDouble() * 6)+ 1);
		player.setHeight((float) (gerador.nextDouble() * 65)+ 150);
		player.setImpulse((float) (gerador.nextDouble() * 8)+ 5);
		player.setKick((float) (gerador.nextDouble() * 8)+ 3);
		player.setMark((float) (gerador.nextDouble() * 8)+ 4);
		player.setPass((float) (gerador.nextDouble() * 8)+ 5);
		player.setPositioning((float) (gerador.nextDouble() * 8)+ 5);
		player.setResistence((float) (gerador.nextDouble() * 8)+ 5);
		player.setStrength((float) (gerador.nextDouble() * 8)+ 5);
		player.setTechnique((float) (gerador.nextDouble() * 8)+ 5);
		player.setVelocity((float) (gerador.nextDouble() * 8)+ 5);
		player.setWorkindex((float) (gerador.nextDouble() * 8)+ 5);
		
		Float value = 100F;
		value+= (player.getAgility())*1000;
		value+= (player.getDecision())*1000;
		value+= (player.getDisarm())*1000;
		value+= (player.getGoalkeaper())*1000;
		value+= (player.getImpulse())*1000;
		value+= (player.getKick())*1000;
		value+= (player.getMark())*1000;
		value+= (player.getPass())*1000;
		value+= (player.getPositioning())*1000;
		value+= (player.getResistence())*1000;
		value+= (player.getResistence())*1000;
		value+= (player.getStrength())*1000;
		value+= (player.getTechnique())*1000;
		value+= (player.getVelocity())*1000;
		value+= (player.getWorkindex())*1000;
		
		Long valueL = (long) Math.round(value) ; 
		
		player.setValue(valueL);
		player.setSalary(value/8);
		player.setIgnore("a");
		
		return player;
	}

}
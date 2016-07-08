package org.aaf.engine.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.aaf.engine.names.Brasil;
import org.aaf.engine.names.RegisterCountry;
import org.aaf.model.Country;
import org.aaf.model.Economy;
import org.aaf.model.LineUp;
import org.aaf.model.Player;
import org.aaf.model.Stadium;
import org.aaf.model.Team;
import org.aaf.model.TeamLeague;
import org.aaf.model.enuns.FanMoodEnum;
import org.aaf.model.enuns.SponsorMoodEnum;

@Stateless
public class PlayerService {

	@PersistenceContext(unitName = "PostgresDS")
	private EntityManager em;

//	@Inject
//	private Logger log;
	
	@Inject
	private LineUpService lineUpService;


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
	
	public void register(TeamLeague teamLeague, Integer indiceJogador, RegisterCountry rc) throws Exception {
		Team team = teamLeague.getTeam();
		em.persist(team);
		teamLeague.setTeam(team);
		em.persist(teamLeague);
		Stadium stadium = createStadium(team);
		em.persist(stadium);
		
		Long sumSalary = 0L;
		for(int i=1; i<=22; i++){
			indiceJogador++;
			Player p = createPlayer(i, teamLeague.getTeam(), teamLeague.getLeague().getCountry(),indiceJogador,rc); 
			em.persist(p);
			sumSalary = (long) (sumSalary + p.getSalary());
		}

		em.persist(createLineUp(team));
		em.persist(createEconomy(team, stadium, sumSalary));
	}
	
	@SuppressWarnings("unchecked")
	public List<Player> getPlayers(Long teamID, String orderBy, String orderByType) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p from  Player p ");
		sql.append("left join p.team t ");
		sql.append("left join p.country c ");
		sql.append("where 1 = 1 ");
		sql.append("and t.id = :teamID ");
		if(orderBy!= null){
			sql.append("ORDER BY p. ");
			sql.append(orderBy);
			sql.append(" ");
			sql.append(orderByType);	
		}
		
		Query query = em.createQuery(sql.toString());
		query.setParameter("teamID", teamID);
		return  query.getResultList();
	}
	
	private LineUp createLineUp(Team team) {
		LineUp lineUp = lineUpService.doLineUp(team);
		
		lineUp.setDate(LocalDateTime.now());
		lineUp.setTeam(team);;
		
		return lineUp;
	}
	
	private Economy createEconomy(Team team, Stadium stadium, long sumSalary) {
		Economy economy = new Economy();
		economy.setTeam(team);
		economy.setCashBox(500000D);
		economy.setCod(team.getCod());
		economy.setFanMood(FanMoodEnum.SATISFIED);
		economy.setFanSize(200L);
		economy.setMaintenenceStadium(stadium.getBleacher()*15 + stadium.getChair() * 10);
		economy.setNewFan(0);
		economy.setReceivedMatch(0);
		economy.setSession(0);
		economy.setSponsorMood(SponsorMoodEnum.SATISFIED);
		economy.setSumPlayerSalary(sumSalary);
		economy.setWeek(0);
		return economy;
	}
	

	private Stadium createStadium(Team team) {
		Stadium stadium = new Stadium();
		stadium.setTeam(team);
		stadium.setBleacher(1000);
		stadium.setChair(4000);
		stadium.setNome(team.getName() + " Stadium"); // Translate
		return stadium;
	}

	private Player createPlayer(int index, Team team, Country country, Integer indiceJogador, RegisterCountry rc){
		Random gerador = new Random();
		Player player = new Player();
		
		player.setCod(index+"");
		player.setName(rc.getNamesPlayeres().get(indiceJogador));
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
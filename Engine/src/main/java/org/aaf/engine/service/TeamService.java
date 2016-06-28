package org.aaf.engine.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

<<<<<<< HEAD
=======
import org.aaf.engine.names.RegisterCountry;
>>>>>>> nootbook2
import org.aaf.model.Country;
import org.aaf.model.League;
import org.aaf.model.Team;
import org.aaf.model.TeamLeague;

<<<<<<< HEAD
=======

>>>>>>> nootbook2
@Stateless
public class TeamService {

	@PersistenceContext(unitName = "PostgresDS")
	private EntityManager em;

<<<<<<< HEAD
	// @Inject
	// private Logger log;

	@Inject
	private PlayerService playerService;

	public void register(League league, Integer indiceJogador) throws Exception {
		em.persist(league);

		
		for (int i = 1; i <= 8; i++) {
			playerService.register(createTeamLeague(i, league),indiceJogador);
		}
=======
	@Inject
	private PlayerService playerService;

	public void register(League league, Integer indiceJogador, RegisterCountry rc) throws Exception {
		em.persist(league);
		

		for (int i = 1; i <= 8; i++) {
			playerService.register(createTeamLeague(i, league,rc),indiceJogador,rc);
		}
		
		//log.info("Registering " + league.getName());
>>>>>>> nootbook2
	}

	public void save(League league) throws Exception {

<<<<<<< HEAD
		em.persist(league);
	}

	private Team createTeam(int index, League league) {
		Team team = new Team();
		team.setCod(index + "");
		team.setName("Time " + index);
		team.setCashBox(500000D);
		// team.setLeague(league);
		return team;
	}

	private TeamLeague createTeamLeague(int index, League league) {
		Team team = new Team();
		team.setCod(index + "");
		team.setName("Time " + index);
		team.setCashBox(500000D);

		TeamLeague teamLeague = new TeamLeague();
		teamLeague.setCod(league.getCod());
		teamLeague.setTeam(team);
		teamLeague.setLeague(league);
		teamLeague.setGoalsPro(0);
		teamLeague.setGoasAgainst(0);
		teamLeague.setLosses(0);
		teamLeague.setMain(true);
		teamLeague.setMatches(0);
		teamLeague.setName(league.getName());
		teamLeague.setPoints(0);
		teamLeague.setVictories(0);

		return teamLeague;
	}

	// TODO MongoDB native query
	// @SuppressWarnings("unchecked")
	// public long countActiveTeamsMONGODB(Country country) {
	// StringBuilder queryLeague = new StringBuilder();
	// queryLeague.append("db.League.find({'country_id': ");
	// queryLeague.append(country.getId());
	// queryLeague.append("})");
	// Query query2 = em.createNativeQuery(queryLeague.toString(),
	// League.class);
	// List<League> leagues = (List<League>) query2.getResultList();
	//
	// StringBuilder queryTeam = new StringBuilder();
	// long countTeam = 0;
	// for (League league : leagues) {
	// queryTeam.append("db.Team.find({'league_id': ");
	// queryTeam.append(league.getId());
	// queryTeam.append(", ");
	// queryTeam.append("'owner_id':{'$exists':true}");
	// queryTeam.append("})");
	// try{
	// countTeam += (Long)
	// em.createNativeQuery(queryTeam.toString()).getSingleResult();
	//
	// }catch(Exception e){
	// //TODO ignore
	// }
	//
	// queryTeam = new StringBuilder();
	// }
	// return countTeam;
	// }

	@SuppressWarnings("unchecked")
	public long countActiveTeams(Country country) {
		StringBuilder queryLeague = new StringBuilder();
		queryLeague.append("Select t from TeamLeague tl ");
		queryLeague.append("join tl.team t ");
		queryLeague.append("join t.owner o ");
		queryLeague.append("left join tl.league l ");
		queryLeague.append("left join l.country c  ");
		queryLeague.append("where 1=1 ");
		queryLeague.append("and c.id = :idPais ");

		Query query = em.createQuery(queryLeague.toString());
		query.setParameter("idPais", country.getId());

		// TODO - trocar size por count
		List<Team> times = query.getResultList();
		Long total = (long) times.size();

=======
	//	log.info("Registering " + league.getName());
		em.persist(league);
	}

	private Team createTeam(int index, League league, RegisterCountry rc) {
		Team team = new Team();
		team.setCod(index + "");
		team.setName(rc.getNamesTeans().get(index));
		team.setCashBox(500000D);
		//team.setLeague(league);
		return team;
	}
	
	private TeamLeague createTeamLeague(int index, League league, RegisterCountry rc) {
		Team team = createTeam(index,league,rc);
		
		TeamLeague teamLeague = new TeamLeague();
		teamLeague.setTeam(team);
		teamLeague.setLeague(league);
		teamLeague.setName(league.getName());
		teamLeague.setCod(league.getCod());
		teamLeague.setMain(true);
		
		return teamLeague;
	}

	//TODO MongoDB native query
	@SuppressWarnings("unchecked")
	public long countActiveTeamsMONGODB(Country country) {
		StringBuilder queryLeague = new StringBuilder();
		queryLeague.append("db.League.find({'country_id': ");
		queryLeague.append(country.getId());
		queryLeague.append("})");
		Query query2 = em.createNativeQuery(queryLeague.toString(), League.class);
		List<League> leagues = (List<League>) query2.getResultList();
		
		StringBuilder queryTeam = new StringBuilder();
		long countTeam = 0;
		for (League league : leagues) {
			queryTeam.append("db.Team.find({'league_id': ");
			queryTeam.append(league.getId());
			queryTeam.append(", ");
			queryTeam.append("'owner_id':{'$exists':true}");
			queryTeam.append("})");
			try{
				countTeam += (Long) em.createNativeQuery(queryTeam.toString()).getSingleResult();
				
			}catch(Exception e){
				//TODO ignore
			}
			
			queryTeam = new StringBuilder();
		}
		return countTeam;
	}

	
	@SuppressWarnings("unchecked")
	public long countActiveTeams(Country country) {
		//TODO what
		StringBuilder queryLeague = new StringBuilder();
		queryLeague.append("Select tl from TeamLeague tl ");
		queryLeague.append("left join tl.team t ");
		queryLeague.append("left join t.owner o ");
		queryLeague.append("left join tl.league l ");
		queryLeague.append("left join l.country c  ");
		queryLeague.append("where 1=1 ");
		queryLeague.append("and o is not null ");
		queryLeague.append("and c.id = :idPais");
		Query query = em.createQuery(queryLeague.toString());
		query.setParameter("idPais", country.getId());
		
		List<Team> times = query.getResultList();
		Long total =  (long) times.size() ;
		
		
>>>>>>> nootbook2
		return total;
	}

	@SuppressWarnings("unchecked")
	public long countCapacity(Country country) {

		StringBuilder queryLeague = new StringBuilder();
<<<<<<< HEAD
		queryLeague.append("Select t from TeamLeague tl ");
=======
		queryLeague.append("Select tl from TeamLeague tl ");
>>>>>>> nootbook2
		queryLeague.append("left join tl.team t ");
		queryLeague.append("left join t.owner o ");
		queryLeague.append("left join tl.league l ");
		queryLeague.append("left join l.country c  ");
		queryLeague.append("where 1=1 ");
<<<<<<< HEAD
		queryLeague.append("and o is null ");
		queryLeague.append("and c.id = :idPais ");
		queryLeague.append("and l.level = :lastLevel");

		Query query = em.createQuery(queryLeague.toString());
		query.setParameter("idPais", country.getId());
		query.setParameter("lastLevel", 3); // TODO - colocado arbitrariamente-
											// buscar a ultima liga

		// TODO - trocar size por count
		List<Team> times = query.getResultList();
		Long total = (long) times.size();

=======
		queryLeague.append("and o is  null ");
		queryLeague.append("and c.id = :idPais");
		Query query = em.createQuery(queryLeague.toString());
		query.setParameter("idPais", country.getId());
		
		List<Team> times = query.getResultList();
		Long total =  (long) times.size() ;
		
		
>>>>>>> nootbook2
		return total;
	}
}
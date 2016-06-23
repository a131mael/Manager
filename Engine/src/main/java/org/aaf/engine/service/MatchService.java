package org.aaf.engine.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.aaf.engine.model.Country;
import org.aaf.engine.model.League;
import org.aaf.engine.model.Match;
import org.aaf.engine.model.Team;
import org.aaf.engine.util.MatchStatusEnum;

@Stateless 
public class MatchService {

	@PersistenceContext(unitName = "PostgresDS")
	private EntityManager em;

//	@Inject
//	private Logger log;

	@Inject
	private LeagueService leagueService;

	@Inject
	private TeamService teamService;
	
	@SuppressWarnings("unchecked")
	public List<Match> getMatchesToExecute(LocalDateTime now){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT m From Match m ");
		sql.append("where 1=1 ");
		sql.append("and m.dateTime < :now ");
		sql.append("and m.matchStatus = :status ");
		
		Query query = em.createQuery(sql.toString());
		query.setParameter("now", now);
		query.setParameter("status", MatchStatusEnum.NOT_PLAYED);
		
		return  query.getResultList();
	}

	public Match save(Match match){
		if(match.getId() == null){
			em.persist(match);
		}else{
			em.merge(match);
			
		}
		return match;
	}
	
	@SuppressWarnings("unchecked")
	public void createMatches(Country country) {
		
		LocalDateTime baseDate = country.getDateTimeStart();

		StringBuilder sql = new StringBuilder();
		sql.append("Select l From League l left join l.country c  where c.id = :countryID ");
		
		Query query = em.createQuery(sql.toString());
		query.setParameter("countryID", country.getId());
		List<League> leagues = (List<League>) query.getResultList();

		List<Integer> index = new ArrayList<>();
		for(int i =0; i<8;i++){ //8 teams per League, if more, chance the number
			index.add(i);
		}
		int index2Group = index.size()/2;

		StringBuilder sqlTeamLeague = new StringBuilder();
		for (League l : leagues) {
			sqlTeamLeague.append("SELECT t From TeamLeague tl left join tl.league l left join tl.team t where l.id = :idLeague ");
			
			Query queryTeans = em.createQuery(sqlTeamLeague.toString());
			queryTeans.setParameter("idLeague", l.getId());
			List<Team> teans = queryTeans.getResultList();

			for(int j=0; j<(teans.size()-1)*2;j++){
				System.out.println("Rodada " + j);
				for(int i=0;i<teans.size()/2;i++){
			
					createMatch(teans.get(i), teans.get(index.get(i+index2Group)), j,country,baseDate);
					System.out.println(teans.get(i).getName() +" x " + teans.get(index.get(i+index2Group)).getName());
					
				}
				escalonar(index);
			}
		
			sqlTeamLeague = new StringBuilder();

		}
	}
		
	private static void escalonar(List<Integer> index) {
		int finalIndex = index.size()-1;
		List<Integer> indexClone = new ArrayList<>();
		indexClone.addAll(index);
		for(int i=1; i<=finalIndex;i++){
			index.set(i, indexClone.get(adjustIndex(i+1,finalIndex)));
		}
	}

	private static int adjustIndex(int index, int maxIdex) {
		if (index > maxIdex) {
			return 1;
		}
		return index;
	}

	private void createMatch(Team team, Team team2, int round, Country country, LocalDateTime dateExecution) {
		Match match = new Match();
		match.setRound(round);
		match.setWeek(String.valueOf(round));
		match.setSession("0");
		if(round%2==0){
			match.setHomeTeam(team);
			match.setVisitTeam(team2);
		}else{
			match.setHomeTeam(team2);
			match.setVisitTeam(team);
		}
		
		LocalDateTime dateGame = dateExecution.plusDays(0); //Adiciona 3 dias a partir do cadastro do pais -> forma correta buscar primeiro domingo
		dateGame = dateGame.plusDays(country.getSession()*7*15); //Contagem de temporadas - o dia do jogo é referente a temporada em que ele esta 
		dateGame = dateGame.plusDays(round*7); // 1 jogo por semana 
		
		match.setDateTime(dateGame);
		match.setMatchStatus(MatchStatusEnum.NOT_PLAYED);
		em.persist(match);

	}

}
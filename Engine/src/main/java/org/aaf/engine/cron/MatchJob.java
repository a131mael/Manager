package org.aaf.engine.cron;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.aaf.engine.service.LineUpService;
import org.aaf.engine.service.MatchService;
import org.aaf.engine.util.ServiceLocator;
import org.aaf.model.LineUp;
import org.aaf.model.Match;
import org.aaf.model.MatchStatusEnum;
import org.aaf.model.PositionEnum;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MatchJob implements Job {

	@Inject
	private Logger log;

	private MatchService service;
	
	private LineUpService lineUpService;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		try {
			System.out.println("EXECUTANDO PARTIDAS");
			
			LocalDateTime agora = LocalDateTime.now();
			service = (MatchService) ServiceLocator.getInstance().getEJB("java:global/Engine/MatchService!org.aaf.engine.service.MatchService");
			lineUpService = (LineUpService) ServiceLocator.getInstance().getEJB("java:global/Engine/LineUpService!org.aaf.engine.service.LineUpService");
			Thread.sleep(10000);
			List<Match> matchesToExecute = service.getMatchesToExecute(agora);
			System.out.println("Size: ---> " + matchesToExecute.size());

			//APENAS COLOCA OS JOGOS COMO EM EXECUÇAO
			for(Match match :matchesToExecute){
				match.setMatchStatus(MatchStatusEnum.PLAYING);
				service.save(match);
			}
			
			//EXECUTA AS PARTIDAS
			Random gerador = new Random();	
			for(Match match :matchesToExecute){
				LineUp lineUpHomeTeam = lineUpService.getLineUp(match.getId(), match.getHomeTeam().getId());
				LineUp lineUpVisitTeam = lineUpService.getLineUp(match.getId(), match.getVisitTeam().getId());
				
				if(lineUpHomeTeam == null){
					lineUpHomeTeam = lineUpService.getLastLineUp(match.getHomeTeam().getId());
				}
				
				if(lineUpVisitTeam == null){
					lineUpVisitTeam = lineUpService.getLastLineUp(match.getVisitTeam().getId());
				}
				
				
				lineUpHomeTeam.setRate1(gerador.nextInt(100));
				lineUpHomeTeam.setRate2(gerador.nextInt(100));
				lineUpHomeTeam.setRate3(gerador.nextInt(100));
				lineUpHomeTeam.setRate4(gerador.nextInt(100));
				lineUpHomeTeam.setRate5(gerador.nextInt(100));
				lineUpHomeTeam.setRate6(gerador.nextInt(100));
				lineUpHomeTeam.setRate7(gerador.nextInt(100));
				lineUpHomeTeam.setRate8(gerador.nextInt(100));
				lineUpHomeTeam.setRate9(gerador.nextInt(100));
				lineUpHomeTeam.setRate10(gerador.nextInt(100));
				lineUpHomeTeam.setRate11(gerador.nextInt(100));
				
				lineUpVisitTeam.setRate1(gerador.nextInt(100));
				lineUpVisitTeam.setRate2(gerador.nextInt(100));
				lineUpVisitTeam.setRate3(gerador.nextInt(100));
				lineUpVisitTeam.setRate4(gerador.nextInt(100));
				lineUpVisitTeam.setRate5(gerador.nextInt(100));
				lineUpVisitTeam.setRate6(gerador.nextInt(100));
				lineUpVisitTeam.setRate7(gerador.nextInt(100));
				lineUpVisitTeam.setRate8(gerador.nextInt(100));
				lineUpVisitTeam.setRate9(gerador.nextInt(100));
				lineUpVisitTeam.setRate10(gerador.nextInt(100));
				lineUpVisitTeam.setRate11(gerador.nextInt(100));
				
				if(lineUpHomeTeam.getMatch() == null){
					lineUpHomeTeam.setMatch(match);
				}
				if(lineUpVisitTeam.getMatch() == null){
					lineUpVisitTeam.setMatch(match);
				}
				
				lineUpService.save(lineUpHomeTeam);
				lineUpService.save(lineUpVisitTeam);
				
				match.setGolasHomeTeam(gerador.nextInt(5));
				match.setGolasVisitTeam(gerador.nextInt(5));
				match.setMatchStatus(MatchStatusEnum.PLAYED);
				service.save(match);
			}
		
		} catch (Exception e) {
			log.info("ERRO AO EXECUTAR PARTIDAS");
		}
		System.out.println("EXECUTOU PARTIDAS");

	}

}

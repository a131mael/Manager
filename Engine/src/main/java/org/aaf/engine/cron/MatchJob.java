package org.aaf.engine.cron;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.aaf.engine.model.Match;
import org.aaf.engine.service.MatchService;
import org.aaf.engine.util.MatchStatusEnum;
import org.aaf.engine.util.ServiceLocator;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MatchJob implements Job {

	@Inject
	private Logger log;

	private MatchService service;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		try {
			System.out.println("EXECUTANDO PARTIDAS");
			
			LocalDateTime agora = LocalDateTime.now();
			service = (MatchService) ServiceLocator.getInstance().getEJB("java:global/Engine/MatchService!org.aaf.engine.service.MatchService");
			Thread.sleep(10000);
			List<Match> matchesToExecute = service.getMatchesToExecute(agora);
			System.out.println("Size: ---> " + matchesToExecute.size());
			for(Match match :matchesToExecute){
				match.setMatchStatus(MatchStatusEnum.PLAYING);
				service.save(match);
			}
			
			
//			service = ServiceLocator.getInstance().getEJB("java:global/Engine/CountryService!org.aaf.engine.service.CountryService");
//			
//			CountryDTO country = new CountryDTO();
//			country.setCod("1");
//			country.setName("Pais 1");
//			service.register(country);
		} catch (Exception e) {
			log.info("ERRO AO EXECUTAR PARTIDAS");
		}
		System.out.println("EXECUTOU PARTIDAS");

	}

}

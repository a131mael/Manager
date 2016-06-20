package org.aaf.engine.cron;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.aaf.engine.service.MatchService;
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

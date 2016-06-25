package org.aaf.engine.cron;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.aaf.engine.service.LineUpService;
import org.aaf.engine.service.MatchService;
import org.aaf.engine.util.ServiceLocator;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class EconomyJob implements Job {

	@Inject
	private Logger log;

	private MatchService service;
	
	private LineUpService lineUpService;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		try {
			System.out.println("Atualizando economy");
			
			service = (MatchService) ServiceLocator.getInstance().getEJB("java:global/Engine/MatchService!org.aaf.engine.service.MatchService");
		
		} catch (Exception e) {
			log.info("ERRO AO Atualizar economia");
		}
		System.out.println("Atualizou economia");

	}

}

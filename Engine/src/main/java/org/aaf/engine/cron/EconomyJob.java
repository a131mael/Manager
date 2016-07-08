package org.aaf.engine.cron;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.aaf.engine.service.CountryService;
import org.aaf.engine.service.EconomyService;
import org.aaf.engine.util.ServiceLocator;
import org.aaf.model.Country;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/*EXECUTA SABADO */

public class EconomyJob implements Job {

	@Inject
	private Logger log;

	private EconomyService service;
	
	private CountryService countryService;
	

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		try {
			System.out.println("Atualizando economy");
			
			service = (EconomyService) ServiceLocator.getInstance().getEJB("java:global/Engine/EconomyService!org.aaf.engine.service.EconomyService");
			countryService = (CountryService) ServiceLocator.getInstance().getEJB("java:global/Engine/CountryService!org.aaf.engine.service.CountryService");
			
			List<Country> countries = countryService.findAll();
			for(Country country :countries){
				
				if(country.getGMT() == 0){
					
				}
			}
			
		} catch (Exception e) {
			log.info("ERRO AO Atualizar economia");
		}
		System.out.println("Atualizou economia");

	}

}

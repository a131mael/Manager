package org.aaf.uiweb.service;

import org.aaf.dto.EconomyDTO;
import org.aaf.uiweb.util.EndPoints;

public class EconomyService extends Service{

	public EconomyDTO getEconomy(Long teamID, int session, int week) {
		StringBuilder endPoint = new StringBuilder();
		endPoint.append(EndPoints.GET_ECONOMY);
		endPoint.append(teamID);
		endPoint.append("/");
		endPoint.append(session);
		endPoint.append("/");
		endPoint.append(week);
		return (EconomyDTO) getObject(endPoint.toString());
	}
	
}

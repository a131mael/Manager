package org.aaf.uiweb.service;

import org.aaf.uiweb.util.EndPoints;

public class EconomyService extends Service{

	public Long getTotalSalary(Long teamID) {
		String endPoint = EndPoints.GET_SALARY_TEAM + teamID;
		return (Long) getObject(endPoint);
	}
   
	public Long getTotalMathes(Long teamID) {
		String endPoint = EndPoints.GET_SALARY_TEAM + teamID;
		return (Long) getObject(endPoint);
	}
   
	public Long getTotalOthers(Long teamID) {
		String endPoint = EndPoints.GET_SALARY_TEAM + teamID;
		return (Long) getObject(endPoint);
	}
	
	public Long getTotalSallesPlayer(Long teamID) {
		String endPoint = EndPoints.GET_SALARY_TEAM + teamID;
		return (Long) getObject(endPoint);
	}
	
	public Long getTotalPurchasePlayer(Long teamID) {
		String endPoint = EndPoints.GET_SALARY_TEAM + teamID;
		return (Long) getObject(endPoint);
	}
	
	public Long getTotalIncreaseSupporters(Long teamID) {
		String endPoint = EndPoints.GET_SALARY_TEAM + teamID;
		return (Long) getObject(endPoint);
	}
	
	public Long getTotalStadiumMaintence(Long teamID) {
		String endPoint = EndPoints.GET_SALARY_TEAM + teamID;
		return (Long) getObject(endPoint);
	}
	
	public Long getTotalSalaryJuniors(Long teamID) {
		String endPoint = EndPoints.GET_SALARY_TEAM + teamID;
		return (Long) getObject(endPoint);
	}
	
	public Long getTotalSalaryStaff(Long teamID) {
		String endPoint = EndPoints.GET_SALARY_TEAM + teamID;
		return (Long) getObject(endPoint);
	}
	
	public Long getTotalMoney(Long teamID) {
		String endPoint = EndPoints.GET_SALARY_TEAM + teamID;
		return (Long) getObject(endPoint);
	}
}

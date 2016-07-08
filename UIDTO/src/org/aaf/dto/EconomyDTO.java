package org.aaf.dto;

import java.io.Serializable;

import org.aaf.model.enuns.FanMoodEnum;
import org.aaf.model.enuns.SponsorMoodEnum;

public class EconomyDTO implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long totalSalary;
	
	private Long totalMatches;
	
	private Long totalOthersPositive;
	
	private Long totalSallesPlayers;
	
	private Long totalPurchasePlayers;

	private Long totalIncreaseSupportes;
	
	private Long totalStadiumMaintence;

	private Long totalSalaryJuniors;
	
	private Long totalSalaryStaff;
	
	private Long totalMoney;
	
	
	/*VERIFICAR SE PRECISA REMOVER DAQUI PRA CIMA*/
	
	private Long id;

	private String cod;
	
	private TeamDTO team;
	
	private int session;
	
	private int week;
	
	private Long fanSize;
	
	private int newFan;
	
	private long maintenenceStadium;
	
	private long receivedMatch;
	
	private long sumPlayerSalary;
	
	private Double cashBox;

	private FanMoodEnum fanMood;
	
	private SponsorMoodEnum sponsorMood;
	
	
	@Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
       
        final EconomyDTO other = (EconomyDTO) obj;
        if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

	public Long getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(Long totalSalary) {
		this.totalSalary = totalSalary;
	}

	public Long getTotalMatches() {
		return totalMatches;
	}

	public void setTotalMatches(Long totalMatches) {
		this.totalMatches = totalMatches;
	}

	public Long getTotalOthersPositive() {
		return totalOthersPositive;
	}

	public void setTotalOthersPositive(Long totalOthersPositive) {
		this.totalOthersPositive = totalOthersPositive;
	}

	public Long getTotalSallesPlayers() {
		return totalSallesPlayers;
	}

	public void setTotalSallesPlayers(Long totalSallesPlayers) {
		this.totalSallesPlayers = totalSallesPlayers;
	}

	public Long getTotalPurchasePlayers() {
		return totalPurchasePlayers;
	}

	public void setTotalPurchasePlayers(Long totalPurchasePlayers) {
		this.totalPurchasePlayers = totalPurchasePlayers;
	}

	public Long getTotalIncreaseSupportes() {
		return totalIncreaseSupportes;
	}

	public void setTotalIncreaseSupportes(Long totalIncreaseSupportes) {
		this.totalIncreaseSupportes = totalIncreaseSupportes;
	}

	public Long getTotalStadiumMaintence() {
		return totalStadiumMaintence;
	}

	public void setTotalStadiumMaintence(Long totalStadiumMaintence) {
		this.totalStadiumMaintence = totalStadiumMaintence;
	}

	public Long getTotalSalaryJuniors() {
		return totalSalaryJuniors;
	}

	public void setTotalSalaryJuniors(Long totalSalaryJuniors) {
		this.totalSalaryJuniors = totalSalaryJuniors;
	}

	public Long getTotalSalaryStaff() {
		return totalSalaryStaff;
	}

	public void setTotalSalaryStaff(Long totalSalaryStaff) {
		this.totalSalaryStaff = totalSalaryStaff;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Long totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public TeamDTO getTeam() {
		return team;
	}

	public void setTeam(TeamDTO team) {
		this.team = team;
	}

	public int getSession() {
		return session;
	}

	public void setSession(int session) {
		this.session = session;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public Long getFanSize() {
		return fanSize;
	}

	public void setFanSize(Long fanSize) {
		this.fanSize = fanSize;
	}

	public int getNewFan() {
		return newFan;
	}

	public void setNewFan(int newFan) {
		this.newFan = newFan;
	}

	public long getMaintenenceStadium() {
		return maintenenceStadium;
	}

	public void setMaintenenceStadium(long maintenenceStadium) {
		this.maintenenceStadium = maintenenceStadium;
	}

	public long getReceivedMatch() {
		return receivedMatch;
	}

	public void setReceivedMatch(long receivedMatch) {
		this.receivedMatch = receivedMatch;
	}

	public long getSumPlayerSalary() {
		return sumPlayerSalary;
	}

	public void setSumPlayerSalary(long sumPlayerSalary) {
		this.sumPlayerSalary = sumPlayerSalary;
	}

	public Double getCashBox() {
		return cashBox;
	}

	public void setCashBox(Double cashBox) {
		this.cashBox = cashBox;
	}

	public FanMoodEnum getFanMood() {
		return fanMood;
	}

	public void setFanMood(FanMoodEnum fanMood) {
		this.fanMood = fanMood;
	}

	public SponsorMoodEnum getSponsorMood() {
		return sponsorMood;
	}

	public void setSponsorMood(SponsorMoodEnum sponsorMood) {
		this.sponsorMood = sponsorMood;
	}
	
}
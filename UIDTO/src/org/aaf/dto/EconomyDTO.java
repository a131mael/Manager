package org.aaf.dto;

import java.io.Serializable;

public class EconomyDTO implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
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
	
}
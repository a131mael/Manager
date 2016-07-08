package org.aaf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.aaf.model.enuns.FanMoodEnum;
import org.aaf.model.enuns.SponsorMoodEnum;

@Entity
public class Economy {

	@Id
	@GeneratedValue(generator = "GENERATE_Economy", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "GENERATE_Economy", sequenceName = "Economy_pk_seq", allocationSize = 1)
	private Long id;

	@Column
	private String cod;
	
	@ManyToOne
	private Team team;
	
	@Column
	private int session;
	
	@Column
	private int week;
	
	@Column
	private Long fanSize;
	
	@Column
	private int newFan;
	
	@Column
	private long maintenenceStadium;
	
	@Column
	private long receivedMatch;
	
	@Column
	private long sumPlayerSalary;
	
	@Column
	private Double cashBox;

	@Column
	private FanMoodEnum fanMood;
	
	@Column
	private SponsorMoodEnum sponsorMood;
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cashBox == null) ? 0 : cashBox.hashCode());
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
		result = prime * result + ((fanMood == null) ? 0 : fanMood.hashCode());
		result = prime * result + ((fanSize == null) ? 0 : fanSize.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (int) (maintenenceStadium ^ (maintenenceStadium >>> 32));
		result = prime * result + newFan;
		result = prime * result + (int) (receivedMatch ^ (receivedMatch >>> 32));
		result = prime * result + session;
		result = prime * result + ((sponsorMood == null) ? 0 : sponsorMood.hashCode());
		result = prime * result + (int) (sumPlayerSalary ^ (sumPlayerSalary >>> 32));
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		result = prime * result + week;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Economy other = (Economy) obj;
		if (cashBox == null) {
			if (other.cashBox != null)
				return false;
		} else if (!cashBox.equals(other.cashBox))
			return false;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		if (fanMood != other.fanMood)
			return false;
		if (fanSize == null) {
			if (other.fanSize != null)
				return false;
		} else if (!fanSize.equals(other.fanSize))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (maintenenceStadium != other.maintenenceStadium)
			return false;
		if (newFan != other.newFan)
			return false;
		if (receivedMatch != other.receivedMatch)
			return false;
		if (session != other.session)
			return false;
		if (sponsorMood != other.sponsorMood)
			return false;
		if (sumPlayerSalary != other.sumPlayerSalary)
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		if (week != other.week)
			return false;
		return true;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
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
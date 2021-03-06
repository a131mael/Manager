package org.aaf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.aaf.model.enuns.FanMoodEnum;
import org.aaf.model.enuns.SponsorMoodEnum;

@Entity
public class Team {

	@Id
	@GeneratedValue(generator = "GENERATE_Team", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "GENERATE_Team", sequenceName = "Team_pk_seq", allocationSize = 1)
	private Long id;

	@Column
	private String name;

	@Column
	private String cod;
	
	@Column
	private Double cashBox;

	private FanMoodEnum fanMood;
	
	private SponsorMoodEnum sponsorMood;
	
	private Long fanSize;
	
	@OneToOne
	private UserFM owner;
	
	@ManyToOne
	private Region region;

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserFM getOwner() {
		return owner;
	}

	public void setOwner(UserFM owner) {
		this.owner = owner;
	}

	public Double getCashBox() {
		return cashBox;
	}

	public void setCashBox(Double cashBox) {
		this.cashBox = cashBox;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
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

	public long getFanSize() {
		return fanSize;
	}

	public void setFanSize(long fanSize) {
		this.fanSize = fanSize;
	}

}
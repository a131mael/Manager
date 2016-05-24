package org.aaf.ui.DTO;

import java.util.Date;

public class MatchDTO {

	private Long id;

	private Date date;

	private String cod;

	private String session;

	private String week;

	private TeamDTO homeTeam;

	private TeamDTO visitTeam;

	private int golasHomeTeam;

	private int golasVisitTeam;

	private int round;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TeamDTO getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(TeamDTO homeTeam) {
		this.homeTeam = homeTeam;
	}

	public TeamDTO getVisitTeam() {
		return visitTeam;
	}

	public void setVisitTeam(TeamDTO visitTeam) {
		this.visitTeam = visitTeam;
	}

	public int getGolasHomeTeam() {
		return golasHomeTeam;
	}

	public void setGolasHomeTeam(int golasHomeTeam) {
		this.golasHomeTeam = golasHomeTeam;
	}

	public int getGolasVisitTeam() {
		return golasVisitTeam;
	}

	public void setGolasVisitTeam(int golasVisitTeam) {
		this.golasVisitTeam = golasVisitTeam;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}


}
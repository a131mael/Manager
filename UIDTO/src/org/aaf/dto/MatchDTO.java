package org.aaf.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MatchDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private LocalDateTime date;

	private String cod;

	private String session;

	private String week;

	private TeamDTO homeTeam;

	private TeamDTO visitTeam;

	private int golasHomeTeam;

	private int golasVisitTeam;

	private int round;
	
	private LineUpDTO lineUpHomeTeam;
	
	private LineUpDTO lineUpVisitTeam;

	@Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
       
        final MatchDTO other = (MatchDTO) obj;
        if (this.getId() != other.getId() && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public LineUpDTO getLineUpHomeTeam() {
		return lineUpHomeTeam;
	}

	public void setLineUpHomeTeam(LineUpDTO lineUpHomeTeam) {
		this.lineUpHomeTeam = lineUpHomeTeam;
	}

	public LineUpDTO getLineUpVisitTeam() {
		return lineUpVisitTeam;
	}

	public void setLineUpVisitTeam(LineUpDTO lineUpVisitTeam) {
		this.lineUpVisitTeam = lineUpVisitTeam;
	}


}
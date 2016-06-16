package org.aaf.dto;

import java.io.Serializable;

public class TeamLeagueDTO implements Serializable, Comparable<TeamLeagueDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String cod;

	private LeagueDTO league;

	private boolean main;

	private TeamDTO team;

	private int points;

	private int goalsPro;

	private int goasAgainst;

	private int matches;

	private int victories;

	private int losses;

	public TeamLeagueDTO() {

	}

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

	public LeagueDTO getLeague() {
		return league;
	}

	public void setLeague(LeagueDTO league) {
		this.league = league;
	}

	@Override
	public int compareTo(TeamLeagueDTO o) {
		if (o.getPoints() > this.points) {
			return 1;
		} else if (o.getPoints() < this.points) {
			return -1;
		} else {

			return 0;
		}
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public boolean isMain() {
		return main;
	}

	public void setMain(boolean main) {
		this.main = main;
	}

	public TeamDTO getTeam() {
		return team;
	}

	public void setTeam(TeamDTO team) {
		this.team = team;
	}

	public int getGoalsPro() {
		return goalsPro;
	}

	public void setGoalsPro(int goalsPro) {
		this.goalsPro = goalsPro;
	}

	public int getGoasAgainst() {
		return goasAgainst;
	}

	public void setGoasAgainst(int goasAgainst) {
		this.goasAgainst = goasAgainst;
	}

	public int getMatches() {
		return matches;
	}

	public void setMatches(int matches) {
		this.matches = matches;
	}

	public int getVictories() {
		return victories;
	}

	public void setVictories(int victories) {
		this.victories = victories;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

}
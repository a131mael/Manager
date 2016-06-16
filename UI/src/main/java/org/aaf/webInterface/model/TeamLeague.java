package org.aaf.webInterface.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class TeamLeague {

	@Id
	@GeneratedValue(generator = "GENERATE_TeamLeague", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "GENERATE_TeamLeague", sequenceName = "TeamLeague_pk_seq", allocationSize = 1)
	private Long id;

	private String name;

	private String cod;
	
	private boolean main;
	
	@ManyToOne
	private Team team;
	
	@ManyToOne
	private League league;
	
	private int points;
	
	private int goalsPro;
	
	private int goasAgainst;
	
	private int matches;
	
	private int victories;
	
	private int losses;

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

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public boolean isMain() {
		return main;
	}

	public void setMain(boolean main) {
		this.main = main;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
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
package org.aaf.uiweb.dto;

public class TeamDTO {

	private Long id;

	private String name;
	
	private String cod;

	private LeagueDTO league;
	
	private UserDTO owner;
	
	private Double cashBox;

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

	public UserDTO getOwner() {
		return owner;
	}

	public void setOwner(UserDTO owner) {
		this.owner = owner;
	}

	public Double getCashBox() {
		return cashBox;
	}

	public void setCashBox(Double cashBox) {
		this.cashBox = cashBox;
	}

}
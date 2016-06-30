package org.aaf.dto;

import java.io.Serializable;

import org.aaf.model.enuns.IdionsEnum;
import org.json.JSONObject;

public class TeamDTO implements Serializable, Comparable<TeamDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String cod;

	private LeagueDTO league;

	private UserDTO owner;

	private StadiumDTO stadium;

	private Double cashBox;

	private int points;

	private IdionsEnum idiom;

	private RegionDTO region;

	public TeamDTO() {

	}

	@Deprecated // 04/06/16
	public TeamDTO(JSONObject json) {
		if (json != null) {
			this.id = !json.isNull("id") ? json.getLong("id") : null;
			this.name = !json.isNull("name") ? json.getString("name") : null;
			this.cod = !json.isNull("cod") ? json.getString("cod") : null;
			this.setLeague(new LeagueDTO(!json.isNull("league") ? json.getJSONObject("league") : null));
			this.setOwner(new UserDTO(!json.isNull("owner") ? json.getJSONObject("owner") : null));
			this.cashBox = !json.isNull("cashBox") ? json.getDouble("cashBox") : null;
		}

	}

	@Deprecated // 04/06/16
	public JSONObject getJSON() {
		// JSONObject object=new JSONObject(this);
		JSONObject object = new JSONObject();
		object.put("id", this.id);
		object.put("name", this.name);
		object.put("cod", this.cod);
		object.put("league", this.league);
		object.put("owner", this.owner);
		object.put("cashBox", this.cashBox);
		return object;
	}

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

		final TeamDTO other = (TeamDTO) obj;
		if (this.getId() != other.getId() && (this.id == null || !this.id.equals(other.id))) {
			return false;
		}
		return true;
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

	public Double getCashBox() {
		return cashBox;
	}

	public void setCashBox(Double cashBox) {
		this.cashBox = cashBox;
	}

	public UserDTO getOwner() {
		return owner;
	}

	public void setOwner(UserDTO owner) {
		this.owner = owner;
	}

	public LeagueDTO getLeague() {
		return league;
	}

	public void setLeague(LeagueDTO league) {
		this.league = league;
	}

	@Override
	public int compareTo(TeamDTO o) {
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

	public StadiumDTO getStadium() {
		return stadium;
	}

	public void setStadium(StadiumDTO stadium) {
		this.stadium = stadium;
	}

	public IdionsEnum getIdiom() {
		return idiom;
	}

	public void setIdiom(IdionsEnum idiom) {
		this.idiom = idiom;
	}

	public RegionDTO getRegion() {
		return region;
	}

	public void setRegion(RegionDTO region) {
		this.region = region;
	}

}
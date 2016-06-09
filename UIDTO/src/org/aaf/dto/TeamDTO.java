package org.aaf.dto;

import org.json.JSONObject;


public class TeamDTO {

	private Long id;

	private String name;
	
	private String cod;

	private LeagueDTO league;
	
	private UserDTO owner;
	
	private Double cashBox;
	
	
	public TeamDTO(){
		
	}
	
	@Deprecated //04/06/16
	public TeamDTO(JSONObject json) {
		 System.out.println(json.get("id"));
		 this.id = !json.isNull("id")  ?json.getLong("id"):null;
		 this.name = !json.isNull("name")  ?json.getString("name"):null;
		 this.cod = !json.isNull("cod") ?json.getString("cod"):null;
		 this.setLeague(new LeagueDTO(!json.isNull("league")?json.getJSONObject("league"):null));
		 this.setOwner(new UserDTO(!json.isNull("owner")?json.getJSONObject("owner"):null));
		 this.cashBox = !json.isNull("cashBox") ?json.getDouble("cashBox"):null;
	}
	
	@Deprecated //04/06/16
	public JSONObject getJSON(){
		//JSONObject object=new JSONObject(this);
		JSONObject object=new JSONObject();
		object.put("id", this.id);
		object.put("name", this.name);
		object.put("cod", this.cod);
		object.put("league", this.league);
		object.put("owner", this.owner);
		object.put("cashBox", this.cashBox);
		return object;
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

}
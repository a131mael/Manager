package org.aaf.dto;

import org.aaf.webInterface.model.Team;
import org.aaf.webInterface.model.UserFM;
import org.aaf.webInterface.util.Convertes;
import org.json.JSONObject;


public class TeamDTO2 {

	private Long id;

	private String name;
	
	private String cod;

	private LeagueDTO2 league;
	
	private UserDTO2 owner;
	
	private Double cashBox;
	
	
	public TeamDTO2(){
		
	}
	
	public TeamDTO2(JSONObject json) {
		 System.out.println(json.get("id"));
		 this.id = !json.isNull("id")  ?json.getLong("id"):null;
		 this.name = !json.isNull("name")  ?json.getString("name"):null;
		 this.cod = !json.isNull("cod") ?json.getString("cod"):null;
		 this.setLeague(new LeagueDTO2(!json.isNull("league")?json.getJSONObject("league"):null));
		 this.setOwner(new UserDTO2(!json.isNull("owner")?json.getJSONObject("owner"):null));
		 this.cashBox = !json.isNull("cashBox") ?json.getDouble("cashBox"):null;
	}
	
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
	
	public Team getTeam(JSONObject json){
		//TODO - importante fazer resto do metodo
		JSONObject jsonObject = new JSONObject(json);

		
		return null;
	}
	
	public Team getTeam(String teamJson){
		JSONObject jsonObject = new JSONObject(teamJson);
		
		Team team = new Team();
		team.setCashBox(!jsonObject.isNull("cashBox")?jsonObject.getDouble("cashBox"):null);
		team.setId(!jsonObject.isNull("id")?jsonObject.getLong("id"):null);
		team.setCod(!jsonObject.isNull("cod")?jsonObject.getString("cod"):null);
		team.setName(!jsonObject.isNull("name")?jsonObject.getString("name"):null);
		
//		team.setOwner(Convertes.getUser((UserDTO) jsonObject.get("owner")));
		
		
		return team;
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

	public UserDTO2 getOwner() {
		return owner;
	}

	public void setOwner(UserDTO2 owner) {
		this.owner = owner;
	}

	public LeagueDTO2 getLeague() {
		return league;
	}

	public void setLeague(LeagueDTO2 league) {
		this.league = league;
	}

}
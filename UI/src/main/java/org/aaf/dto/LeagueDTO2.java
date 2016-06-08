package org.aaf.dto;

import java.util.List;

import org.json.JSONObject;

public class LeagueDTO2 {


	private Long id;

	private String name;

	private String cod;
	
	private int level;
	
	private List<TeamDTO2> teans;

	private CountryDTO2 country;

	public String getCod() {
		return cod;
	}
	
	public LeagueDTO2(){
		
	}
	
	public LeagueDTO2(JSONObject json){
		if(json != null){
			this.id = !json.isNull("id") ? json.getLong("id"):null;
			this.name = !json.isNull("name") ? json.getString("name"):null;
			this.cod = !json.isNull("cod") ? json.getString("cod"):null;
			this.level = !json.isNull("level") ? json.getInt("level"):null;
			this.country = new CountryDTO2(json.getJSONObject("country"));
			//TODO - importante falou o teans
		}
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

	public CountryDTO2 getCountry() {
		return country;
	}

	public void setCountry(CountryDTO2 country) {
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<TeamDTO2> getTeans() {
		return teans;
	}

	public void setTeans(List<TeamDTO2> teans) {
		this.teans = teans;
	}

}
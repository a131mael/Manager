package org.aaf.dto;

import java.util.List;

import org.json.JSONObject;

public class LeagueDTO {


	private Long id;

	private String name;

	private String cod;
	
	private int level;
	
	private List<TeamDTO> teans;

	private CountryDTO country;

	public String getCod() {
		return cod;
	}
	
	public LeagueDTO(){
		
	}
	
	public LeagueDTO(JSONObject json){
		if(json != null){
			this.id = !json.isNull("id") ? json.getLong("id"):null;
			this.name = !json.isNull("name") ? json.getString("name"):null;
			this.cod = !json.isNull("cod") ? json.getString("cod"):null;
			this.level = !json.isNull("level") ? json.getInt("level"):null;
			this.country = new CountryDTO(json.getJSONObject("country"));
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

	public CountryDTO getCountry() {
		return country;
	}

	public void setCountry(CountryDTO country) {
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

	public List<TeamDTO> getTeans() {
		return teans;
	}

	public void setTeans(List<TeamDTO> teans) {
		this.teans = teans;
	}

}
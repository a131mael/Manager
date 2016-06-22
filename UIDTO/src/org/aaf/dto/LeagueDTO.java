package org.aaf.dto;

import java.io.Serializable;
import java.util.List;

import org.json.JSONObject;

public class LeagueDTO implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
       
        final LeagueDTO other = (LeagueDTO) obj;
        if (this.getId() != other.getId() && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
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
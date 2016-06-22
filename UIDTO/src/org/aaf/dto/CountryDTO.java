package org.aaf.dto;

import java.io.Serializable;

import org.json.JSONObject;

public class CountryDTO implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
 
    private String name;
 
    private String cod;
    
    private int session;
    
    private int week;
    
    public CountryDTO(){}
    
    public CountryDTO(JSONObject json){
    	if(json != null){
    		
    		this.id = !json.isNull("id") ? json.getLong("id"):null;
    		this.name = !json.isNull("name") ?json.getString("name"):null;
    		this.cod = !json.isNull("cod") ?json.getString("cod"):null;
    		this.session = !json.isNull("session") ?json.getInt("session"):null;
    		this.week = !json.isNull("week") ?json.getInt("week"):null;
    	}
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

	public int getSession() {
		return session;
	}

	public void setSession(int session) {
		this.session = session;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
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
       
        final CountryDTO other = (CountryDTO) obj;
        if (this.getId() != other.getId() && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
package org.aaf.ui.DTO;

import java.util.List;

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
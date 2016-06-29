package org.aaf.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.aaf.model.enuns.IdionsEnum;
import org.json.JSONObject;

public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String cod;

	private String email;

	private TeamDTO team;

	private String login;

	private String senha;

	private CountryDTO countryDTO;

	private LeagueDTO mainLeague;
	
	private LocalDate enteredInto;
	
	private IdionsEnum idiom;

	public UserDTO() {
	}

	@SuppressWarnings("deprecation")
	public UserDTO(JSONObject json) {
		if (json != null) {
			this.id = !json.isNull("id") ? json.getLong("id") : null;
			this.name = !json.isNull("id") ? json.getString("name") : null;
			this.cod = !json.isNull("id") ? json.getString("cod") : null;
			this.email = !json.isNull("id") ? json.getString("email") : null;
			this.team = new TeamDTO(json.isNull("team") ? null : json.getJSONObject("team"));
			this.login = !json.isNull("id") ? json.getString("login") : null;
			this.senha = !json.isNull("id") ? json.getString("senha") : null;
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

		final UserDTO other = (UserDTO) obj;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TeamDTO getTeam() {
		return team;
	}

	public void setTeam(TeamDTO team) {
		this.team = team;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CountryDTO getCountryDTO() {
		return countryDTO;
	}

	public void setCountryDTO(CountryDTO countryDTO) {
		this.countryDTO = countryDTO;
	}

	public LeagueDTO getMainLeague() {
		return mainLeague;
	}

	public void setMainLeague(LeagueDTO mainLeague) {
		this.mainLeague = mainLeague;
	}

	public LocalDate getEnteredInto() {
		return enteredInto;
	}

	public void setEnteredInto(LocalDate enteredInto) {
		this.enteredInto = enteredInto;
	}

	public IdionsEnum getIdiom() {
		return idiom;
	}

	public void setIdiom(IdionsEnum idiom) {
		this.idiom = idiom;
	}

}
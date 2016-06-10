package org.aaf.dto;

import java.io.Serializable;

import org.json.JSONObject;

public class UserDTO implements Serializable{

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

	public UserDTO() {
	}

	public UserDTO(JSONObject json) {
		if (json != null) {
			this.id = !json.isNull("id") ? json.getLong("id") : null;
			this.name = !json.isNull("id") ? json.getString("name") : null;
			this.cod = !json.isNull("id") ? json.getString("cod") : null;
			this.email = !json.isNull("id") ? json.getString("email") : null;
			this.team = new TeamDTO(!json.isNull("team") ?json.getJSONObject("team"):null);
			this.login = !json.isNull("id") ? json.getString("login") : null;
			this.senha = !json.isNull("id") ? json.getString("senha") : null;
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

}
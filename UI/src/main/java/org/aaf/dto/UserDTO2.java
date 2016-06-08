package org.aaf.dto;

import org.aaf.webInterface.model.Team;
import org.aaf.webInterface.model.UserFM;
import org.json.JSONObject;
import org.junit.experimental.theories.Theories;

public class UserDTO2 {

	private Long id;

	private String name;

	private String cod;

	private String email;

	private TeamDTO2 team;

	private String login;

	private String senha;

	public UserDTO2() {
	}

	public UserDTO2(JSONObject json) {
		if (json != null) {
			this.id = !json.isNull("id") ? json.getLong("id") : null;
			this.name = !json.isNull("name") ? json.getString("name") : null;
			this.cod = !json.isNull("cod") ? json.getString("cod") : null;
			this.email = !json.isNull("email") ? json.getString("email") : null;
			this.login = !json.isNull("login") ? json.getString("login") : null;
			this.senha = !json.isNull("senha") ? json.getString("senha") : null;
		}
	}

	public UserFM getUser(JSONObject json){
		//TODO - importante fazer resto do metodo
		JSONObject jsonObject = new JSONObject(json);
		
		UserFM object = new UserFM();
		object.setId(!json.isNull("id") ? json.getLong("id") : null);
		object.setName(!json.isNull("name") ? json.getString("name") : null);
		object.setCod(!json.isNull("cod") ? json.getString("cod") : null);
		object.setEmail(!json.isNull("email") ? json.getString("email") : null);
		object.setLogin(!json.isNull("login") ? json.getString("login") : null);
		object.setSenha(!json.isNull("senha") ? json.getString("senha") : null);
		
		return object;
	}
	
	public UserFM getUser(String jsonString){
		//TODO - importante fazer resto do metodo
		JSONObject json = new JSONObject(jsonString);
		
		UserFM object = new UserFM();
		object.setId(!json.isNull("id") ? json.getLong("id") : null);
		object.setName(!json.isNull("name") ? json.getString("name") : null);
		object.setCod(!json.isNull("cod") ? json.getString("cod") : null);
		object.setEmail(!json.isNull("email") ? json.getString("email") : null);
		object.setLogin(!json.isNull("login") ? json.getString("login") : null);
		object.setSenha(!json.isNull("senha") ? json.getString("senha") : null);
		
		return object;
	}

	public static UserFM getTeam(String json){
		//TODO - importante fazer resto do metodo
		JSONObject jsonObject = new JSONObject(json);
		UserFM object = new UserFM();
		object.setId(!jsonObject.isNull("id")?jsonObject.getLong("id"):null);
		
		return object;
	}

	
	public UserFM  getUserFm(){
		UserFM fm = new UserFM();
		fm.setCod(this.cod);
		fm.setEmail(email);
		fm.setId(id);
		fm.setLogin(login);
		fm.setName(name);
		fm.setSenha(senha);
		return fm;
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

	public TeamDTO2 getTeam() {
		return team;
	}

	public void setTeam(TeamDTO2 team) {
		this.team = team;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
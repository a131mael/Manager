package org.aaf.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.aaf.model.enuns.IdionsEnum;
 
@Entity
public class UserFM implements Serializable{
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "GENERATE_User", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "GENERATE_User", sequenceName = "User_pk_seq", allocationSize = 1)
	private Long id;
 
	@Column
	private String name;

	@Column
	private String cod;
	
	@Column
	private String email;

	@OneToOne
	private Team team;
	
	@Column
	private String login;
	
	@Column
	private String senha;
	
	@Column
	private LocalDate enteredInto;
	
	@Column
	private IdionsEnum idiom;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
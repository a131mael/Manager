package org.aaf.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Training {

	@Id
	@GeneratedValue(generator = "GENERATE_Training", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "GENERATE_Training", sequenceName = "Training_pk_seq", allocationSize = 1)
	private Long id;

	@Column
	private String nome;
	
	@OneToOne
	private Team team;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Player> players;
	
	@OneToMany
	private List<Staff> staffs;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

}
package org.aaf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Stadium {

	@Id
	@GeneratedValue(generator = "GENERATE_Stadium", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "GENERATE_Stadium", sequenceName = "Stadium_pk_seq", allocationSize = 1)
	private Long id;

	@Column
	private String nome;
	
	@OneToOne
	private Team team;
	
	@Column
	private int chair;
	
	@Column
	private int coveredChair;
	
	@Column
	private int bleacher;
	@Column
	private int coveredBleacher;
	@Column
	private int vip;
	@Column
	private int coveredVip;

	
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

	public int getChair() {
		return chair;
	}

	public void setChair(int chair) {
		this.chair = chair;
	}

	public int getCoveredChair() {
		return coveredChair;
	}

	public void setCoveredChair(int coveredChair) {
		this.coveredChair = coveredChair;
	}

	public int getBleacher() {
		return bleacher;
	}

	public void setBleacher(int bleacher) {
		this.bleacher = bleacher;
	}

	public int getCoveredBleacher() {
		return coveredBleacher;
	}

	public void setCoveredBleacher(int coveredBleacher) {
		this.coveredBleacher = coveredBleacher;
	}

	public int getVip() {
		return vip;
	}

	public void setVip(int vip) {
		this.vip = vip;
	}

	public int getCoveredVip() {
		return coveredVip;
	}

	public void setCoveredVip(int coveredVip) {
		this.coveredVip = coveredVip;
	}

}
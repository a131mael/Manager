package org.aaf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Player {

	@Id
	@GeneratedValue(generator = "GENERATE_Player", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "GENERATE_Player", sequenceName = "Player_pk_seq", allocationSize = 1)
	private Long id;
	@Column
	private String name;
	@Column
	private float height;
	@Column
	private float age;
	@Column
	private Float salary;
	@Column
	private Long value;
	
	@ManyToOne
	private Country country;

	@Column
	private String cod;

	@ManyToOne
	private Team team;
	
//	Fisicas
	private float agility;
	@Column
	private float velocity;
	@Column
	private float resistence;
	@Column
	private float impulse;
	@Column
	private float strength;
	
//	Tecnicas
	private float pass;
	@Column
	private float kick;
	@Column
	private float disarm;
	@Column
	private float technique;
	@Column
	private float mark;
	
	//Psico
	private float positioning;
	@Column
	private float decision;
	@Column
	private float aggressiveness;
	@Column
	private float goalkeaper;
	@Column
	private float workindex;
	
	private String ignore;
	
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

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public float getAgility() {
		return agility;
	}

	public void setAgility(float agility) {
		this.agility = agility;
	}

	public float getVelocity() {
		return velocity;
	}

	public void setVelocity(float velocity) {
		this.velocity = velocity;
	}

	public float getKick() {
		return kick;
	}

	public void setKick(float kick) {
		this.kick = kick;
	}

	public float getPass() {
		return pass;
	}

	public void setPass(float pass) {
		this.pass = pass;
	}

	public float getResistence() {
		return resistence;
	}

	public void setResistence(float resistence) {
		this.resistence = resistence;
	}

	public float getImpulse() {
		return impulse;
	}

	public void setImpulse(float impulse) {
		this.impulse = impulse;
	}

	public float getStrength() {
		return strength;
	}

	public void setStrength(float strength) {
		this.strength = strength;
	}

	public float getDisarm() {
		return disarm;
	}

	public void setDisarm(float disarm) {
		this.disarm = disarm;
	}

	public float getTechnique() {
		return technique;
	}

	public void setTechnique(float technique) {
		this.technique = technique;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	public float getPositioning() {
		return positioning;
	}

	public void setPositioning(float positioning) {
		this.positioning = positioning;
	}

	public float getDecision() {
		return decision;
	}

	public void setDecision(float decision) {
		this.decision = decision;
	}

	public float getAggressiveness() {
		return aggressiveness;
	}

	public void setAggressiveness(float aggressiveness) {
		this.aggressiveness = aggressiveness;
	}


	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public String getIgnore() {
		return ignore;
	}

	public void setIgnore(String ignore) {
		this.ignore = ignore;
	}

	public float getGoalkeaper() {
		return goalkeaper;
	}

	public void setGoalkeaper(float goalkeaper) {
		this.goalkeaper = goalkeaper;
	}

	public float getWorkindex() {
		return workindex;
	}

	public void setWorkindex(float workindex) {
		this.workindex = workindex;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

}
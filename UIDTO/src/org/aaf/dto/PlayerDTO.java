package org.aaf.dto;

import java.io.Serializable;

public class PlayerDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;
	private float height;
	private float age;
	private Float salary;
	private Long value;
	
	private CountryDTO country;

	private String cod;

	private TeamDTO team;
	
//	Fisicas
	private float agility;
	private float velocity;
	private float resistence;
	private float impulse;
	private float strength;
	
//	Tecnicas
	private float pass;
	private float kick;
	private float disarm;
	private float technique;
	private float mark;
	
	//Psico
	private float positioning;
	private float decision;
	private float aggressiveness;
	private float goalKeaper;
	private float workIndex;
	
	private String ignore;
	
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
       
        final PlayerDTO other = (PlayerDTO) obj;
        if (this.getId() != other.getId() && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	
	public PlayerDTO() {}

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

	public TeamDTO getTeam() {
		return team;
	}

	public void setTeam(TeamDTO team) {
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

	public float getGoalKeaper() {
		return goalKeaper;
	}

	public void setGoalKeaper(float goalKeaper) {
		this.goalKeaper = goalKeaper;
	}

	public float getWorkIndex() {
		return workIndex;
	}

	public void setWorkIndex(float workIndex) {
		this.workIndex = workIndex;
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

	public CountryDTO getCountry() {
		return country;
	}

	public void setCountry(CountryDTO country) {
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

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

}
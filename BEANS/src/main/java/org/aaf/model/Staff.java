package org.aaf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.aaf.model.enuns.RateEnum;
import org.aaf.model.enuns.StaffEnum;

@Entity
public class Staff {

	@Id
	@GeneratedValue(generator = "GENERATE_Staff", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "GENERATE_Staff", sequenceName = "Staff_pk_seq", allocationSize = 1)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private long cod;
	
	private StaffEnum type;
	
	private RateEnum rate;

	public StaffEnum getType() {
		return type;
	}

	public void setType(StaffEnum type) {
		this.type = type;
	}

	public long getCod() {
		return cod;
	}

	public void setCod(long cod) {
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

	public RateEnum getRate() {
		return rate;
	}

	public void setRate(RateEnum rate) {
		this.rate = rate;
	}

	
}
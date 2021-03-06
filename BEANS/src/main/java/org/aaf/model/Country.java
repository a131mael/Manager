package org.aaf.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.aaf.model.enuns.IdionsEnum;
 
@Entity
public class Country implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "GENERATE_Country", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "GENERATE_Country", sequenceName = "Country_pk_seq", allocationSize = 1)
	private Long id;
 
	@Column
    private String name;
 
    @Column
    private String cod;
    
    @Column
    private int session;
    
    @Column
    private int week;
    
    @Column
    private int GMT;
    
    @Column
	private LocalDateTime dateTimeStart; 
    
    @Column
    private IdionsEnum idiom; 

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

	public int getSession() {
		return session;
	}

	public void setSession(int session) {
		this.session = session;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public LocalDateTime getDateTimeStart() {
		return dateTimeStart;
	}

	public void setDateTimeStart(LocalDateTime dateTimeStart) {
		this.dateTimeStart = dateTimeStart;
	}

	public IdionsEnum getIdiom() {
		return idiom;
	}

	public void setIdiom(IdionsEnum idiom) {
		this.idiom = idiom;
	}

	public int getGMT() {
		return GMT;
	}

	public void setGMT(int gMT) {
		GMT = gMT;
	}

	
}
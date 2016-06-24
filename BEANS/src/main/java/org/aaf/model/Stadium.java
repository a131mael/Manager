package org.aaf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Stadium {

	@Id
	@GeneratedValue(generator = "GENERATE_Stadium", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "GENERATE_Stadium", sequenceName = "Stadium_pk_seq", allocationSize = 1)
	private Long id;

	private String nome;

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

}
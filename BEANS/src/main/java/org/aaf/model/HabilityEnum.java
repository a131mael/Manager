package org.aaf.model;

import java.util.ArrayList;

public enum HabilityEnum {

	VALUE("Valor"),
	
	SALARY("Salário"),
	
	AGE("Idade"),
	
	AGILITY("Agilidade"),
	
	VELOCITY("Velocidade"),
	
	RESISTENCE("Resistência"),
	
	IMPULSE("Impulso"),
	
	STRENGTH("Força"),
	
	PASS("Passe"),
	
	KICK("Finalização"),
	
	DISARM("Desarme"),
	
	TECHNIQUE("Técnica"),
	
	MARK("Marcação"),
	
	POSITIONING("Posicionamento"),
	
	DECISION("Decisão"),
	
	AGGRESSIVENESS("Agressividade"),
	
	GOALKEAPER("Goleiro"),
	
	WORKINDEX("Indice de trabalho");
	
	
	
	private String label;
    
	
	HabilityEnum(String name){
		this.label = name;
	}
	
    public String getLabel() {
        return label;
    }
}

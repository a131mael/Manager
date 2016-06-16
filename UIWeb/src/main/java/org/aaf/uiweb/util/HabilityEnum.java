package org.aaf.uiweb.util;

import java.util.ArrayList;

import javax.faces.model.SelectItem;

public enum HabilityEnum {

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
	
	//TODO internacionalizar
	public static ArrayList<SelectItem> getEnuns() {

        ArrayList<SelectItem> items = new ArrayList<SelectItem>();
        for (HabilityEnum g : HabilityEnum.values()) {
            items.add(new SelectItem(g, g.getLabel()));
        }

        return items;
    }

    public String getLabel() {
        return label;
    }
}

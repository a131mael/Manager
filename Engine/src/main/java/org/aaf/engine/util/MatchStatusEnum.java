package org.aaf.engine.util;

import java.util.ArrayList;

import javax.faces.model.SelectItem;

public enum MatchStatusEnum {

	PLAYED("Played"),
	
	PLAYING("PLAYING"),
	
	NOT_PLAYED("Not played");
	
	private String label;
    
	
	MatchStatusEnum(String name){
		this.label = name;
	}
	
	//TODO internacionalizar
	public static ArrayList<SelectItem> getEnuns() {

        ArrayList<SelectItem> items = new ArrayList<SelectItem>();
        for (MatchStatusEnum g : MatchStatusEnum.values()) {
            items.add(new SelectItem(g, g.getLabel()));
        }

        return items;
    }

    public String getLabel() {
        return label;
    }
}

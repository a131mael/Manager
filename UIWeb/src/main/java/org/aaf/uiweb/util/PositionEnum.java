package org.aaf.uiweb.util;

import java.util.ArrayList;

import javax.faces.model.SelectItem;

public enum PositionEnum {

	DEF("Def"),
	MID("Mid"),
	ATT("Att");
	
	private String label;
    
	
	PositionEnum(String name){
		this.label = name;
	}
	
	//TODO internacionalizar
	public static ArrayList<SelectItem> getEnuns() {

        ArrayList<SelectItem> items = new ArrayList<SelectItem>();
        for (PositionEnum g : PositionEnum.values()) {
            items.add(new SelectItem(g, g.getLabel()));
        }

        return items;
    }

    public String getLabel() {
        return label;
    }
}

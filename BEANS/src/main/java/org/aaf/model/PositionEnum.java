package org.aaf.model;

import java.util.ArrayList;

public enum PositionEnum {

	DEF("Def"),
	MID("Mid"),
	ATT("Att");
	
	private String label;
    
	
	PositionEnum(String name){
		this.label = name;
	}
	
    public String getLabel() {
        return label;
    }
}

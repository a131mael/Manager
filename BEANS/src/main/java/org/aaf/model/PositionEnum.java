package org.aaf.model;

public enum PositionEnum {

	GK("GK"),
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

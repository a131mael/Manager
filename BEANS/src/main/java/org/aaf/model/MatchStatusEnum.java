package org.aaf.model;

public enum MatchStatusEnum {

	PLAYED("Played"),
	
	PLAYING("PLAYING"),
	
	NOT_PLAYED("Not played");
	
	private String label;
    
	
	MatchStatusEnum(String name){
		this.label = name;
	}
	
    public String getLabel() {
        return label;
    }
}

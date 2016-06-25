package org.aaf.model;

import java.util.ArrayList;

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

package org.aaf.model.enuns;

public enum FanMoodEnum {

	RADIANT("Radiante"),
	HAPPY("Feliz"),
	SATISFIED("Satisfeitos"),
	SAD("Triste");
	
	private String label;
	
	FanMoodEnum(String name){
		this.label = name;
	}
	
    public String getLabel() {
        return label;
    }
}

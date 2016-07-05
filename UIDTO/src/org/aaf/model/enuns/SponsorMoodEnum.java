package org.aaf.model.enuns;

public enum SponsorMoodEnum {

	RADIANT("Radiante"),
	HAPPY("Feliz"),
	SATISFIED("Satisfeitos"),
	SAD("Triste");
	
	private String label;
	
	SponsorMoodEnum(String name){
		this.label = name;
	}
	
    public String getLabel() {
        return label;
    }
}

package org.aaf.model.enuns;

public enum RateEnum {

	SUPERNATURAL("Treinador", 20),
	AMAZING("Incrivel", 19),
	EXCELENTE("Excelente", 18),
	FORMIDABLE("Formidavel", 17),
	VERY_GOOD("Muito bom", 16),
	GOOD("Bom", 15),
	MEDIAN("Mediano", 15);
	
	private String label;
	private int value;
	
	RateEnum(String name, int value){
		this.label = name;
	}
	
    public String getLabel() {
        return label;
    }

	public int getValue() {
		return value;
	}
}

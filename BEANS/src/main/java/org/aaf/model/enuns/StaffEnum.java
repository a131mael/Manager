package org.aaf.model.enuns;

public enum StaffEnum {

	COACH("Treinador"),
	ASSISTANT_COACH("Treinador adjunto"),
	PERSONAL_TRAINER("Preparador fisico"),
	DOCTOR("Médico"),
	COACH_GOALKEEPERS("Treinador de goleiros"),
	TECHNICAL_TRAINER("Treinador de técnico"),
	PSYCHOLOGIST("Psicologista");
	
	private String label;
	
	StaffEnum(String name){
		this.label = name;
	}
	
    public String getLabel() {
        return label;
    }
}

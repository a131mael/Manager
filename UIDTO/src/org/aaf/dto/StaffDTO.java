package org.aaf.dto;

import org.aaf.model.enuns.RateEnum;
import org.aaf.model.enuns.StaffEnum;

public class StaffDTO {

	private Long id;
	
	private String name;
	
	private long cod;
	
	private StaffEnum type;
	
	private RateEnum rate;	
	@Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
       
        final StaffDTO other = (StaffDTO) obj;
        if (this.getId() != other.getId() && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StaffEnum getType() {
		return type;
	}

	public void setType(StaffEnum type) {
		this.type = type;
	}

	public RateEnum getRate() {
		return rate;
	}

	public void setRate(RateEnum rate) {
		this.rate = rate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCod() {
		return cod;
	}

	public void setCod(long cod) {
		this.cod = cod;
	}

}
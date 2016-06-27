package org.aaf.dto;

public class StadiumDTO {


	private Long id;

	private String name;
	
	private String cod;

	private int chair;
	private int coveredChair;
	
	private int bleacher;
	private int coveredBleacher;

	private int vip;
	private int coveredVip;
	
	private TeamDTO team;
	
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
       
        final StadiumDTO other = (StadiumDTO) obj;
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

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public int getChair() {
		return chair;
	}

	public void setChair(int chair) {
		this.chair = chair;
	}

	public int getBleacher() {
		return bleacher;
	}

	public void setBleacher(int bleacher) {
		this.bleacher = bleacher;
	}

	public int getCoveredChair() {
		return coveredChair;
	}

	public void setCoveredChair(int coveredChair) {
		this.coveredChair = coveredChair;
	}

	public int getCoveredBleacher() {
		return coveredBleacher;
	}

	public void setCoveredBleacher(int coveredBleacher) {
		this.coveredBleacher = coveredBleacher;
	}

	public int getVip() {
		return vip;
	}

	public void setVip(int vip) {
		this.vip = vip;
	}

	public int getCoveredVip() {
		return coveredVip;
	}

	public void setCoveredVip(int coveredVip) {
		this.coveredVip = coveredVip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TeamDTO getTeam() {
		return team;
	}

	public void setTeam(TeamDTO team) {
		this.team = team;
	}

}
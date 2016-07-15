package org.aaf.dto;

import java.util.List;

public class TrainningDTO {


	private Long id;

	private String nome;
	
	private TeamDTO team;
	
	private List<PlayerDTO> players;
	
	private List<StaffDTO> staffs;
	
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
       
        final TrainningDTO other = (TrainningDTO) obj;
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

	public TeamDTO getTeam() {
		return team;
	}

	public void setTeam(TeamDTO team) {
		this.team = team;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<PlayerDTO> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerDTO> players) {
		this.players = players;
	}

	public List<StaffDTO> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<StaffDTO> staffs) {
		this.staffs = staffs;
	}

}
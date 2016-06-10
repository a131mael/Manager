/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aaf.uiweb.util;

import java.util.ArrayList;
import java.util.List;

import org.aaf.dto.PlayerDTO;
import org.json.JSONArray;
import org.json.JSONObject;

public class Convertes {

	public static List<PlayerDTO> getPlayers(JSONArray jsonArray){
		List<PlayerDTO> plyers = new ArrayList<PlayerDTO>();
		for(int i=0;i<jsonArray.length();i++){
			plyers.add(getPlyer(jsonArray.getJSONObject(i)));
		}
		
		return plyers;
	}
	
	public static PlayerDTO getPlyer(JSONObject json){
		PlayerDTO playerDTO = new PlayerDTO();
		if (json != null) {
			playerDTO.setId(!json.isNull("id") ? json.getLong("id") : null);
			playerDTO.setName(!json.isNull("name") ? json.getString("name") : null);
			playerDTO.setCod(!json.isNull("cod") ? json.getString("cod") : null);
			playerDTO.setAge(!json.isNull("age") ? json.getInt("age") : null);
			playerDTO.setAggressiveness(!json.isNull("aggressiveness") ? json.getInt("aggressiveness") : null);
			playerDTO.setAgility(!json.isNull("agility") ? json.getInt("agility") : null);
			playerDTO.setCod(!json.isNull("cod") ? json.getString("cod") : null);
			//playerDTO.setCountry(country !json.isNull("aggressiveness") ? json.getInt("aggressiveness") : null); //TODO - verificar
			playerDTO.setDecision(!json.isNull("decision") ? json.getInt("decision") : null);
			playerDTO.setDisarm( !json.isNull("disarm") ? json.getInt("disarm") : null);
			playerDTO.setGoalKeaper( !json.isNull("goalKeaper") ? json.getInt("goalKeaper") : null);
			playerDTO.setHeight( !json.isNull("height") ? json.getInt("height") : null);
			playerDTO.setHeight( !json.isNull("height") ? json.getInt("height") : null);
			//playerDTO.setIgnore( !json.isNull("ignore") ? json.getInt("ignore") : null);
			playerDTO.setImpulse( !json.isNull("impulse") ? json.getInt("impulse") : null);
			playerDTO.setKick( !json.isNull("kick") ? json.getInt("kick") : null);
			playerDTO.setMark( !json.isNull("mark") ? json.getInt("mark") : null);
			playerDTO.setPass( !json.isNull("pass") ? json.getInt("pass") : null);
			playerDTO.setPositioning( !json.isNull("positioning") ? json.getInt("positioning") : null);
			playerDTO.setResistence( !json.isNull("resistence") ? json.getInt("resistence") : null);
			playerDTO.setSalary( !json.isNull("salary") ? (Float)json.get("salary") : null);
			playerDTO.setStrength( !json.isNull("strength") ? json.getInt("strength") : null);
		//	playerDTO.setTeam( !json.isNull("team") ? json.getInt("team") : null);
			playerDTO.setTechnique( !json.isNull("technique") ? json.getInt("technique") : null);
			playerDTO.setVelocity( !json.isNull("velocity") ? json.getInt("velocity") : null);
			playerDTO.setWorkIndex( !json.isNull("workIndex") ? json.getInt("workIndex") : null);
		}
		
		return playerDTO;
		
	}

}

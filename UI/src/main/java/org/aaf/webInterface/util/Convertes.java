/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aaf.webInterface.util;

import java.util.ArrayList;
import java.util.List;

import org.aaf.dto.CountryDTO;
import org.aaf.dto.LeagueDTO;
import org.aaf.dto.TeamDTO;
import org.aaf.dto.UserDTO;
import org.aaf.webInterface.model.Country;
import org.aaf.webInterface.model.League;
import org.aaf.webInterface.model.Team;
import org.aaf.webInterface.model.UserFM;

public class Convertes {

	public static UserFM getUser(UserDTO dto) {
		if (dto != null) {
			UserFM userFM = new UserFM();
			userFM.setCod(dto.getCod());
			userFM.setEmail(dto.getEmail());
			userFM.setId(dto.getId());
			userFM.setLogin(dto.getLogin());
			userFM.setName(dto.getName());
			userFM.setSenha(dto.getSenha());
			userFM.setTeam(getTeam(dto.getTeam()));
			return userFM;

		} else {
			return null;
		}
	}

	public static Country getCountry(CountryDTO dto) {
		if (dto != null) {
			Country country = new Country();
			country.setCod(dto.getCod());
			country.setId(dto.getId());
			country.setName(dto.getName());
			country.setWeek(dto.getWeek());
			country.setSession(dto.getSession());

			return country;
		} else {
			return null;
		}
	}
	
	public static CountryDTO getCountryDTO(Country country) {
		if (country != null) {
			CountryDTO countryDTO = new CountryDTO();
			countryDTO.setCod(country.getCod());
			countryDTO.setId(country.getId());
			countryDTO.setName(country.getName());
			countryDTO.setWeek(country.getWeek());
			countryDTO.setSession(country.getSession());

			return countryDTO;
		} else {
			return null;
		}
	}
	

	public static List<CountryDTO> getCountries(List<Country> countries){
		List<CountryDTO> countriesDTO = new ArrayList<>();
		
		for(Country country : countries){
			countriesDTO.add(getCountryDTO(country));
		}
		return countriesDTO;
	}
	
	public static League getLeague(LeagueDTO dto) {
		if (dto != null) {
			League league = new League();
			league.setCod(dto.getCod());
			league.setId(dto.getId());
			league.setCountry(getCountry(dto.getCountry()));
			league.setLevel(dto.getLevel());
			league.setName(dto.getName());
			// league.setTeans(teans); //TODO - verificar 04/06/16
			return league;
		} else {
			return null;
		}
	}

	public static Team getTeam(TeamDTO dto) {
		if (dto != null) {
			Team obj = new Team();
			obj.setCashBox(dto.getCashBox());
			obj.setCod(dto.getCod());
			obj.setId(dto.getId());
			obj.setLeague(getLeague(dto.getLeague()));
			obj.setName(dto.getName());
			obj.setOwner(getUser(dto.getOwner()));
			return obj;
		} else {
			return null;
		}

	}

}

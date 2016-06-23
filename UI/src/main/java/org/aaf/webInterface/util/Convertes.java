/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aaf.webInterface.util;

import java.util.ArrayList;
import java.util.List;

import org.aaf.dto.CountryDTO;
import org.aaf.dto.LeagueDTO;
import org.aaf.dto.LineUpDTO;
import org.aaf.dto.MatchDTO;
import org.aaf.dto.PlayerDTO;
import org.aaf.dto.TeamDTO;
import org.aaf.dto.TeamLeagueDTO;
import org.aaf.dto.UserDTO;
import org.aaf.webInterface.model.Country;
import org.aaf.webInterface.model.League;
import org.aaf.webInterface.model.LineUp;
import org.aaf.webInterface.model.Match;
import org.aaf.webInterface.model.Player;
import org.aaf.webInterface.model.Team;
import org.aaf.webInterface.model.TeamLeague;
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

	public static UserDTO getUser(UserFM user) {
		if (user != null) {
			UserDTO userDTO = new UserDTO();
			userDTO.setCod(user.getCod());
			userDTO.setEmail(user.getEmail());
			userDTO.setId(user.getId());
			userDTO.setLogin(user.getLogin());
			userDTO.setName(user.getName());
			userDTO.setSenha(user.getSenha());
			userDTO.setTeam(getTeam(user.getTeam()));
			return userDTO;

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

	public static CountryDTO getCountry(Country obj) {
		if (obj != null) {
			CountryDTO country = new CountryDTO();
			country.setCod(obj.getCod());
			country.setId(obj.getId());
			country.setName(obj.getName());
			country.setWeek(obj.getWeek());
			country.setSession(obj.getSession());

			return country;
		} else {
			return null;
		}
	}
	
	public static List<PlayerDTO> getPlayers(List<Player> players){
		List<PlayerDTO> playerDTOs = new ArrayList<>();
		if(players != null){
			for(Player player :players){
				playerDTOs.add(getPlayer(player));
			}
		}
		return playerDTOs;
	}

	public static PlayerDTO getPlayer(Player obj) {
		if (obj != null) {
			PlayerDTO playerDTO = new PlayerDTO();

			playerDTO.setId(obj.getId());
			playerDTO.setName(obj.getName());
			playerDTO.setCod(obj.getCod());
			playerDTO.setAge(obj.getAge());
			playerDTO.setAggressiveness(obj.getAggressiveness());
			playerDTO.setAgility(obj.getAgility());
			playerDTO.setCod(obj.getCod());
			playerDTO.setCountry(getCountry(obj.getCountry()));
			// json.getInt("aggressiveness") : null); //TODO - verificar
			playerDTO.setDecision(obj.getDecision());
			playerDTO.setDisarm(obj.getDisarm());
			playerDTO.setGoalKeaper(obj.getGoalKeaper());
			playerDTO.setHeight(obj.getHeight());
			// playerDTO.setIgnore( !json.isNull("ignore") ?
			// json.getInt("ignore") : null);
			playerDTO.setImpulse(obj.getImpulse());
			playerDTO.setKick(obj.getKick());
			playerDTO.setMark(obj.getMark());
			playerDTO.setPass(obj.getPass());
			playerDTO.setPositioning(obj.getPositioning());
			playerDTO.setResistence(obj.getResistence());
			playerDTO.setSalary(obj.getSalary());
			playerDTO.setStrength(obj.getStrength());
			// playerDTO.setTeam( !json.isNull("team") ? json.getInt("team") :
			// null);
			playerDTO.setTechnique(obj.getTechnique());
			playerDTO.setVelocity(obj.getVelocity());
			playerDTO.setWorkIndex(obj.getWorkIndex());
			playerDTO.setValue(obj.getValue());;

			return playerDTO;

		} else {
			return null;
		}
	}
	
	public static Player getPlayer(PlayerDTO obj) {
		if (obj != null) {
			Player playerDTO = new Player();

			playerDTO.setId(obj.getId());
			playerDTO.setName(obj.getName());
			playerDTO.setCod(obj.getCod());
			playerDTO.setAge(obj.getAge());
			playerDTO.setAggressiveness(obj.getAggressiveness());
			playerDTO.setAgility(obj.getAgility());
			playerDTO.setCod(obj.getCod());
			playerDTO.setCountry(getCountry(obj.getCountry()));
			// json.getInt("aggressiveness") : null); //TODO - verificar
			playerDTO.setDecision(obj.getDecision());
			playerDTO.setDisarm(obj.getDisarm());
			playerDTO.setGoalKeaper(obj.getGoalKeaper());
			playerDTO.setHeight(obj.getHeight());
			// playerDTO.setIgnore( !json.isNull("ignore") ?
			// json.getInt("ignore") : null);
			playerDTO.setImpulse(obj.getImpulse());
			playerDTO.setKick(obj.getKick());
			playerDTO.setMark(obj.getMark());
			playerDTO.setPass(obj.getPass());
			playerDTO.setPositioning(obj.getPositioning());
			playerDTO.setResistence(obj.getResistence());
			playerDTO.setSalary(obj.getSalary());
			playerDTO.setStrength(obj.getStrength());
			// playerDTO.setTeam( !json.isNull("team") ? json.getInt("team") :
			// null);
			playerDTO.setTechnique(obj.getTechnique());
			playerDTO.setVelocity(obj.getVelocity());
			playerDTO.setWorkIndex(obj.getWorkIndex());
			playerDTO.setValue(obj.getValue());;

			return playerDTO;

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

	public static List<CountryDTO> getCountries(List<Country> countries) {
		List<CountryDTO> countriesDTO = new ArrayList<>();

		for (Country country : countries) {
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

	public static LeagueDTO getLeague(League obj) {
		if (obj != null) {
			LeagueDTO league = new LeagueDTO();
			league.setCod(obj.getCod());
			league.setId(obj.getId());
			league.setCountry(getCountry(obj.getCountry()));
			league.setLevel(obj.getLevel());
			league.setName(obj.getName());
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
		//	obj.setLeague(getLeague(dto.getLeague()));
			obj.setName(dto.getName());
			obj.setOwner(getUser(dto.getOwner()));
			return obj;
		} else {
			return null;
		}
	}

	public static TeamDTO getTeam(Team team) {
		if (team != null) {
			TeamDTO obj = new TeamDTO();
			obj.setCashBox(team.getCashBox() + 0.01);// TODO verificar
			obj.setCod(team.getCod());
			obj.setId(team.getId());
			//obj.setLeague(getLeague(team.getLeague()));
			obj.setName(team.getName());
			// obj.setOwner(getUser(dto.getOwner()));
			return obj;
		} else {
			return null;
		}
	}
	
	public static List<TeamDTO> getTeams(List<Team> teams){
		List<TeamDTO> teamsDTO = new ArrayList<>();
		if(teams != null){
			for(Team mt :teams){
				teamsDTO.add(getTeam(mt));
			}
		}
		return teamsDTO;
	}
	
	public static MatchDTO getMatch(Match param) {
		if (param != null) {
			MatchDTO obj = new MatchDTO();
			obj.setCod(param.getCod());
			obj.setDate(param.getDate());
			obj.setGolasHomeTeam(param.getGolasHomeTeam());
			obj.setGolasVisitTeam(param.getGolasVisitTeam());
			obj.setHomeTeam(getTeam(param.getHomeTeam()));
			obj.setId(param.getId());
			obj.setRound(param.getRound());
			obj.setSession(param.getSession());
			obj.setVisitTeam(getTeam(param.getVisitTeam()));
			obj.setWeek(param.getWeek());
			return obj;
		} else {
			return null;
		}
	}
	
	public static Match getMatch(MatchDTO param) {
		if (param != null) {
			Match obj = new Match();
			obj.setCod(param.getCod());
			obj.setDate(param.getDate());
			obj.setGolasHomeTeam(param.getGolasHomeTeam());
			obj.setGolasVisitTeam(param.getGolasVisitTeam());
			obj.setHomeTeam(getTeam(param.getHomeTeam()));
			obj.setId(param.getId());
			obj.setRound(param.getRound());
			obj.setSession(param.getSession());
			obj.setVisitTeam(getTeam(param.getVisitTeam()));
			obj.setWeek(param.getWeek());
			return obj;
		} else {
			return null;
		}
	}
	
	public static List<MatchDTO> getMatches(List<Match> matches){
		List<MatchDTO> matchesDTO = new ArrayList<>();
		if(matches != null){
			for(Match mt :matches){
				matchesDTO.add(getMatch(mt));
			}
		}
		return matchesDTO;
	}

	public static TeamLeagueDTO getTeamLeague(TeamLeague param) {
		if (param != null) {
			TeamLeagueDTO obj = new TeamLeagueDTO();
			obj.setCod(param.getCod());
			obj.setGoalsPro(param.getGoalsPro());
			obj.setGoasAgainst(param.getGoasAgainst());
			obj.setId(param.getId());
			obj.setLeague(getLeague(param.getLeague()));
			obj.setLosses(param.getLosses());
			obj.setMain(param.isMain());
			obj.setMatches(param.getMatches());
			obj.setName(param.getName());
			obj.setPoints(param.getPoints());
			obj.setTeam(getTeam(param.getTeam()));
			obj.setVictories(param.getVictories());
			return obj;
		} else {
			return null;
		}
	}
	
	public static List<TeamLeagueDTO> getTeamLeagues(List<TeamLeague> leagues){
		List<TeamLeagueDTO> teamLeagueDTOs = new ArrayList<>();
		if(leagues != null){
			for(TeamLeague mt :leagues){
				teamLeagueDTOs.add(getTeamLeague(mt));
			}
		}
		return teamLeagueDTOs;
	}

	public static LineUp getLineUp(LineUpDTO dto) {
		if (dto != null) {
			LineUp obj = new LineUp();

			obj.setId(dto.getId());
			obj.setMatch(getMatch(dto.getMatch()));
			obj.setTeam(getTeam(dto.getTeamDTO()));
			
			obj.setOrderP1(PositionEnum.values()[dto.getOrderPlayer1()] );
			obj.setOrderP2(PositionEnum.values()[dto.getOrderPlayer2()] );
			obj.setOrderP3(PositionEnum.values()[dto.getOrderPlayer3()] );
			obj.setOrderP4(PositionEnum.values()[dto.getOrderPlayer4()] );
			obj.setOrderP5(PositionEnum.values()[dto.getOrderPlayer5()] );
			obj.setOrderP6(PositionEnum.values()[dto.getOrderPlayer6()] );
			obj.setOrderP7(PositionEnum.values()[dto.getOrderPlayer7()] );
			obj.setOrderP8(PositionEnum.values()[dto.getOrderPlayer8()] );
			obj.setOrderP9(PositionEnum.values()[dto.getOrderPlayer9()] );
			obj.setOrderP10(PositionEnum.values()[dto.getOrderPlayer10()] );
			obj.setOrderP11(PositionEnum.values()[dto.getOrderPlayer11()] );
			obj.setOrderP12(PositionEnum.values()[dto.getOrderPlayer12()] );
			obj.setOrderP13(PositionEnum.values()[dto.getOrderPlayer13()] );
			obj.setOrderP14(PositionEnum.values()[dto.getOrderPlayer14()] );
			obj.setOrderP15(PositionEnum.values()[dto.getOrderPlayer15()] );
			obj.setOrderP16(PositionEnum.values()[dto.getOrderPlayer16()] );
			
			obj.setPosition1(getPlayer(dto.getPlayer1()));
			obj.setPosition2(getPlayer(dto.getPlayer2()));
			obj.setPosition3(getPlayer(dto.getPlayer3()));
			obj.setPosition4(getPlayer(dto.getPlayer4()));
			obj.setPosition5(getPlayer(dto.getPlayer5()));
			obj.setPosition6(getPlayer(dto.getPlayer6()));
			obj.setPosition7(getPlayer(dto.getPlayer7()));
			obj.setPosition8(getPlayer(dto.getPlayer8()));
			obj.setPosition9(getPlayer(dto.getPlayer9()));
			obj.setPosition10(getPlayer(dto.getPlayer10()));
			obj.setPosition11(getPlayer(dto.getPlayer11()));
			obj.setPosition12(getPlayer(dto.getPlayer12()));
			obj.setPosition13(getPlayer(dto.getPlayer13()));
			obj.setPosition14(getPlayer(dto.getPlayer14()));
			obj.setPosition15(getPlayer(dto.getPlayer15()));
			obj.setPosition15(getPlayer(dto.getPlayer13()));
			
			return obj;
		}
		return null;
	}
}

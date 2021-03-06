package org.aaf.uiweb.util;

public class EndPoints {

	private static StringBuilder urlBase = new StringBuilder("http://localhost");
	//private static StringBuilder urlBase = new StringBuilder("http://ec2-52-67-36-232.sa-east-1.compute.amazonaws.com");
	
 	
	public static final String AVALIABLE_TEAM = new StringBuilder(urlBase).append("/UI/rest/teams/avaliable/").toString();
	public static final String REGISTER_TEAM = new StringBuilder(urlBase).append("/UI/rest/teams/").toString();
	public static final String SAVE_LINEUP = new StringBuilder(urlBase).append("/UI/rest/matches/lineup/").toString();
	public static final String LOGIN = new StringBuilder(urlBase).append("/UI/rest/login?login=").toString();
	public static final String GET_PLAYERS_USER = new StringBuilder(urlBase).append("/UI/rest/players/").toString();
	public static final String GET_PLAYER = new StringBuilder(urlBase).append("/UI/rest/players?idTeam=*1&id=*2").toString();
	public static final String PLAYER_DISMISS = new StringBuilder(urlBase).append("/UI/rest/players/dismiss/").toString();
	public static final String GET_COUNTRIES = new StringBuilder(urlBase).append("/UI/rest/countries").toString();
	public static final String GET_REGIONS_COUNTRY = new StringBuilder(urlBase).append("/UI/rest/countries/regions/").toString();
	public static final String GET_COUNTRY_USER = new StringBuilder(urlBase).append("/UI/rest/countries/user/").toString();
	public static final String GET_MATCHES = new StringBuilder(urlBase).append("/UI/rest/matches/").toString();//2path
	public static final String GET_LAST_MATCHES = new StringBuilder(urlBase).append("/UI/rest/matches/lastMatches/").toString();//2path
	public static final String GET_LAST_MATCH = new StringBuilder(urlBase).append("/UI/rest/matches/lastMatch/").toString();//2path
	public static final String GET_LAST_MATCH_PENULT = new StringBuilder(urlBase).append("/UI/rest/matches/lastMatchPenult/").toString();//2path
	public static final String GET_MATCHE = new StringBuilder(urlBase).append("/UI/rest/matches/").toString();//1path
	public static final String GET_TEAMS = new StringBuilder(urlBase).append("/UI/rest/leagues/").toString();
	public static final String GET_MAIN_LEAGUE_USER = new StringBuilder(urlBase).append("/UI/rest/leagues/user/").toString();
	public static final String GET_TEAMLEAGUE_LEAGUE = new StringBuilder(urlBase).append("/UI/rest/teamLeagues/league/").toString();
	public static final String GET_LINEUP = new StringBuilder(urlBase).append("/UI/rest/matches/lineup/").toString();
	public static final String GET_STADIUM_TEAM = new StringBuilder(urlBase).append("/UI/rest/teams/stadium/teamID/").toString();
	public static final String GET_SALARY_TEAM = new StringBuilder(urlBase).append("/UI/rest/teams/sumSalaryPlayers/").toString(); //TODO REMOVER
	public static final String GET_ECONOMY = new StringBuilder(urlBase).append("/UI/rest/Economies/").toString();
	public static final String GET_TRAINNING = new StringBuilder(urlBase).append("/UI/rest/trainnings/").toString();
}

package org.aaf.uiweb.util;

public class EndPoints {

	//private static StringBuilder urlBase = new StringBuilder("http://localhost");
	private static StringBuilder urlBase = new StringBuilder("http://ec2-52-67-36-232.sa-east-1.compute.amazonaws.com");
	
 	
	public static final String AVALIABLE_TEAM = new StringBuilder(urlBase).append("/UI/rest/teams/avaliable/1").toString();
	public static final String REGISTER_TEAM = new StringBuilder(urlBase).append("/UI/rest/teams/").toString();
	public static final String LOGIN = new StringBuilder(urlBase).append("/UI/rest/login?login=").toString();
	public static final String GET_PLAYERS_USER = new StringBuilder(urlBase).append("/UI/rest/players/").toString();
	public static final String GET_PLAYER = new StringBuilder(urlBase).append("/UI/rest/players?idTeam=*1&id=*2").toString();
	public static final String PLAYER_DISMISS = new StringBuilder(urlBase).append("/UI/rest/players/dismiss/").toString();
	public static final String GET_COUNTRIES = new StringBuilder(urlBase).append("/UI/rest/countries").toString();
	public static final String GET_COUNTRY_USER = new StringBuilder(urlBase).append("/UI/rest/countries/user/").toString();
	public static final String GET_MATCHES = new StringBuilder(urlBase).append("/UI/rest/matches/").toString();
	public static final String GET_TEAMS = new StringBuilder(urlBase).append("/UI/rest/leagues/").toString();
	public static final String GET_MAIN_LEAGUE_USER = new StringBuilder(urlBase).append("/UI/rest/leagues/user/").toString();
	public static final String GET_TEAMLEAGUE_LEAGUE = new StringBuilder(urlBase).append("/UI/rest/teamLeagues/league/").toString();
	
}

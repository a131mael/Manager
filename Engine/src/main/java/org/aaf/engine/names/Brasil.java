package org.aaf.engine.names;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Brasil {
	
	public static final String nameCountry = "Brazil";

	// Name players
	public static final String namePlayer = "Abimael ;Gustavo ;Fernando ;Douglas ;Carlos ;Leandro ;Alberto ;Gugu ;Abibi ;Nando ;Magno ;";
	// Midle name players
	public static final String midleNamePlayer = "wellington ;Roberto ;Caxias ;Alvez ;Alvarenga ;Romero ;Sabino ;Augusto ;Facebocssom ;Araujo ;Cerse ;";
	
	// Midle name players
	public static final String lastNamePlayer = "Fidêncio ;Silva ;Souza ;Temer ;Rousseff ;Jucá ;Birk ;França ;Ferronatto ;Pessoa ;Palma ;";

	
	//Team names to bots
	public static final String nameTeamBot1 = "Flamengo ";
	public static final String nameTeamBot2 = "Vasco ";
	public static final String nameTeamBot3 = "Botafogo ";
	public static final String nameTeamBot4 = "Bragantino ";
	public static final String nameTeamBot5 = "São Paulo ";
	public static final String nameTeamBot6 = "Corinthias ";
	public static final String nameTeamBot7 = "Chapecoense ";
	public static final String nameTeamBot8 = "Figueirense ";
	public static final String nameTeamBot9 = "Avaí ";
	public static final String nameTeamBot10 = "Palmeiras ";
	public static final String nameTeamBot11 = "Internacional ";
	public static final String nameTeamBot12 = "Gremio ";
	public static final String nameTeamBot13 = "Santos ";
	public static final String nameTeamBot14 = "Ponte Preta ";
	public static final String nameTeamBot15 = "Santa Cruz ";
	public static final String nameTeamBot16 = "Atlético PR ";
	public static final String nameTeamBot17 = "Fluminense ";
	public static final String nameTeamBot18 = "Vitória ";
	public static final String nameTeamBot19 = "Curitiba ";
	public static final String nameTeamBot20 = "Cruzeiro ";
	public static final String nameTeamBot21 = "Atlético Mineiro ";
	public static final String nameTeamBot22 = "Sport ";
	public static final String nameTeamBot23 = "América RJ ";
	public static final String nameTeamBot24 = "Portuguesa ";
	public static final String nameTeamBot25 = "Atlético Goianiense ";
	public static final String nameTeamBot26 = "Bahia ";
	public static final String nameTeamBot27 = "Criciuma ";
	public static final String nameTeamBot28 = "Ceará ";
	public static final String nameTeamBot29 = "Londrina ";
	public static final String nameTeamBot30 = "Payssandu ";
	
	public static final String conectorTeam1 = "do ";
	public static final String conectorTeam2 = "de ";
	
	public static final String lastNameTeamBot1 = "Santa Catatina";
	public static final String lastNameTeamBot2 = "Rio Grande do Sul";
	public static final String lastNameTeamBot3 = "Paraná";
	public static final String lastNameTeamBot4 = "Bahia";
	public static final String lastNameTeamBot5 = "São Paulo";
	public static final String lastNameTeamBot6 = "Goiais";
	public static final String lastNameTeamBot7 = "Minas ";
	public static final String lastNameTeamBot8 = "Amazônia";
	public static final String lastNameTeamBot9 = "Tocantins";
	

	@SuppressWarnings("unchecked")
	public static List<String> getPlayerName(){
		Set<String> nomes = new HashSet<>();
		StringBuilder fullName = null;
		Random gerador = new Random();
		 
		int total = 0;
		while(total<256*22){
			String name = namePlayer.split(";")[gerador.nextInt(11)];
			String midleName = midleNamePlayer.split(";")[gerador.nextInt(11)];
			String lastName = lastNamePlayer.split(";")[gerador.nextInt(11)];
			fullName = new StringBuilder();
			fullName.append(name);
			fullName.append(midleName);
			fullName.append(lastName);
			nomes.add(fullName.toString());
			
			total = nomes.size();	
		}
		
		return ((List<String>) nomes);
	}
	

	public static List<String> getTeam(){
		List<String> nameTeams = new ArrayList<String>();
		nameTeams.add(nameTeamBot1 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot2 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot3 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot4 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot5 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot6 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot7 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot8 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot9 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot10 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot11 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot12 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot13 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot14 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot15 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot16 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot17 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot18 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot19 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot20 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot21 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot22 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot23 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot24 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot25 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot26 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot27 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot28 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot29 + conectorTeam1 +lastNameTeamBot1);
		nameTeams.add(nameTeamBot30 + conectorTeam1 +lastNameTeamBot1);
		
		nameTeams.add(nameTeamBot1 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot2 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot3 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot4 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot5 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot6 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot7 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot8 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot9 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot10 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot11 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot12 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot13 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot14 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot15 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot16 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot17 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot18 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot19 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot20 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot21 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot22 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot23 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot24 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot25 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot26 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot27 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot28 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot29 + conectorTeam1 +lastNameTeamBot2);
		nameTeams.add(nameTeamBot30 + conectorTeam1 +lastNameTeamBot2);

		
		
		nameTeams.add(nameTeamBot1 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot2 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot3 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot4 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot5 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot6 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot7 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot8 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot9 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot10 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot11 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot12 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot13 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot14 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot15 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot16 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot17 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot18 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot19 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot20 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot21 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot22 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot23 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot24 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot25 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot26 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot27 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot28 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot29 + conectorTeam1 +lastNameTeamBot3);
		nameTeams.add(nameTeamBot30 + conectorTeam1 +lastNameTeamBot3);


		nameTeams.add(nameTeamBot1 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot2 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot3 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot4 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot5 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot6 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot7 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot8 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot9 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot10 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot11 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot12 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot13 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot14 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot15 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot16 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot17 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot18 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot19 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot20 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot21 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot22 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot23 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot24 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot25 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot26 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot27 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot28 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot29 + conectorTeam1 +lastNameTeamBot4);
		nameTeams.add(nameTeamBot30 + conectorTeam1 +lastNameTeamBot4);

		
		nameTeams.add(nameTeamBot1 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot2 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot3 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot4 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot5 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot6 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot7 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot8 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot9 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot10 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot11 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot12 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot13 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot14 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot15 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot16 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot17 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot18 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot19 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot20 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot21 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot22 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot23 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot24 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot25 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot26 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot27 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot28 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot29 + conectorTeam1 +lastNameTeamBot5);
		nameTeams.add(nameTeamBot30 + conectorTeam1 +lastNameTeamBot5);


		nameTeams.add(nameTeamBot1 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot2 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot3 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot4 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot5 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot6 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot7 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot8 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot9 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot10 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot11 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot12 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot13 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot14 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot15 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot16 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot17 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot18 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot19 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot20 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot21 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot22 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot23 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot24 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot25 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot26 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot27 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot28 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot29 + conectorTeam1 +lastNameTeamBot6);
		nameTeams.add(nameTeamBot30 + conectorTeam1 +lastNameTeamBot6);

		
		nameTeams.add(nameTeamBot1 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot2 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot3 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot4 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot5 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot6 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot7 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot8 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot9 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot10 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot11 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot12 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot13 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot14 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot15 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot16 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot17 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot18 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot19 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot20 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot21 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot22 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot23 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot24 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot25 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot26 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot27 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot28 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot29 + conectorTeam1 +lastNameTeamBot7);
		nameTeams.add(nameTeamBot30 + conectorTeam1 +lastNameTeamBot7);


		nameTeams.add(nameTeamBot1 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot2 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot3 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot4 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot5 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot6 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot7 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot8 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot9 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot10 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot11 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot12 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot13 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot14 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot15 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot16 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot17 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot18 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot19 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot20 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot21 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot22 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot23 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot24 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot25 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot26 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot27 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot28 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot29 + conectorTeam1 +lastNameTeamBot8);
		nameTeams.add(nameTeamBot30 + conectorTeam1 +lastNameTeamBot8);

		nameTeams.add(nameTeamBot1 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot2 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot3 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot4 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot5 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot6 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot7 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot8 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot9 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot10 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot11 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot12 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot13 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot14 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot15 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot16 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot17 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot18 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot19 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot20 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot21 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot22 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot23 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot24 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot25 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot26 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot27 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot28 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot29 + conectorTeam1 +lastNameTeamBot9);
		nameTeams.add(nameTeamBot30 + conectorTeam1 +lastNameTeamBot9);

		
		return nameTeams;
	}

}

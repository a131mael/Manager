package org.aaf.engine.names;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.aaf.model.enuns.IdionsEnum;

public class Argentina implements CountryInterface {

	public static final String nameCountry = "Argentina";
	public static final String lamguage = "es_cas";
	private IdionsEnum idiom = IdionsEnum.ES_CAS;
	
	private  List<String> namesPlayeres;
	
	private static  List<String> namesTeams;

	// Name players
	public static final String namePlayer = "Hugo ;Daniel ;Alejandro ;Pablo ;Álvaro ;Adrian ;David ;Diego ;Mário ;Javier ;Marcos ;Nicolas ;Lucas ;;Carlos ;Miguel ;Jorge ;Martin ;Gonzalo ;Izan ;António ;Juan ;Leo ;Angel ;Victor ;Samuel ;Aitor ;Raul ;Hector ;Gabriel ;Guillermo ;Rodrigo ;Dario ;Jesus ;José ;Jaime ;Pedro ;Alberto ;Bruno ;Joel ;"; 
	
	// Midle name players
	public static final String lastNamePlayer = "Di María;Zanetti; Mascherano;Ayala;Messi;Simeone;Ruggeri; Armando Maradona; Maradona;Ortega;Batistuta;Romero;Aguero;Tevez;Pablo Sorin;Galego;Sebastian;Sebastian Veron;Heinze;Crespo;Kemps;Pontoni;Mendez;Passarella;Luque;";

	public static final String teamName = "All Boys ;Argentino Juniors ;Arsenal ;Atlético Rafaela ;Belgrano ;Boca Juniors ;Cólon ;Estudiantes ;Ginmasia ;Escrima ;Godoy Cruz ;Lanús ;Newell's Old Boys ; Olimpo ; Quilmes ;Racing ;River Plate ;Rosario Central ;San Lorenzo ;Tigre ;Vélez Sarsfield;";
	
	public static final String regions = "Buenos Aires;Catamarca;Chaco;Chubut;Córdoba;Corrientes;Entre Rios;Formosa;Jujuy;La Pampa;La Rioja;Mendoza;Misiones;Neuquén;Rio Negro;Salta;San Juan;San Luis;Santa Cruz;Santa Fé;Santiago del Estero;Terra do fogo; Tucumám;";
	
	// Team names to bots
	public static final String nameTeamBot1 = "All Boys ";
	public static final String nameTeamBot2 = "Argentino Juniors ";
	public static final String nameTeamBot3 = "Arsenal ";
	public static final String nameTeamBot4 = "Atlético Rafaela ";
	public static final String nameTeamBot5 = "Belgrano ";
	public static final String nameTeamBot6 = "Boca Juniors	 ";
	public static final String nameTeamBot7 = "Chapecoense ";
	public static final String nameTeamBot8 = "Figueirense ";
	public static final String nameTeamBot9 = "Ava� ";
	public static final String nameTeamBot10 = "Palmeiras ";
	public static final String nameTeamBot11 = "Internacional ";
	public static final String nameTeamBot12 = "Gremio ";
	public static final String nameTeamBot13 = "Santos ";
	public static final String nameTeamBot14 = "Ponte Preta ";
	public static final String nameTeamBot15 = "Santa Cruz ";
	public static final String nameTeamBot16 = "Atl�tico PR ";
	public static final String nameTeamBot17 = "Fluminense ";
	public static final String nameTeamBot18 = "Vit�ria ";
	public static final String nameTeamBot19 = "Curitiba ";
	public static final String nameTeamBot20 = "Cruzeiro ";
	public static final String nameTeamBot21 = "Atl�tico Mineiro ";
	public static final String nameTeamBot22 = "Sport ";
	public static final String nameTeamBot23 = "Am�rica RJ ";
	public static final String nameTeamBot24 = "Portuguesa ";
	public static final String nameTeamBot25 = "Atl�tico Goianiense ";
	public static final String nameTeamBot26 = "Bahia ";
	public static final String nameTeamBot27 = "Criciuma ";
	public static final String nameTeamBot28 = "Cear� ";
	public static final String nameTeamBot29 = "Londrina ";
	public static final String nameTeamBot30 = "Payssandu ";

	public static final String lastNameTeamBot1 = "Santa Catatina";
	public static final String lastNameTeamBot2 = "Rio Grande do Sul";
	public static final String lastNameTeamBot3 = "Paran�";
	public static final String lastNameTeamBot4 = "Bahia";
	public static final String lastNameTeamBot5 = "S�o Paulo";
	public static final String lastNameTeamBot6 = "Goiais";
	public static final String lastNameTeamBot7 = "Minas ";
	public static final String lastNameTeamBot8 = "Amaz�nia";
	public static final String lastNameTeamBot9 = "Tocantins";

	
	public static List<String> getPlayerName() {
		Set<String> nomes = new HashSet<>();
		StringBuilder fullName = null;
		Random gerador = new Random();

		int total = 0;
		while (total < 256 * 22) {

			String name = namePlayer.split(";")[gerador.nextInt(namePlayer.split(";").length - 1)];
			String lastName = lastNamePlayer.split(";")[gerador.nextInt(lastNamePlayer.split(";").length - 1)];
			fullName = new StringBuilder();
			fullName.append(name);
			fullName.append(lastName);
			nomes.add(fullName.toString());

			System.out.println(fullName);

			total = nomes.size();
			System.out.println("Total = " + total);
		}
		List<String> namesFinal = new ArrayList<>();
		namesFinal.addAll(nomes);
		return namesFinal;
	}
	
	public static List<String> getTeamsName() {
		Set<String> nomes = new HashSet<>();
		StringBuilder fullName = null;
		Random gerador = new Random();

		int total = 0;
		while (total < 256) {

			String name = teamName.split(";")[gerador.nextInt(teamName.split(";").length - 1)];
			String lastName = regions.split(";")[gerador.nextInt(regions.split(";").length - 1)];
			fullName = new StringBuilder();
			fullName.append(name);
			fullName.append(lastName);
			nomes.add(fullName.toString());

			System.out.println(fullName);

			total = nomes.size();
			System.out.println("Total = " + total);
		}
		List<String> namesFinal = new ArrayList<>();
		namesFinal.addAll(nomes);
		return namesFinal;
	}

	public static List<String> getTeam() {
		List<String> nameTeams = new ArrayList<String>();
		nameTeams.add(nameTeamBot1 +  lastNameTeamBot1);
		nameTeams.add(nameTeamBot2  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot3  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot4  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot5  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot6  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot7  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot8  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot9  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot10  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot11  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot12  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot13  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot14  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot15  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot16  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot17  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot18  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot19  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot20  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot21  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot22  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot23  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot24  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot25  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot26  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot27  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot28  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot29  + lastNameTeamBot1);
		nameTeams.add(nameTeamBot30  + lastNameTeamBot1);

		nameTeams.add(nameTeamBot1  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot2  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot3  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot4  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot5  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot6  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot7  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot8  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot9  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot10  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot11  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot12  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot13  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot14  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot15  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot16  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot17  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot18  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot19  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot20  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot21  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot22  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot23  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot24  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot25  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot26  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot27  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot28  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot29  + lastNameTeamBot2);
		nameTeams.add(nameTeamBot30  + lastNameTeamBot2);

		nameTeams.add(nameTeamBot1  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot2  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot3  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot4  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot5  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot6  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot7  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot8  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot9  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot10  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot11  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot12  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot13  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot14  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot15  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot16  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot17  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot18  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot19  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot20  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot21  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot22  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot23  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot24  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot25  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot26  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot27  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot28  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot29  + lastNameTeamBot3);
		nameTeams.add(nameTeamBot30  + lastNameTeamBot3);

		nameTeams.add(nameTeamBot1  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot2  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot3  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot4  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot5  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot6  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot7  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot8  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot9  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot10  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot11  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot12  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot13  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot14  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot15  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot16  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot17  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot18  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot19  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot20  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot21  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot22  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot23  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot24  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot25  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot26  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot27  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot28  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot29  + lastNameTeamBot4);
		nameTeams.add(nameTeamBot30  + lastNameTeamBot4);

		nameTeams.add(nameTeamBot1  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot2  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot3  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot4  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot5  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot6  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot7  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot8  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot9  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot10  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot11  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot12  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot13  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot14  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot15  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot16  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot17  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot18  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot19  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot20  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot21  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot22  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot23  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot24  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot25  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot26  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot27  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot28  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot29  + lastNameTeamBot5);
		nameTeams.add(nameTeamBot30  + lastNameTeamBot5);

		nameTeams.add(nameTeamBot1  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot2  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot3  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot4  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot5  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot6  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot7  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot8  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot9  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot10  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot11  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot12  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot13  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot14  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot15  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot16  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot17  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot18  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot19  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot20  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot21  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot22  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot23  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot24  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot25  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot26  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot27  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot28  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot29  + lastNameTeamBot6);
		nameTeams.add(nameTeamBot30  + lastNameTeamBot6);

		nameTeams.add(nameTeamBot1  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot2  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot3  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot4  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot5  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot6  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot7  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot8  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot9  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot10  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot11  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot12  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot13  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot14  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot15  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot16  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot17  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot18  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot19  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot20  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot21  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot22  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot23  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot24  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot25  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot26  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot27  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot28  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot29  + lastNameTeamBot7);
		nameTeams.add(nameTeamBot30  + lastNameTeamBot7);

		nameTeams.add(nameTeamBot1  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot2  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot3  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot4  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot5  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot6  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot7  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot8  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot9  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot10  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot11  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot12  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot13  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot14  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot15  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot16  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot17  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot18  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot19  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot20  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot21  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot22  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot23  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot24  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot25  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot26  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot27  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot28  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot29  + lastNameTeamBot8);
		nameTeams.add(nameTeamBot30  + lastNameTeamBot8);

		nameTeams.add(nameTeamBot1  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot2  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot3  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot4  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot5  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot6  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot7  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot8  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot9  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot10  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot11  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot12  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot13  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot14  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot15  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot16  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot17  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot18  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot19  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot20  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot21  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot22  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot23  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot24  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot25  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot26  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot27  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot28  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot29  + lastNameTeamBot9);
		nameTeams.add(nameTeamBot30  + lastNameTeamBot9);

		return nameTeams;
	}

	public List<String> getNamesPlayeres() {
		
		if(namesPlayeres == null || namesPlayeres.size()==0){
			namesPlayeres = getPlayerName();
		}
		return namesPlayeres;
	}

	public static List<String> getNamesTeans() {
		
		if(namesTeams == null || namesTeams.size()==0){
			namesTeams = getTeamsName();
		}
		return namesTeams;
	}

	@Override
	public String getNamecountry() {
		return Argentina.nameCountry;
	}

	@Override
	public String getLamguage() {
		return Argentina.lamguage;
	}

	@Override
	public String getNameplayer() {
		return Argentina.namePlayer;
	}

	@Override
	public String getLastnameplayer() {
		return Argentina.lastNamePlayer;
	}

	@Override
	public String getTeamname() {
		return Argentina.teamName;
	}

	@Override
	public String getRegions() {
		return Argentina.regions;
	}
	
	@Override
	public IdionsEnum getIdiom() {
		return idiom;
	}
}

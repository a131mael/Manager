package org.aaf.engine.names;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.aaf.model.enuns.IdionsEnum;

public class RegisterCountry {

	public static String nameCountry;
	public static String namePlayer;
	private List<String> namesPlayeres;
	private List<String> namesTeams;
	public static String teamName;
	public static String lastNamePlayer;
	public String regions;
	private IdionsEnum idiom;
	private int GMT ;
	
	public static Map<String, CountryInterface> countries = new HashMap<>();
	
	public void popule(CountryInterface country){
		nameCountry = country.getNamecountry();
		idiom = country.getIdiom();
		namePlayer = country.getNameplayer();
		lastNamePlayer = country.getLastnameplayer();
		teamName = country.getTeamname();
		regions = country.getRegions();
		setGMT(country.getGMT());
		
	}
	
	public RegisterCountry(){
	}
	
	public RegisterCountry(String name){
		switch (name) {
		case Brasil.nameCountry:
			popule(new Brasil());
			break;
			
		case Argentina.nameCountry:
			popule(new Argentina());
			break;

		default:
			break;
		}

	}

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
			System.out.println("Total Nomes = " + total);
		}
		List<String> namesFinal = new ArrayList<>();
		namesFinal.addAll(nomes);
		return namesFinal;
	}

	public List<String> getNamesPlayeres() {

		if (namesPlayeres == null || namesPlayeres.size() == 0) {
			namesPlayeres = getPlayerName();
		}
		return namesPlayeres;
	}

	public List<String> getTeamsName() {
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
			System.out.println("Total Times = " + total);
		}
		List<String> namesFinal = new ArrayList<>();
		namesFinal.addAll(nomes);
		return namesFinal;
	}

	public List<String> getNamesTeans() {

		if (namesTeams == null || namesTeams.size() == 0) {
			namesTeams = getTeamsName();
		}
		return namesTeams;
	}

	public IdionsEnum getIdiom() {
		return idiom;
	}

	public void setIdiom(IdionsEnum idiom) {
		this.idiom = idiom;
	}

	public int getGMT() {
		return GMT;
	}

	public void setGMT(int gMT) {
		GMT = gMT;
	}

}

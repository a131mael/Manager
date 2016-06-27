package org.aaf.engine.names;

import java.util.List;

import org.aaf.model.enuns.IdionsEnum;

public class Brasil implements CountryInterface{

	public static final String nameCountry = "Brazil";
	public static final String lamguage = "pt_br";

	private List<String> namesPlayeres;
	private static List<String> namesTeams;
	
	private IdionsEnum idiom = IdionsEnum.PT_BR;

	// Name players
	public static final String namePlayer = "Abimael ;Gustavo ;Fernando ;Douglas ;Carlos ;Leandro ;Alberto ;Gugu ;Abibi ;Nando ;Magno ;Miguel ;Lucas ;Guilherme ;"
			+ "Enzo ;Arthur ;Matheus;Davi ;Bernardo ;Gervinho ;Pelé ;Maicon ;Coxinha ;Anão ;Zequinha ;Joca ;João Snow ;Guitarrista ;Pedreiro ;Gaitero ;Alfredo ;"
			+ "Zico ;Maradona ;Gentil ;Getulio ;Pato ;Ronaldo ;Imperador ;Fenomeno ;Caimbrâ ;Gervim ;Gervasio ;Aldevino ;Xereque ;Chambinha;Sapeca ;Queijo ;Godofredo ;"
			+ "Champis ;Ronaldinho ;Julio César ;Adriano ;Adrianinho ;  Fernandinho;Jé ; Zinho ;Zézinho ;Estrelinha ;Neitam ;Naitaçu ;Cabeleira ;Louco ;Porquinho ;Tico ;Ganso ;"
			+ "Marreco ;Bezerro ; Zólhudo ;Robssu ; Robssom ; Maçaneta ;";
	// Midle name players
	//public static final String midleNamePlayer = "wellington ;Roberto ;Caxias ;Alvez ;Alvarenga ;Romero ;Sabino ;Augusto ;Facebocssom ;Araujo ;Cerse ;";

	// Midle name players
	public static final String lastNamePlayer = "Fidencio ;Silva ;Souza ;Temer ;Rousseff ;Juca ;Birk ;Franca ;Ferronatto ;Pessoa ;Palma ;Resende;Longuinho;Vidal;Lobos;Arantes;Sales;"
			+ "Peixoto;Filgueira;Solim�es;Louzada;Fontes;"
			+ "Bou�as;Mangueira;Gon�alves;Rodrigues;Martins;Lopes;Gomes;Mendes;Antunes;Soares;Domingues;Marques;Paes;Ximenes;Ramires;Sanches;Chaves;Ordonhes;Marcondes;Marins;Guterres;"
			+ "Castanho;Castelo;Modesto;Gentil;Martim;Rolim;Vimaranes;Fontinhas;Bittencourt;Garças"
			+ "da casa Amarela; bom e bola;das quebradas;caça-rato;pé de Porco;do campo;de Mattos;Avassalador;Chuta que é Macumba;da conceição;da anunciação;Sanguessuga;pé-de-muleque;Muzambinho;Pontes; Ponte Alta; Ladeira; Ladeira a baixo;"
			+ "Cavalo; Jeguim;Piriquito;Pena Branca;Tupi;Guarani;Castelo Branco;Branco;Frangancia;Cheiro;Paçoquita;Cheiroso;Fimose;Cata Vento;Neto;Junior;Jr;"
			+ "Gafanhoto;Pequeno Gafanhoto;Gaguinho;Marceneiro;da Padoca;Frescal;Marcelino;Celhinho;Garra Larga;Cabebulo;Cabeleira;Nego Veio;Gaucho;Lazarento;Netinho;Nazaré;Noé;"
			+ "Jofrey; House; Muro Alto; Lambança;Scot; Scout; Jovelino; Quebra queicho;Natalino;Facundes;Antunes;Netinho;Cretino;Natanael;Covarde;Neitam;Fogaça;Claytom;Calaitu;Juju;catatal;Negueba;"
			+ "Redenção;Pinto;Fulo;Avatar;Regaço;Pintolino;Cadeira;";

	public static final String teamName = "Flamengo ;Vasco ;Botafogo ;Bragantino ;S�o Paulo ;Corinthias ;Chapecoense ;Figueirense ;Ava� ;Palmeiras ;Internacional ;Gremio ;Santos ;Ponte Preta ;Santa Cruz ;Atl�tico PR ;Fluminense ;Vit�ria ;Curitiba ;Cruzeiro ;Atl�tico Mineiro ;Sport ;Am�rica RJ ;Portuguesa ;Atl�tico Goianiense ;Bahia ;Criciuma ;Ceará ;Londrina ;Payssandu ;";

	public static final String regions = "Santa Catarina;Rio Grande do Sul;Paraná;São Paulo;Rio de Janeiro;Goiais;Bahia;Tocantins;Ceará;Amazonia;Roraima";


	public static List<String> getNamesTeans() {
		return namesTeams;
	}

	@Override
	public String getNamecountry() {
		return Brasil.nameCountry;
	}

	@Override
	public String getLamguage() {
		return Brasil.lamguage;
	}

	@Override
	public String getNameplayer() {
		return Brasil.namePlayer;
	}

	@Override
	public String getLastnameplayer() {
		return Brasil.lastNamePlayer;
	}

	@Override
	public String getTeamname() {
		return Brasil.teamName;
	}

	@Override
	public String getRegions() {
		return Brasil.regions;
	}

	@Override
	public IdionsEnum getIdiom() {
		return idiom;
	}


}

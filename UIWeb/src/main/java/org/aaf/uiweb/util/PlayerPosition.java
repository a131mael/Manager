/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aaf.uiweb.util;

import javax.enterprise.inject.Model;

/**
 *Conversor de posicao
 * 
 * @author Abimael Fidencio
 */
@Model
public class PlayerPosition {
   
	public String getPosition(int valor){
		String position = "";
		if(valor == 0){
			position = "GK";
		}else if(valor == 1){
			position = "DEF";
		}else if(valor == 2){
			position = "MID";
		}else if(valor == 3){
			position = "ATT";
		}
		return position;
	}
}

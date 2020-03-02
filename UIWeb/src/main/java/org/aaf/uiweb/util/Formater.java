package org.aaf.uiweb.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Formater {

	
	
	public static float format(double value){
		 DecimalFormat formatter = new DecimalFormat("#0.00");
		 return Float.parseFloat(formatter.format(value).replace(",", "."));
	}
	
	public static float format(float value){
		 DecimalFormat formatter = new DecimalFormat("#0.00");
		 return Float.parseFloat(formatter.format(value).replace(",", "."));
	}
	
	public static String formatCurrency(Long value){
		 NumberFormat formatter = NumberFormat.getCurrencyInstance();
		 return formatter.format(value);
	}
	
}

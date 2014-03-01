package com.vipro.utils.spring;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberConverter {
	public static String convertDigitTextOnly(BigDecimal number) {
		DecimalFormat format = new DecimalFormat();
		format.setMaximumFractionDigits(2);
		format.setMinimumFractionDigits(2);
		format.setGroupingUsed(false);
		String result = format.format(number).toString();
		System.out.println(result);
		String[] fractions = result.split("\\.");
		
		String digitText = new String();
		String decimalText = new String();
		
		digitText = convertUnit(Integer.parseInt(fractions[0]));
		if(fractions.length == 2) {
			System.out.println(fractions[1]);
			decimalText = convertUnit(Integer.parseInt(fractions[1]));
		}
		
		return digitText + decimalText + " Only.";
	}


	public static String convert(BigDecimal number) {
		DecimalFormat format = new DecimalFormat();
		format.setMaximumFractionDigits(2);
		format.setMinimumFractionDigits(2);
		format.setGroupingUsed(false);
		String result = format.format(number).toString();
		System.out.println(result);
		String[] fractions = result.split("\\.");
		
		String digitText = new String();
		String decimalText = new String();
		
		digitText = convertUnit(Integer.parseInt(fractions[0]));
		if(fractions.length == 2) {
			System.out.println(fractions[1]);
			decimalText = convertUnit(Integer.parseInt(fractions[1]));
		}
		
		return digitText + " Ringgits " + decimalText + " Cents";
	}
	
	public static String convertUnit(int i) {
		final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", 
				"Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", 
				"Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
		final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	
		if( i < 20)  return units[i];
		if( i < 100) return tens[i/10] + ((i % 10 > 0)? " " + convertUnit(i % 10):"");
		if( i < 1000) return units[i/100] + " Hundred" + ((i % 100 > 0)?" and " + convertUnit(i % 100):"");
		if( i < 1000000) return convertUnit(i / 1000) + " Thousand" + ((i % 1000 > 0)? " " + convertUnit(i % 1000):"") ;
		return convertUnit(i / 1000000) + " Million" + ((i % 1000000 > 0)? " " + convertUnit(i % 1000000):"") ;
	}
	
	public static void main(String args[]) {
		System.out.println(convert(new BigDecimal(999999999.99d)));
	}
}

package com.tobias.saul.starwarspersonservice.utils;

public class StarWarsPersonUtils {
	
	public static String formatUrlToContainHttps(String url) {
		StringBuilder str = new StringBuilder(url);
		str.insert(4, 's');
		return str.toString();
	}

}

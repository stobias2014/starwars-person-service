package com.tobias.saul.starwarspersonservice.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;

import com.tobias.saul.starwarspersonservice.model.Film;
import com.tobias.saul.starwarspersonservice.model.Person;
import com.tobias.saul.starwarspersonservice.model.Planet;
import com.tobias.saul.starwarspersonservice.web.response.PeopleResponse;

public class StarWarsPersonUtils {

	public static String formatUrlToContainHttps(String url) {
		StringBuilder str = new StringBuilder(url);
		str.insert(4, 's');
		return str.toString();
	}
	
	@Async
	public static List<Person> addToPeopleList(ResponseEntity<PeopleResponse> peopleResponse,
			RestTemplate restTemplate) {

		final List<Person> people = new ArrayList<Person>();

		people.addAll(peopleResponse.getBody().getResults());

		long now = System.currentTimeMillis();

		while (peopleResponse.getBody().getNext() != null) {
			if (peopleResponse.getBody().getNext() == null) {
				continue;
			} else {
				String urlFormattedToHttps = StarWarsPersonUtils
						.formatUrlToContainHttps(peopleResponse.getBody().getNext());
				peopleResponse = restTemplate.getForEntity(urlFormattedToHttps, PeopleResponse.class);
				people.addAll(peopleResponse.getBody().getResults());
			}
		}

		System.out.println(
				"\nAfter while loop requests -------- > " + ((System.currentTimeMillis() - now) / 1000) + " seconds\n");

		people.parallelStream().forEach(p -> {
			ResponseEntity<Planet> homeworld = restTemplate
					.getForEntity((StarWarsPersonUtils.formatUrlToContainHttps(p.getHomeworldLink())), Planet.class);
			p.setHomeworldPlanet(homeworld.getBody());
		});
		
		System.out.println("\nAfter setting planet for person -------- > " + ((System.currentTimeMillis() - now) / 1000)
				+ " seconds\n");
		
		people.forEach(p -> {
			p.setFilm(new ArrayList<Film>());
			p.getFilmLinks().forEach(link -> {
				ResponseEntity<Film> film = restTemplate.getForEntity(formatUrlToContainHttps(link), Film.class);
				p.getFilm().add(film.getBody());
			});
			
		});
		
		System.out.println("\nAfter setting film for person -------- > " + ((System.currentTimeMillis() - now) / 1000)
				+ " seconds\n");

		return people;
	}
	

}

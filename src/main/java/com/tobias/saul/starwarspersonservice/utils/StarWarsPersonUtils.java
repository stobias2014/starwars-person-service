package com.tobias.saul.starwarspersonservice.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tobias.saul.starwarspersonservice.model.Person;
import com.tobias.saul.starwarspersonservice.model.Planet;
import com.tobias.saul.starwarspersonservice.web.response.PeopleResponse;

public class StarWarsPersonUtils {

	public static String formatUrlToContainHttps(String url) {
		StringBuilder str = new StringBuilder(url);
		str.insert(4, 's');
		return str.toString();
	}

	public static List<Person> addToPeopleList(ResponseEntity<PeopleResponse> peopleResponse,
			RestTemplate restTemplate) {

		List<Person> people = new ArrayList<Person>();
		
		people.addAll(peopleResponse.getBody().getResults());
		// keep adding to list until next is null
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
		
		people.forEach(p -> {
			Planet homeworld = restTemplate.getForObject((StarWarsPersonUtils.formatUrlToContainHttps(p.getHomeworldLink())), Planet.class);
			p.setHomeworldPlanet(homeworld);
		});

		return people;
	}

}

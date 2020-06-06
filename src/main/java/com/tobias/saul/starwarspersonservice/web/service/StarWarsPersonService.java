package com.tobias.saul.starwarspersonservice.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tobias.saul.starwarspersonservice.model.Person;
import com.tobias.saul.starwarspersonservice.utils.StarWarsPersonUtils;
import com.tobias.saul.starwarspersonservice.web.response.PeopleResponse;

@RestController
@RequestMapping("/characters")
public class StarWarsPersonService {

	private final String BASE_URL = "https://swapi.dev/api/people/";
	
	private final RestTemplate restTemplate;

	@Autowired
	public StarWarsPersonService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping
	public List<Person> getAllStarWarsPerson() {

		List<Person> people = new ArrayList<Person>();

		ResponseEntity<PeopleResponse> response = restTemplate.getForEntity(BASE_URL, PeopleResponse.class);
		
		people.addAll(response.getBody().getResults());
		
		// keep adding to list until next is null
		while (response.getBody().getNext() != null) {
			if (response.getBody().getNext() == null) {
				continue;
			} else {
				String urlFormattedToHttps = StarWarsPersonUtils.formatUrlToContainHttps(response.getBody().getNext());
				response = restTemplate.getForEntity(urlFormattedToHttps, PeopleResponse.class);
				people.addAll(response.getBody().getResults());
			}
		}
		
		return people;
	}
	


}

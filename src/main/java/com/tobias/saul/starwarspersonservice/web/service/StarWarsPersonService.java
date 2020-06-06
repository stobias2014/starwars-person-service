package com.tobias.saul.starwarspersonservice.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

		List<Person> people;

		ResponseEntity<PeopleResponse> response = restTemplate.getForEntity(BASE_URL, PeopleResponse.class);
		
		people = StarWarsPersonUtils.addToPeopleList(response, restTemplate);
		
		return people;
	}
	
	@GetMapping("/{personId}")
	public Person getStarWarsPerson(@PathVariable("personId") Integer personId) {
		List<Person> people;
		
		ResponseEntity<PeopleResponse> response = restTemplate.getForEntity(BASE_URL, PeopleResponse.class);
		
		people = StarWarsPersonUtils.addToPeopleList(response, restTemplate);
		
		Person person = people.get(personId - 1);
		
		return person;
	}
	


}

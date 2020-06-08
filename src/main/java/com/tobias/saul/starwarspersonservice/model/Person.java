package com.tobias.saul.starwarspersonservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	
	private String name;
	@JsonProperty(defaultValue = "unkown")
	private String height;
	@JsonProperty(defaultValue = "unkown", value = "hair_color")
	private String hairColor;
	@JsonProperty(defaultValue = "unkown", value = "eye_color")
	private String eyeColor;
	@JsonProperty(defaultValue = "unkown", value = "birth_year")
	private String birthYear;
	@JsonProperty(defaultValue = "unkown")
	private String gender;
	@JsonProperty(value = "homeworld")
	private String homeworldLink;
	private Planet homeworldPlanet;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getHairColor() {
		return hairColor;
	}
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	public String getEyeColor() {
		return eyeColor;
	}
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Planet getHomeworldPlanet() {
		return homeworldPlanet;
	}
	public void setHomeworldPlanet(Planet homeworldPlanet) {
		this.homeworldPlanet = homeworldPlanet;
	}
	public String getHomeworldLink() {
		return homeworldLink;
	}
	public void setHomeworldLink(String homeworldLink) {
		this.homeworldLink = homeworldLink;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", height=" + height + ", hairColor=" + hairColor + ", eyeColor=" + eyeColor
				+ ", birthYear=" + birthYear + ", gender=" + gender + ", homeworldLink=" + homeworldLink
				+ ", homeworld=" + homeworldPlanet + "]";
	}
		
	
	
}

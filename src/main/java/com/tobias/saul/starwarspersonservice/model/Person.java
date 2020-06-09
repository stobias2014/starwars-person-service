package com.tobias.saul.starwarspersonservice.model;

import java.util.List;

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
	@JsonProperty(value = "films")
	private List<String> filmLinks;
	private List<Film> film;
	
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
	public List<String> getFilmLinks() {
		return filmLinks;
	}
	public void setFilmLinks(List<String> filmLinks) {
		this.filmLinks = filmLinks;
	}
	public List<Film> getFilm() {
		return film;
	}
	public void setFilm(List<Film> film) {
		this.film = film;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthYear == null) ? 0 : birthYear.hashCode());
		result = prime * result + ((eyeColor == null) ? 0 : eyeColor.hashCode());
		result = prime * result + ((film == null) ? 0 : film.hashCode());
		result = prime * result + ((filmLinks == null) ? 0 : filmLinks.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((hairColor == null) ? 0 : hairColor.hashCode());
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((homeworldLink == null) ? 0 : homeworldLink.hashCode());
		result = prime * result + ((homeworldPlanet == null) ? 0 : homeworldPlanet.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (birthYear == null) {
			if (other.birthYear != null)
				return false;
		} else if (!birthYear.equals(other.birthYear))
			return false;
		if (eyeColor == null) {
			if (other.eyeColor != null)
				return false;
		} else if (!eyeColor.equals(other.eyeColor))
			return false;
		if (film == null) {
			if (other.film != null)
				return false;
		} else if (!film.equals(other.film))
			return false;
		if (filmLinks == null) {
			if (other.filmLinks != null)
				return false;
		} else if (!filmLinks.equals(other.filmLinks))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (hairColor == null) {
			if (other.hairColor != null)
				return false;
		} else if (!hairColor.equals(other.hairColor))
			return false;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (homeworldLink == null) {
			if (other.homeworldLink != null)
				return false;
		} else if (!homeworldLink.equals(other.homeworldLink))
			return false;
		if (homeworldPlanet == null) {
			if (other.homeworldPlanet != null)
				return false;
		} else if (!homeworldPlanet.equals(other.homeworldPlanet))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", height=" + height + ", hairColor=" + hairColor + ", eyeColor=" + eyeColor
				+ ", birthYear=" + birthYear + ", gender=" + gender + ", homeworldLink=" + homeworldLink
				+ ", homeworldPlanet=" + homeworldPlanet + ", filmLinks=" + filmLinks + ", film=" + film + "]";
	}
	
	
		
	
	
}

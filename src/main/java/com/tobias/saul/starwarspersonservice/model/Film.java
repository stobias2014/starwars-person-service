package com.tobias.saul.starwarspersonservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Film {
	
	private String title;
	@JsonProperty(value = "episode_id")
	private String episodeId;
	@JsonProperty(value = "opening_crawl")
	private String openingCrawl;
	private String director;
	private String producer;
	@JsonProperty(value = "release_date")
	private String releaseDate;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEpisodeId() {
		return episodeId;
	}
	public void setEpisodeId(String episodeId) {
		this.episodeId = episodeId;
	}
	public String getOpeningCrawl() {
		return openingCrawl;
	}
	public void setOpeningCrawl(String openingCrawl) {
		this.openingCrawl = openingCrawl;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((episodeId == null) ? 0 : episodeId.hashCode());
		result = prime * result + ((openingCrawl == null) ? 0 : openingCrawl.hashCode());
		result = prime * result + ((producer == null) ? 0 : producer.hashCode());
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Film other = (Film) obj;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (episodeId == null) {
			if (other.episodeId != null)
				return false;
		} else if (!episodeId.equals(other.episodeId))
			return false;
		if (openingCrawl == null) {
			if (other.openingCrawl != null)
				return false;
		} else if (!openingCrawl.equals(other.openingCrawl))
			return false;
		if (producer == null) {
			if (other.producer != null)
				return false;
		} else if (!producer.equals(other.producer))
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Film [title=" + title + ", episodeId=" + episodeId + ", openingCrawl=" + openingCrawl + ", director="
				+ director + ", producer=" + producer + ", releaseDate=" + releaseDate + "]";
	}
	
	

}

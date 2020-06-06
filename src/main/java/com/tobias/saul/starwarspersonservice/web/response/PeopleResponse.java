package com.tobias.saul.starwarspersonservice.web.response;

import java.util.List;

import com.tobias.saul.starwarspersonservice.model.Person;

public class PeopleResponse{
	
	private List<Person> results;
	private String next;

	public List<Person> getResults() {
		return results;
	}

	public void setResults(List<Person> results) {
		this.results = results;
	}
	
	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((results == null) ? 0 : results.hashCode());
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
		PeopleResponse other = (PeopleResponse) obj;
		if (results == null) {
			if (other.results != null)
				return false;
		} else if (!results.equals(other.results))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PeopleResponse [results=" + results + "]";
	}
	
	

}

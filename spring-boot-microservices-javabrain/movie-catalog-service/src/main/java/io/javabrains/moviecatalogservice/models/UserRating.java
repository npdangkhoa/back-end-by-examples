package io.javabrains.moviecatalogservice.models;

import java.util.List;

public class UserRating {
	private List<Rating> rating;

	
	public UserRating() {
		super();
	}


	public UserRating(List<Rating> rating) {
		super();
		this.rating = rating;
	}

	
	public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}
	
	
}

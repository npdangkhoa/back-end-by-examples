package io.javabrains.movieratingdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.movieratingdataservice.models.Rating;
import io.javabrains.movieratingdataservice.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResoure {
	
	@RequestMapping("/{movieId}") 
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}

	@RequestMapping("/user/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(new Rating("1234", 4), new Rating("5679", 3));
		return new UserRating(ratings);
	}
}

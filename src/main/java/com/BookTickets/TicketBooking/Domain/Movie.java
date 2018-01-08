package com.BookTickets.TicketBooking.Domain;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

//import org.codehaus.jackson.annotate.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown=true)

@com.fasterxml.jackson.annotation.JsonIgnoreProperties
@Document(collection = "Movie")
public class Movie {

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	private String id;
	
	@Indexed(unique = true)
	private String movieName;

	private int rating;

	private String description; 

	 private List<Review> reviews;

	private HashMap<String,String> crew;
	
	public Movie()
	{
		super();
	}

	public HashMap<String, String> getCrew() {
		return crew;
	}

	public void setCrew(HashMap<String, String> crew) {
		this.crew = crew;
	}


	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Movie ["+"MovieName=" + movieName+ ", Description=" + description + "]";
	}

}

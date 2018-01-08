package com.BookTickets.TicketBooking.Domain;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown=true)
@Document(collection = "Movie")
public class Movie {
	@Id
	private String id;
	
	
	@Indexed(unique = true)
	private String MovieName;

	private int Rating;

	private String Description; 

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMovieName() {
		return MovieName;
	}

	public void setMovieName(String movieName) {
		MovieName = movieName;
	}

	public int getRating() {
		return Rating;
	}

	public void setRating(int rating) {
		Rating = rating;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", MovieName=" + MovieName+ ", Description=" + Description + "]";
	}

}

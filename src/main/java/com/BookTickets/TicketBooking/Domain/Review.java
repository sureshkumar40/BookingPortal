package com.BookTickets.TicketBooking.Domain;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown=true)
public class Review {
	
	@Id
	String id;
	String username;
	
	String ReviewComments;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getReviewComments() {
		return ReviewComments;
	}

	public void setReviewComments(String reviewComments) {
		ReviewComments = reviewComments;
	}

}

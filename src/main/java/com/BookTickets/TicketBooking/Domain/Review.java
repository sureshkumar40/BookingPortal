package com.BookTickets.TicketBooking.Domain;

import org.springframework.data.annotation.Id;

public class Review {
	
	@Id
	String id;
	String username;
	
	String ReviewComments;

}

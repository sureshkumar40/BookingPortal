package com.BookTickets.TicketBooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = { "com.BookTickets.TicketBooking", "com.BookTickets.TicketBooking.Controller", "com.BookTickets.TicketBooking.Domain", "com.BookTickets.TicketBooking.Repository" })
//@EnableMongoRepositories({"com.BookTickets.TicketBooking.Repository"})
public class TicketBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingApplication.class, args);
	}
	
	
}

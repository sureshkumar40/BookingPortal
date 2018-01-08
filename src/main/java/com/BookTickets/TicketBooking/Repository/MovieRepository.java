package com.BookTickets.TicketBooking.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.BookTickets.TicketBooking.Domain.Customer;
import com.BookTickets.TicketBooking.Domain.Movie;

public interface MovieRepository extends MongoRepository<Movie, String> {

	Movie findByMovieName(String movieName);

}

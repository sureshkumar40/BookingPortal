package com.BookTickets.TicketBooking.Domain.Repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.BookTickets.TicketBooking.Domain.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{
	
	public Customer findById(String id);
	public Customer findByFirstName(String firstName);

}

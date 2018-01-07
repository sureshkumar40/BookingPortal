package com.BookTickets.TicketBooking.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.BookTickets.TicketBooking.Domain.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{
	
	public Customer findById(String id);
	public Customer findByemailId(String emailId);

}

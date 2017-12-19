package com.BookTickets.TicketBooking.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.BookTickets.TicketBooking.Domain.Customer;

@RestController
@Path("/MovieDetails")
public class MovieController {
	
	@Autowired
	com.BookTickets.TicketBooking.Repository.CustomerRepository CustomerRepository;
	
	@Path("/GetMovieByName/{name}")
	@GET
	public String getMovieByName(@PathParam("name") final String name)
	
	{
		Customer customer = new Customer(name, "B", "manub.varkala@gmail.com", "8714443740");
		customer=CustomerRepository.insert(customer);
		return "Getting data for movie : "+customer;
	}
	
	@Path("/GetMovieByID/{id}")
	@GET
	public String getMovieByID(@PathParam("id") final String id)
	{
		return "Getting data for movie : "+id;
	}

}

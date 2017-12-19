package com.BookTickets.TicketBooking.Controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

import com.BookTickets.TicketBooking.Domain.Customer;

@RestController
@Path("/MovieDetails")
public class MovieController {
	
	Response response;
	
	@Autowired
	com.BookTickets.TicketBooking.Repository.CustomerRepository CustomerRepository;
	
	@Path("/GetMovieByName/{name}")
	@GET
	public String getMovieByName(@PathParam("name") final String name)
	
	{
		Customer customer = new Customer(name, "B", "manub.varkala@gmail.com", "8714443740");
		customer=CustomerRepository.save(customer);
		System.out.println("Suresh");
		return "Getting data for movie : "+customer;
	}
	
	@Path("/create")
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response createCustomer(Customer customer)
	{
		CustomerRepository.save(customer);
		return Response.status(200).entity(customer).build();
		
	}
	
	
	@Path("/GetMovieByID/{id}")
	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<Customer> getMovieByID(@PathParam("id") final String id)
	{
		
		return CustomerRepository.findAll();
	}

}

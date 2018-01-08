package com.BookTickets.TicketBooking.Controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.BookTickets.TicketBooking.Domain.Customer;
import com.BookTickets.TicketBooking.service.CustomerService;
import com.BookTickets.TicketBooking.serviceimpl.CustomerServiceImpl;

@RestController
@Path("/user")
public class UserController {
	
Response response;

@Autowired
CustomerServiceImpl CustomerService;

	
	@Autowired
	com.BookTickets.TicketBooking.Repository.CustomerRepository CustomerRepository;
	
	
	@Path("/create")
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response createCustomer(Customer customer)
	{
		CustomerService.createCustomer(customer);
		return Response.status(200).entity(customer).build();
		
	}
	
	
	@Path("/allUsers")
	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Iterable<Customer> getUsers()
	{
		return CustomerService.getUsers();
	}
	
	@Path("/{emailId}")
	@GET
	public Customer getuserbyemailid(@PathParam("emailId") final String emailId)
	
	{
		Customer customer=CustomerService.getuserbyemailid(emailId);
		return customer;
	}
	
	@Path("/update/")
	@PUT
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Customer updateusers(Customer customer)
	{
		Customer cust=CustomerService.updateusers(customer);
		return cust;
	}
	
	@DELETE
	@Path("/del/{emailId}")
	public String deleuser(@PathParam("emailId") final String emailId)
	{
		CustomerService.deleuser(emailId);
		return "User has been deleted";
	}

	
	



}

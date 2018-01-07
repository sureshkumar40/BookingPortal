package com.BookTickets.TicketBooking.service;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.BookTickets.TicketBooking.Domain.Customer;

public interface CustomerService {
	public Response createCustomer(Customer customer);
	public Iterable<Customer> getUsers();
	public Customer getuserbyemailid(String emailId);
	public Customer updateusers(Customer customer);
	public String deleuser(String emailId);

}

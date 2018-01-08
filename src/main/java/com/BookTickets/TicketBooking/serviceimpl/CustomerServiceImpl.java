package com.BookTickets.TicketBooking.serviceimpl;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookTickets.TicketBooking.Domain.Customer;
import com.BookTickets.TicketBooking.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	com.BookTickets.TicketBooking.Repository.CustomerRepository CustomerRepository;
	

	@Override
	public Response createCustomer(Customer customer) {
		CustomerRepository.save(customer);
		return Response.status(200).entity(customer).build();
		
	}

	@Override
	public Iterable<Customer> getUsers() {
		return CustomerRepository.findAll();
	}

	@Override
	public Customer getuserbyemailid(String emailId) {
		Customer customer=CustomerRepository.findByemailId(emailId);
		return customer;
	}

	@Override
	public Customer updateusers(Customer customer) {
		String emailId=customer.getEmailId();
		Customer cust=CustomerRepository.findByemailId(emailId);
		if(customer.getFirstName() != null)
			cust.setFirstName(customer.getFirstName());
        if(customer.getLastName() != null)
        	cust.setLastName(customer.getLastName());
        if(customer.getEmailId() != null)
        	cust.setEmailId(customer.getEmailId());
        if( customer.getPhoneNumber() != null)
            cust.setPhoneNumber(customer.getPhoneNumber());
        CustomerRepository.save(cust);
		return cust;
	}

	@Override
	public String deleuser(String emailId) {
		Customer customer=CustomerRepository.findByemailId(emailId);
		CustomerRepository.delete(customer);
		return "User has been deleted";
	}
	

}

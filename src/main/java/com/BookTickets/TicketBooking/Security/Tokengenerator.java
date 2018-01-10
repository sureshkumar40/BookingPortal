package com.BookTickets.TicketBooking.Security;

import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.BookTickets.TicketBooking.Domain.Customer;
import com.BookTickets.TicketBooking.Domain.Usercredentials;
import com.BookTickets.TicketBooking.Repository.CustomerRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class Tokengenerator {
	
	@Autowired
	CustomerRepository customerRepository;

	public String generate(Usercredentials usercredential) {
		String token = null;
		
		Optional<Customer> customer=customerRepository.findByfirstName(usercredential.getUsername());
		
		if(customer.isPresent())
		{
		 Claims claims = Jwts.claims()
	                .setSubject(customer.get().getFirstName()+" "+customer.get().getLastName());
	        //claims.put("userId", String.valueOf(jwtUser.getId()));
	        claims.put("role", "Admin");

	        token=Jwts.builder()
	                .setClaims(claims)
	                .signWith(SignatureAlgorithm.HS512, "APPLE")
	                .compact();
	        
		}else
		{
			throw new RuntimeException("User does not exists");
		}
	        
	        
	        return token;
	}

}

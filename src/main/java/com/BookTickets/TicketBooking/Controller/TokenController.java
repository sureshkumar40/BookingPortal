package com.BookTickets.TicketBooking.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.NewCookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RestController;

import com.BookTickets.TicketBooking.Domain.Usercredentials;
import com.BookTickets.TicketBooking.Security.Tokengenerator;

@RestController
@Path("/auth")
public class TokenController {
	
	@Autowired
	private Tokengenerator tokengen;
	
	@Path("/token")
	@POST
	public String generate(Usercredentials usercredential)
	{
		 /*Cookie[] cookie= httpServletRequest.getCookies();
		((HttpServletResponse) response).setHeader("SET-COOKIE", "JSESSIONID=" +  + "; HttpOnly");
*/
		
		return tokengen.generate(usercredential);
	}
	

}

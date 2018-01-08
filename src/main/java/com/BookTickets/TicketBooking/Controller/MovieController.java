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
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

import com.BookTickets.TicketBooking.Domain.Customer;
import com.BookTickets.TicketBooking.Domain.Movie;
import com.BookTickets.TicketBooking.serviceimpl.MovieServiceImpl;

@RestController
@Path("/MovieDetails")
public class MovieController {
	
	Response response;
	
	@Autowired
	MovieServiceImpl movieService;
	
	@Autowired
	com.BookTickets.TicketBooking.Repository.CustomerRepository CustomerRepository;
	
	/*@Path("/GetMovieByName/{name}")
	@GET
	public String getMovieByName(@PathParam("name") final String name)
	
	{
		Customer customer = new Customer(name, "B", "manub.varkala@gmail.com", "8714443740");
		Customer customer=CustomerRepository.save(customer);
		System.out.println("Suresh");
		return "Getting data for movie : "+customer;
	}
	*/
	@Path("/create")
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response createMovie(Movie movie)
	{
		movieService.createMovie(movie);
		return Response.status(200).entity(movie).build();
		
	}
	
	@Path("/allMovies/")
	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Iterable<Movie> getMovies()
	{
		return movieService.getMovies();
	}
	
	@Path("/{MovieName}")
	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Movie getMovieByID(@PathParam("MovieName") String movieName)
	{
		
		return movieService.getmoviebyname(movieName);
	}
	
	@Path("/update/")
	@PUT
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Movie updatemovie(Movie movie)
	{
		Movie mov=movieService.updatemovie(movie);
		return mov;
	}
	
	@DELETE
	@Path("/del/{MovieName}/")
	public String deleuser(@PathParam("MovieName") String moviename)
	{
		return movieService.delemovie(moviename);
	}

}

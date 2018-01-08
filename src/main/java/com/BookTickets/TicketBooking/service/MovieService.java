package com.BookTickets.TicketBooking.service;

import javax.ws.rs.core.Response;

import com.BookTickets.TicketBooking.Domain.Customer;
import com.BookTickets.TicketBooking.Domain.Movie;

public interface MovieService {
	public Response createMovie(Movie movie);
	public Iterable<Movie> getMovies();
	public Movie getmoviebyname(String MovieName);
	public Movie updatemovie(Movie movie);
	public String delemovie(String MovieName);

}

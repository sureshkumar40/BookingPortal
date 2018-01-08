package com.BookTickets.TicketBooking.serviceimpl;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookTickets.TicketBooking.Domain.Customer;
import com.BookTickets.TicketBooking.Domain.Movie;
import com.BookTickets.TicketBooking.Repository.MovieRepository;
import com.BookTickets.TicketBooking.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	MovieRepository movieRepository;

	@Override
	public Response createMovie(Movie movie) {
		movieRepository.save(movie);
		return Response.status(200).entity(movie).build();
	}

	@Override
	public Iterable<Movie> getMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Movie getmoviebyname(String movieName) {
		Movie movie=movieRepository.findByMovieName(movieName);
		return movie;
	}

	@Override
	public Movie updatemovie(Movie movie) {

		String movieName=movie.getMovieName();
		Movie updtmovie=movieRepository.findByMovieName(movieName);
		if(movie.getDescription()!=null)
			updtmovie.setDescription(movie.getDescription());
		if(movie.getRating()!=0)
			updtmovie.setRating(movie.getRating());
		if(movie.getReviews()!=null)
			updtmovie.setReviews(movie.getReviews());
		if(movie.getCrew()!=null)
			updtmovie.setCrew(movie.getCrew());
		movieRepository.save(updtmovie);
		return updtmovie;
	}

	@Override
	public String delemovie(String MovieName) {
		Movie movie=movieRepository.findByMovieName(MovieName);
			movieRepository.delete(movie);
		return "Movie has been deleted";
	}

}

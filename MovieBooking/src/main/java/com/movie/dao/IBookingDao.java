package com.movie.dao;

import java.util.List;

import com.movie.entities.Seat;
import com.movie.entities.Theatre;
import com.movie.entities.Ticket;
import com.movie.entities.User;



public interface IBookingDao {
	public double getPrice(int seatId);
	/*
	public List<User> getUserDetails();
	public List<Ticket> getTicketDetails();
	public List<Theatre> getTheater(int movieId);
	public Seat getSeat(int seatId);
*/
}

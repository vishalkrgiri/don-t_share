package com.movie.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.movie.entities.Booking;
import com.movie.entities.Customer;
import com.movie.entities.Payment;
import com.movie.entities.PaymentType;
import com.movie.entities.Seat;
import com.movie.entities.Theatre;
import com.movie.entities.Ticket;
import com.movie.entities.User;


public interface IBookingService {
	 

	 Booking generateBooking(Seat[] seats,Customer customer) throws Exception;
	 

	 Payment generatePayment(double price,Booking booking);
	 
	 
	 Booking successThePayment(Payment payment,PaymentType type);
	 
	 
	 Booking failThePayment(Payment payment);
	 
	 
	 void expireBooking(Booking booking);
	 
	 
	 void BlockSeats(List<Seat> seats);
	 
	 
	 void unBlockSeats(List<Seat> seats);
	 
	 
	 void BookSeats(List<Seat> seats);
	 
	 
	 void unBookSeats(List<Seat> seats);
	 
	 Boolean isSeatsAvailable(List<Seat> seats);
	 
	 Ticket generateTicket(Booking booking);
	 
	 Ticket cancelTicket(Ticket ticket);
	 
	
	 
	 //done
	 Payment ConfirmBooking(Booking booking);
	 
	 List<Seat> getSeats(Integer id);
	 
	 /*
	public List<User> getUserDetails();
	public List<Ticket> getTicketDetails();
	public List<Theatre> getTheater(int movieId);
	public Seat getSeat(int seatId);
	*/
	 
	 

}

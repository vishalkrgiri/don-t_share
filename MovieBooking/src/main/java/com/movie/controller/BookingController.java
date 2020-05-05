package com.movie.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entities.Booking;
import com.movie.entities.Customer;
import com.movie.entities.Payment;
import com.movie.entities.Seat;
import com.movie.entities.Theatre;
import com.movie.entities.Ticket;
import com.movie.exception.MovieBookingException;
import com.movie.service.CustomerService;
import com.movie.service.IBookingService;
import com.movie.service.ICustomerService;



@CrossOrigin(origins="http://localhost:4200")
@RestController

public class BookingController {
	@Autowired
	IBookingService service;
	
	@Autowired
	ICustomerService customerservice;
	
	@PostMapping(value="/book")
	public Booking
	generateBooking(@RequestBody Seat[] seats) throws Exception
	{	
		return service.generateBooking(seats,customerservice.getCustomer(3));
	}
	
	@PostMapping(value="/expire")
	public ResponseEntity<String>
	expireBooking(@RequestBody Booking booking)
	{	
		if(booking==null)
		{
			throw new NullPointerException("There is no booking passed to expire");
		}
		service.expireBooking(booking);
		return ResponseEntity.ok("booking expired");
	}
	
	@PostMapping(value="/confirmBooking")
	public Payment confirmBooking(@RequestBody Booking booking)
	{

		return service.ConfirmBooking(booking);

	}
	
	@PostMapping(value="/makePayment")
	public Booking confirmBooking(@RequestBody Payment payment)
	{

		return service.successThePayment(payment, payment.getPaymentType());

	}
		
		
	
	
	@GetMapping(value="/getSeats/{id}")
	public List<Seat>
	generateBooking(@PathVariable Integer id)
	{	
		return service.getSeats(id);
	}
	
	

}
	
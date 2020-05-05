package com.movie.service;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.IBookingDao;
import com.movie.dao.IUniversalDao;
import com.movie.entities.Booking;
import com.movie.entities.Customer;
import com.movie.entities.Movie;
import com.movie.entities.Payment;
import com.movie.entities.PaymentType;
import com.movie.entities.Seat;
import com.movie.entities.SeatState;
import com.movie.entities.Show;
import com.movie.entities.Theatre;
import com.movie.entities.Ticket;
import com.movie.entities.User;
@Service
public class BookingService implements IBookingService {

	
	@Autowired
	IBookingDao dao;
	
	@Autowired
	IUniversalDao<Payment> paymentdao;
	
	@Autowired
	IUniversalDao<Booking> bookingdao;
	
	@Autowired
	IUniversalDao<Ticket> ticketdao;
	
	@Autowired
	IUniversalDao<Seat> seatdao;
	
	@Autowired
	IUniversalDao<Movie> moviedao;
	
	@Autowired
	IUniversalDao<Show> showdao;
	
	
	@Override
	public Payment generatePayment(double price,Booking booking) {
		
		Payment payment=new Payment();
		payment.setAmount(price);
		payment.setPaymentStatus(false);
		payment.setDate(LocalDateTime.now());
		payment.setBooking(booking);
		Integer id=paymentdao.saveAndgetId(payment);
		return paymentdao.findById(id);
		
	}
	
	@Override
	public Booking generateBooking(Seat[] seats,Customer customer) throws Exception
	{
		
		List<Seat> seatsList=new ArrayList<Seat>();
		
		for (Seat seat : seats) {
			seatsList.add(seat);
			
		}
		Booking b=new Booking();
		if(seats[0]==null)
		{
			throw new NullPointerException("Hei the seats you selected are empyty maybe");	
		}
		if(!isSeatsAvailable(seatsList))
		{
			throw new Exception("Some seat is not available for booking");
		}
		BlockSeats(seatsList);
		b.setMovie(showdao.findById(seats[0].getShow().getShowId()).getMovie());
		b.setCustomer(customer);
		b.setTicket(null);
		b.setSeatList(seatsList);
		b.setShow(showdao.findById(seats[0].getShow().getShowId()));
		b.setShowId(b.getShow().getShowId());
		b.setTotalCost(priceCalculator(seatsList));
		b.setTransactionId(null);
		b.setBookingDate(b.getShow().getShowStartTime());
		Integer id=bookingdao.saveAndgetId(b);
		System.out.println(id);
		b.setBookingId(id);
		
		b=bookingdao.findById(id);
		b.setNumOfSeats(seatsList.size());
		return b;
	}
	
	@Override
	public Booking successThePayment(Payment payment,PaymentType type) {
		payment.setPaymentStatus(true);
		payment.setDate(LocalDateTime.now());
		payment.setPaymentType(type);

		Booking booking=bookingdao.findById(payment.getBooking().getBookingId());
		Ticket t=generateTicket(booking);
		bookSeats(booking.getSeatList());
		booking.setTicket(t);
		payment=paymentdao.update(payment);
		return payment.getBooking();
		
	}

	
	
	
	
	public double priceCalculator(List<Seat> seats) {
		double price=0;
//		seats.stream().forEach(seat->price=seat.getSeatPrice()+price);
		for (Iterator iterator = seats.iterator(); iterator.hasNext();) {
			Seat seat = (Seat) iterator.next();
			price+=seat.getSeatPrice();
		}
		return price; 
	}
	
	public void bookSeats(List<Seat> seats) {

//		seats.stream().forEach(seat->price=seat.getSeatPrice()+price);
		for (Iterator iterator = seats.iterator(); iterator.hasNext();) {
			Seat seat = (Seat) iterator.next();
			seat.setSeatStatus(SeatState.BOOKED);
			seatdao.update(seat);
		}
	}


	@Override
	public Booking failThePayment(Payment payment) {
		// TODO Auto-generated method stub
		return payment.getBooking();
	}

	@Override
	public void BlockSeats(List<Seat> seats) {
		// TODO Auto-generated method stub
		for (Seat seat : seats) {
			seat.setSeatStatus(SeatState.BLOCKED);
			seatdao.update(seat);
		}
		
	}

	@Override
	public void unBlockSeats(List<Seat> seats) {
		// TODO Auto-generated method stub
		for (Seat seat : seats) {
			if(seat.getSeatStatus()==SeatState.BLOCKED)
			{
				seat.setSeatStatus(SeatState.AVAILABLE);
				seatdao.update(seat);
			}
		}
	}

	@Override
	public void BookSeats(List<Seat> seats) {
		// TODO Auto-generated method stub
		
		for (Seat seat : seats) {
			if(seat.getSeatStatus()==SeatState.BLOCKED)
			{
				seat.setSeatStatus(SeatState.BOOKED);
				seatdao.update(seat);
			}
		}
		
	}
	
	

	@Override
	public void unBookSeats(List<Seat> seats) {
		// TODO Auto-generated method stub
		
		for (Seat seat : seats) {
			if(seat.getSeatStatus()==SeatState.BOOKED)
			{
				seat.setSeatStatus(SeatState.AVAILABLE);
				seatdao.update(seat);
			}
		}
	}

	@Override
	public Boolean isSeatsAvailable(List<Seat> seats) {
		// TODO Auto-generated method stub
		for (Seat seat : seats) {
			if(seat.getSeatStatus()!=SeatState.AVAILABLE)
			{
				return false;
			}
		}
		return true;
	}
	
	

	@Override
	public Ticket generateTicket(Booking booking) {
		// TODO Auto-generated method stub
		Ticket t=new Ticket();
		t.setBookingRef(booking);
		t.setNoOfSeats(booking.getSeatList().size());
		t.setScreenName(showdao.findById(booking.getShowId()).getScreen().getScreenName());
		t.setScreenName(null);
		t.setTicketStatus(true);
		Integer id=ticketdao.saveAndgetId(t);
		return ticketdao.findById(id);
	}

	@Override
	public Payment ConfirmBooking(Booking booking) {
		// TODO Auto-generated method stub
		
		Booking b=bookingdao.findById(booking.getBookingId());
		Payment payment=generatePayment(b.getTotalCost(), b);
		b.setTransactionId(payment.getPaymentId());
		bookingdao.update(b);
		
		return payment;
	}

	@Override
	public Ticket cancelTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		Ticket t=ticketdao.findById(ticket.getTicketId());
		if(t.getTicketStatus() && t.getBookingRef().getBookingDate().isBefore(LocalDateTime.now()))
		{
			t.setTicketStatus(false);
			List<Seat> seats=t.getBookingRef().getSeatList();
			if(seats.size()>0)
			{
				unBookSeats(seats);
			}
			return ticketdao.update(t);
		}
		//Exception
		return t;
	}

	@Override
	public List<Seat> getSeats(Integer id) {
		// TODO Auto-generated method stub
		
		return bookingdao.findById(id).getSeatList();
	}

	@Override
	public void expireBooking(Booking booking) {
		// TODO Auto-generated method stub
		
		booking=bookingdao.findById(booking.getBookingId());
		if(booking.getTicket()==null)
		{
			unBlockSeats(booking.getSeatList());
			booking.setSeatList(null);
			
			bookingdao.save(booking);
		}
		
	}
	
	
}
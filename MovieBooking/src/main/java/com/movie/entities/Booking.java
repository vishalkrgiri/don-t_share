package com.movie.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="bookings")
@DynamicUpdate
@DynamicInsert
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="bookingId",scope=Booking.class)
public class Booking {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="booking_id")
	private Integer bookingId;
	
	
	@JoinColumn(name="movie_id",referencedColumnName="movie_id")
	@OneToOne
	private Movie movie;
	
	@JoinColumn(name="show_ref",referencedColumnName="show_id")
	@ManyToOne
//	@JsonBackReference
	private Show showRef;
	
	
	@Column(name="booking_date")
	private LocalDateTime bookingDate;
	
	
	@Column(name="total_cost")
	private Double totalCost;

	
	@OneToMany
	@Column(name="seat_id")
//	@JsonManagedReference
	private List<Seat> seatList;
	
	
	@OneToOne(mappedBy="bookingRef")
	@Autowired
//	@JsonBackReference
	private Ticket ticket;

	@Column(name="transaction_id")
	private Integer transactionId;
	
	
	@Column(name="show_id")
	private Integer showId;

	@ManyToOne(fetch=FetchType.LAZY)
//	@JsonBackReference
	private Customer customer;
	
	@Transient
	private Integer numOfSeats;
	
	public Booking() {
		super();
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Show getShow() {
		return showRef;
	}

	public void setShow(Show show) {
		this.showRef = show;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	@JsonIgnore
	public List<Seat> getSeatList() {
		return seatList;
	}

	public void setSeatList(List<Seat> seatList) {
		this.seatList = seatList;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Integer getTransactionId() {
		return transactionId;
	}



	@JsonIgnore
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public void setShowId(Integer showId) {
		this.showId = showId;
	}

	public Integer getShowId() {
		return showId;
	}

	@JsonIgnore
	public Show getShowRef() {
		return showRef;
	}

	public void setShowRef(Show showRef) {
		this.showRef = showRef;
	}

	public Integer getNumOfSeats() {
		return numOfSeats;
	}

	public void setNumOfSeats(Integer numOfSeats) {
		this.numOfSeats = numOfSeats;
	}
	
	
	
	
	
	
}


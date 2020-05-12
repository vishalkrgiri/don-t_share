package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.entity.Seat;
import com.cg.entity.SeatState;
import com.cg.entity.Show;
import com.cg.exception.IllegalSeatStateChangeException;
import com.cg.exception.NullPropertyException;

@Service
public interface SeatService {

	public Seat getSeat(Integer id);
	
	public SeatState getSeatStatus(Integer id);
	
	public Double getSeatPrice(Integer id);
	
	public Show getShow(Integer id);
	
	public Customer getCustomer(Integer id) throws NullPropertyException;
	
	public void BlockSeat(Integer id) throws IllegalSeatStateChangeException;
	
	public void unBlockSeat(Integer id) throws IllegalSeatStateChangeException;
	
	public void bookSeat(Integer id);
	
	public void unBookSeat(Integer id);
	
	public List<Seat> selectSeats(List<Integer> seats);
	
	public void blockSeats(List<Seat> seats);
	
	public void unBlockSeats(List<Seat> seats);

	public void bookSeats(List<Seat> seats);
}
package com.cg.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.UniversalDao;
import com.cg.entity.Customer;
import com.cg.entity.Seat;
import com.cg.entity.SeatState;
import com.cg.entity.Show;
import com.cg.exception.IllegalSeatStateChangeException;
import com.cg.exception.NullPropertyException;
@Service
public class SeatServiceImpl implements SeatService{

	@Autowired
	UniversalDao<Seat> dao;
	
	
	/********
	*Method name 			getSeat
	*Parameters				seatId (Integer)
	*description			This method gets the seat if we give seat id
	 * @throws				 NullPropertyException
	*@Returns   			Returns Seat type
	*********/
	@Override
	public Seat getSeat(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	/********
	*Method name 			getSeatStatus
	*Parameters				seatId (Integer)
	*description			This method gets the seatStatus if we give seat id
	 * @throws				 NullPropertyException
	*@Returns   			Returns Seat Status (SeatState)
	*********/
	@Override
	public SeatState getSeatStatus(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).getSeatStatus();
	}

	/********
	*Method name 			getSeatPrice
	*Parameters				seatId (Integer)
	*description			This method gets the seat price if we give the seat id
	 * @throws				 NullPropertyException
	*@Returns   			Returns Double
	*********/
	@Override
	public Double getSeatPrice(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).getSeatPrice();
	}

	/********
	*Method name 			getShow
	*Parameters				seatId (Integer)
	*description			This method gets the show details if we give seat id
	 * @throws				 NullPropertyException
	*@Returns   			Returns Show
	*********/
	@Override
	public Show getShow(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).getShow();
	}

	/********
	*Method name 			getCustomer
	*Parameters				seatId (Integer)
	*description			This method gets the customer who booked the seat if we give seat id
	 * @throws				 NullPropertyException0
	*@Returns   			Returns Customer type
	*********/
	@Override
	public Customer getCustomer(Integer id) throws NullPropertyException {
		// TODO Auto-generated method stub
		Customer customer=dao.findById(id).getCustomer();
		if(customer==null)
		{
			throw new NullPropertyException("Customer is not assigned to the seat");
		}
		return  customer;
	}

	
	/********
	*Method name 			BlockSeat
	*Parameters				seatId (Integer)
	*description			This method blocks the given seat it it is not blocked
	 * @throws				 IllegalSeatStateChangeException
	*@Returns   			none
	*********/
	@Override
	public void BlockSeat(Integer id) throws IllegalSeatStateChangeException {
		// TODO Auto-generated method stub
		Seat seat=dao.findById(id);
		if(seat.getSeatStatus()!=SeatState.AVAILABLE)
		{
			throw new IllegalSeatStateChangeException("Seat is not available for blocking it is already"+seat.getSeatStatus());
		}
		seat.setSeatStatus(SeatState.BLOCKED);
		dao.update(seat);

		
	}

	
	/********
	*Method name 			unBlockSeat
	*Parameters				seatId (Integer)
	*description			This method unblocks the given seat it it is not blocked
	* @throws				IllegalSeatStateChangeException
	*@Returns   			none
	*********/
	@Override
	
	public void unBlockSeat(Integer id) throws IllegalSeatStateChangeException {
		// TODO Auto-generated method stub
		Seat seat=dao.findById(id);
		if(seat.getSeatStatus()!=SeatState.BLOCKED)
		{
			throw new IllegalSeatStateChangeException("Seat is not available for unblocking it is already"+seat.getSeatStatus());
		}
		seat.setSeatStatus(SeatState.AVAILABLE);
		dao.update(seat);	
	}

	/********
	*Method name 			BookSeat
	*Parameters				seatId (Integer)
	*description			This method books the given seat it it is not blocked
	* @throws				IllegalSeatStateChangeException
	*@Returns   			none
	*********/
	@Override
	public void bookSeat(Integer id) {
		// TODO Auto-generated method stub
		Seat seat=dao.findById(id);
		seat.setSeatStatus(SeatState.BOOKED);
		dao.update(seat);
		
	}

	/********
	*Method name 			selectSeats
	*Parameters				seatId (Integer[])
	*description			This method gives the list of seats if we give array of seatId
	* @throws				EntityNotFoundException
	*@Returns   			none
	*********/
	@Override
	public List<Seat> selectSeats(List<Integer> seats) {
		// TODO Auto-generated method stub
		
		List<Seat> seatsList=null;
		for (Iterator iterator = seats.iterator(); iterator.hasNext();) {
			Integer seatid = (Integer) iterator.next();
			seatsList.add(dao.findById(seatid));
		}
		
		return seatsList;
	}

	
	/********
	*Method name 			BlockSeats
	*Parameters				List of Seats
	*description			This method blocks the given seats
	* @throws				IllegalSeatStateChangeException
	*@Returns   			none
	*********/
	@Override
	public void blockSeats(List<Seat> seats) {
		// TODO Auto-generated method stub
		for (Iterator iterator = seats.iterator(); iterator.hasNext();) {
			Seat seat = (Seat) iterator.next();
			seat.setSeatStatus(SeatState.BLOCKED);
			dao.update(seat);	
		}
		
		
	}

	/********
	*Method name 			unBlockSeats
	*Parameters				List of Seats
	*description			This method unblocks the given seats
	* @throws				IllegalSeatStateChangeException
	*@Returns   			none
	*********/
	@Override
	public void unBlockSeats(List<Seat> seats) {
		// TODO Auto-generated method stub
		for (Iterator iterator = seats.iterator(); iterator.hasNext();) {
			Seat seat = (Seat) iterator.next();
			seat.setSeatStatus(SeatState.AVAILABLE);
			dao.update(seat);	
		}
		
	}

	
	/********
	*Method name 			BookSeats
	*Parameters				List of Seats
	*description			This method books the given seats
	* @throws				IllegalSeatStateChangeException
	*@Returns   			none
	*********/
	@Override
	public void bookSeats(List<Seat> seats) {
		// TODO Auto-generated method stub
		for (Iterator iterator = seats.iterator(); iterator.hasNext();) {
			Seat seat = (Seat) iterator.next();
			seat.setSeatStatus(SeatState.BOOKED);
			dao.update(seat);	
		}
		
	}

	/********
	*Method name 			BlockSeats
	*Parameters				List of Seats
	*description			This method unbooks the given seats
	* @throws				IllegalSeatStateChangeException
	*@Returns   			none
	*********/
	@Override
	public void unBookSeat(Integer id) {
		// TODO Auto-generated method stub
		Seat seat=dao.findById(id);
		seat.setSeatStatus(SeatState.AVAILABLE);
		dao.update(seat);
	}

}
package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Screen;
import com.cg.entity.Seat;
import com.cg.exception.IllegalSeatStateChangeException;
import com.cg.service.SeatService;
//import com.mysql.cj.protocol.x.ResultMessageListener;

@RestController
@CrossOrigin(origins="localhost:4200")
public class SeatController {
	
	@Autowired
	SeatService service;
	
	
	/********
	*Method name 			getSeat
	*Parameters				SeatId(Integer)
	*description			returns the seat of given id
	*@Returns   			Returns Seat ith given id
	*HTTP-MethodType 		Get
	*url					/seat/{id}
	*********/
	@GetMapping(value="seat/{id}")
	public Seat getSeat(@PathVariable Integer id)
	{
		return service.getSeat(id);
	}
	
	
	/********
	*Method name 			bookSeats
	*Parameters				SeatId(Integer[])
	*description			Books the seats with given Id
	*@Returns   			Returns Response Entity Weather Booking is Done or Not String
	*HTTP-MethodType 		Patch
	*url					/bookSeats
	*********/
	@PatchMapping(value="bookSeats")
	public ResponseEntity<String> bookSeats(@RequestBody Integer[] id)
	{
		for (Integer integer : id) {
			service.bookSeat(integer);
		}
		
		return ResponseEntity.ok("Booking done");
	}
	
	
	
	/********
	*Method name 			blockSeats
	*Parameters				SeatId(Integer[])
	*description			Blocks the seats with given Id
	 * @throws IllegalSeatStateChangeException 
	*@Returns   			Returns Response Entity Weather Blocking is Done or Not String
	*HTTP-MethodType 		Patch
	*url					/bookSeats
	*********/	
	@PatchMapping(value="blockSeats")
	public ResponseEntity<String> blockSeat(@RequestBody Integer[] id) throws IllegalSeatStateChangeException
	{
		for (Integer integer : id) {
			service.BlockSeat(integer);
		}
		return ResponseEntity.ok("Blocking done");
	}
	
	/********
	*Method name 			unblockSeats
	*Parameters				SeatId(Integer[])
	*description			unblock the seats with given Id
	 * @throws IllegalSeatStateChangeException 
	*@Returns   			Returns Response Entity Weather blockking is Done or Not (String)
	*HTTP-MethodType 		Patch
	*url					/unblockSeats
	*********/
	@PatchMapping(value="unblockSeats")
	public ResponseEntity<String> unblockSeat(@RequestBody Integer[] id) throws IllegalSeatStateChangeException
	{
		for (Integer integer : id) {
			service.unBlockSeat(integer);
		}
		return ResponseEntity.ok("Booking done");
	}
	
	
	/********
	*Method name 			cancelSeats
	*Parameters				SeatId(Integer[])
	*description			Cancels the seats with given Id
	*@Returns   			Returns Response Entity Weather Cancelling is Done or Not. (String)
	*HTTP-MethodType 		Patch
	*url					/bookSeats
	*********/
	@PatchMapping(value="cancelSeats")
	public ResponseEntity<String> cancelSeat(@RequestBody Integer[] id)
	{
		for (Integer integer : id) {
			service.unBookSeat(integer);
		}
		return ResponseEntity.ok("cancelling done");
	}
	

}
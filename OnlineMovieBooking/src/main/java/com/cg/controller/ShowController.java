package com.cg.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Seat;
import com.cg.entity.Show;
import com.cg.service.ShowService;

@RestController
@CrossOrigin(origins="localhost:4200")
public class ShowController {

	@Autowired
	ShowService service;
	

	/********
	*Method name 			getShow
	*Parameters				ShowId(Integer)
	*description			Gets the Show with the id
	*@Returns   			Returns show with thw given Id(Show)
	*HTTP-MethodType 		Get
	*url					/show/{id}
	*********/
	@GetMapping(value="show/{id}")
	public Show getShow(@PathVariable Integer id,HttpServletResponse response)
	{
		Show show;
		show = service.getShow(id);
		return show;
	}
	

	/********
	*Method name 			getOnlySeats
	*Parameters				ShowId(Integer)
	*description			Gets the seats of the show with the id
	*@Returns   			Returns the list of seats of show
	*HTTP-MethodType 		Get
	*url					/show/{id}/seats
	*********/
	@GetMapping(value="show/{id}/seats")
	public List<Seat> getOnlySeats(@PathVariable Integer id,HttpServletResponse response) throws NullPointerException, EntityNotFoundException
	{
		Show show = null;
		show = service.getShow(id);
		return show.getSeats();
	}
	
	
}
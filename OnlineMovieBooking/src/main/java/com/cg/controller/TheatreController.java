package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Theatre;
import com.cg.service.TheatreService;


@CrossOrigin(origins="localhost:4200")
@RestController
public class TheatreController {

	
	@Autowired
	TheatreService theatreservice;
	
	/********
	*Method name 			getTheatresAndShows
	*Parameters				city(String) movieId(Integer)
	*description			Gets the theatres and shows of city with the movie
	*@Returns   			Returns List of Theatres
	*HTTP-MethodType 		Get
	*url					/theatres/{city}/{movieId}
	*********/
	@GetMapping("theatres/{city}/{movieId}")
	public List<Theatre> getTheatresAndShows(@PathVariable("city") String city,@PathVariable("movieId") Integer movieId)
	{
		
		return theatreservice.getTheatresByCityAndMovie(city, movieId);
	
	}
}
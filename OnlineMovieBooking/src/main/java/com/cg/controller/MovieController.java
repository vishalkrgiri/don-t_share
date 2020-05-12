package com.cg.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Movie;
import com.cg.entity.Theatre;
import com.cg.exception.NullPropertyException;
import com.cg.service.MovieService;
import com.cg.service.TheatreService;

import net.bytebuddy.asm.Advice.Return;

@CrossOrigin(origins="localhost:4200")


@RestController
public class MovieController {

	@Autowired
	MovieService movieservice;

	
	/********
	*@throws NullPropertyException 
	 * @Returns   			Set of Movies
	*Parameters				CityName(String)
	*description			returns the movies that are active in the city
	*Method name 			getMovies
	*throws					{@link NullPropertyException}
	*HTTP-MethodType 		Get
	*********/
	
	@GetMapping(value="{city}")
	public Set<Movie> getMovies(@PathVariable String city) throws NullPropertyException
	{
		return movieservice.getMoviesByCity(city);
	}

	
	
}
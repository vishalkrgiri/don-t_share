package com.cg.service;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Movie;
import com.cg.entity.Theatre;
import com.cg.exception.NullPropertyException;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	TheatreService theatreservice;
	
	
	/********
	*Method name 			getMoviesByCity
	*Parameters				cityName (String)
	*description			This method gets the Set of movies running currently in the city
	 * @throws				 NullPropertyException 
	*@Returns   			Returns set of movie
	*********/
	@Override
	public Set<Movie> getMoviesByCity(String city) throws NullPropertyException {
		// TODO Auto-generated method stub
		List<Theatre> theatres=theatreservice.getTheatresByCity(city);
		Set<Movie> movies=new HashSet<Movie>();

		for (Theatre theatre : theatres) {
			movies.addAll(theatre.getListOfMovies());
		}

		if(movies==null)
		{
			throw new NullPropertyException("Currently no movies are running in theatres of city"+city);
		}
		return movies;
	}

}
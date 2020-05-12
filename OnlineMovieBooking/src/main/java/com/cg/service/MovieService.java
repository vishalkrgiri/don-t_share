package com.cg.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.cg.entity.Movie;
import com.cg.exception.NullPropertyException;

@Service
public interface MovieService {
	
	public Set<Movie> getMoviesByCity(String city) throws NullPropertyException;

}
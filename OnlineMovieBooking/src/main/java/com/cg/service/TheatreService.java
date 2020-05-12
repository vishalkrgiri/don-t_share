package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Theatre;
@Service
public interface TheatreService {

	public List<Theatre> getAllTheatres();
	
	public List<Theatre> getTheatresByCity(String city);
	
	public List<Theatre> getTheatresByCityAndMovie(String city,Integer movieId);
	
}
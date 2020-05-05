package com.movie.dao;

import java.util.List;

import com.movie.entities.Show;


public interface IShowDao {
	
	public List<Show> findActiveShows();
}

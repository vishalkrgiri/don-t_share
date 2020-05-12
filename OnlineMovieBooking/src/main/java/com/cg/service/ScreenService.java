package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Screen;
import com.cg.entity.Show;
import com.cg.entity.Theatre;
import com.cg.exception.NullPropertyException;

@Service
public interface ScreenService {

	public Screen getScreen(Integer id);
	
	public String getscreenName(Integer id) throws NullPropertyException;
	
	public String getTheatreName(Integer id) throws NullPropertyException;
	
	public List<Show> getListOfShows(Integer id) throws NullPropertyException;
	
	public List<Screen> getAllScreens();
	
	public int getHeight(Integer id) throws NullPropertyException;
	
	public int getWidth(Integer id) throws NullPropertyException;
	
	public Theatre getTheatre(Integer id) throws NullPropertyException;
	
	
}
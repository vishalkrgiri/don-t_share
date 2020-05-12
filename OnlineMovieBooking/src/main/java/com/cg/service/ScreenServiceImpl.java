package com.cg.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.UniversalDao;
import com.cg.entity.Screen;
import com.cg.entity.Show;
import com.cg.entity.Theatre;
import com.cg.exception.NullPropertyException;

@Service
public class ScreenServiceImpl implements ScreenService{

	@Autowired
	UniversalDao<Screen> dao;

	/********
	*Method name 			getScreen
	*Parameters				screenId (Integer)
	*description			This method gets the Screen with the id
	 * @throws				 EnttityNotFoundException
	*@Returns   			Returns Screen
	*********/
	@Override
	public Screen getScreen(Integer id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		Screen screen=dao.findById(id);
		if(screen==null)
		{
			throw new EntityNotFoundException("Theare is no screen with id"+id);
		}
		return screen;
	}
	
	
	/********
	*Method name 			getScreenName
	*Parameters				screenId (Integer)
	*description			This method gets the Name of the screen if we give screen id
	 * @throws				 NullPropertyExceptionException
	*@Returns   			Returns String (screen name)
	*********/
	@Override
	public String getscreenName(Integer id) throws NullPropertyException {
		// TODO Auto-generated method stub
		String name=dao.findById(id).getScreenName();
		if(name==null)
		{
			throw new NullPropertyException("screen name is not available");
		}
		return name;
	}

	/********
	*Method name 			getTheatreName
	*Parameters				screenId (Integer)
	*description			This method gets the Name of the theatre if we give screen id
	 * @throws				 NullPropertyException
	*@Returns   			Returns String (screen name)
	*********/
	@Override
	public String getTheatreName(Integer id) throws NullPropertyException {
		// TODO Auto-generated method stub
		Theatre theatre=dao.findById(id).getTheatre();
		if(theatre==null)
		{
			throw new NullPropertyException("Seems screen is not attached to the theatre");
		}
		
		return theatre.getTheatreName();
	}

	/********
	*Method name 			getListOfShows
	*Parameters				screenId (Integer)
	*description			This method gets the List Of Shows in the screen if we give screen id
	 * @throws				 NullPropertyException
	*@Returns   			Returns List Of Show type
	*********/
	@Override
	public List<Show> getListOfShows(Integer id) throws NullPropertyException {
		// TODO Auto-generated method stub
		List<Show> shows=dao.findById(id).getShow();
		if(shows==null)
		{
			throw new NullPropertyException("No shows present in the screen");
			
		}
		return shows;
		
	}

	/********
	*Method name 			getHeight
	*Parameters				screenId (Integer)
	*description			This method gets the Height of the screen
	 * @throws				 NullPropertyException
	*@Returns   			Returns int  type
	*********/
	@Override
	public int getHeight(Integer id) throws NullPropertyException{
		// TODO Auto-generated method stub
		int height=dao.findById(id).getHallHeight();
		if(height==0)
		{
			throw new NullPropertyException("Propery HallHeight is 0");
		}
		return height;
	}

	/********
	*Method name 			getWidth
	*Parameters				screenId (Integer)
	*description			This method gets the Width of the screen
	 * @throws				 NullPropertyException
	*@Returns   			Returns int type
	*********/
	@Override
	public int getWidth(Integer id) throws NullPropertyException{
		// TODO Auto-generated method stub
		int width=dao.findById(id).getHallWidth();
		if(width==0)
		{
			throw new NullPropertyException("Property HallWidth is 0");
		}
		return width;
	}

	/********
	*Method name 			getTheatre
	*Parameters				screenId (Integer)
	*description			This method gets the Theatre of Screen
	 * @throws				 NullPropertyException
	*@Returns   			Returns Theatre type
	*********/
	@Override
	public Theatre getTheatre(Integer id) throws NullPropertyException{
		// TODO Auto-generated method stub
		Theatre theatre=dao.findById(id).getTheatre();
		if(theatre==null)
		{
			throw new NullPropertyException("Theatre is Null, screen is not attached to any theatre");
		}
		return theatre;
	}

	/********
	*Method name 			getAllScreens
	*description			This method gets the List Of all screens in the database
	 * @throws				 NullPointerException
	*@Returns   			Returns List Of Screen Type
	*********/
	@Override
	public List<Screen> getAllScreens() throws NullPointerException{
		// TODO Auto-generated method stub
		List<Screen> screens=dao.findAll();
		if(screens==null)
		{
			throw new NullPointerException("No screens available in database");
		}
		return screens;
	}

}
package com.cg.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Screen;
import com.cg.entity.Show;
import com.cg.entity.Theatre;
import com.cg.service.ScreenService;
import com.cg.service.TheatreService;

@CrossOrigin(origins="localhost:4200")
@RestController
public class ScreenController {

	@Autowired
	ScreenService service;
	
	@Autowired
	TheatreService theatreservice;
	
	/********
	*Method name 			getScreen
	*Parameters				ScreenId(Integer)
	*description			returns the screen with the given id
	*@Returns   			Returns Screen with the id given, if exists
	*HTTP-MethodType 		Get
	*url					/screen/id
	*********/
	@GetMapping(value="screen/{id}")
	public Screen getScreen(@PathVariable Integer id)
	{
		Screen screen=service.getScreen(id);
		return screen;
	}
	
	
	/********
	*Method name 			getShows
	*Parameters				ScreenId(Integer)
	*description			returns the shows in the screen
	*@Returns   			Returns List of Shows present in screen with the id given, if exists
	*HTTP-MethodType 		Get
	*url					/screen/{id}/shows
	*********/
	@GetMapping(value="screen/{id}/shows")
	public List<Show> getShows(@PathVariable Integer id)
	{
		return service.getScreen(id).getShow();
	}
	
	
	/********
	*Method name 			getScreens
	*description			returns the list of screens
	*@Returns   			Returns List of Screens present in the database 
	*HTTP-MethodType 		Get
	*url					/screens
	*Deprecated Reason		It has some null pointer exception issues sometimes mostly avoid using it
	*********/
	@Deprecated
	@GetMapping(value="screens")
	public List<Screen> getScreens()
	{
		return service.getAllScreens();
	}
	
	
}
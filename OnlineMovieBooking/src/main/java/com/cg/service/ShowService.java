package com.cg.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Screen;
import com.cg.entity.Seat;
import com.cg.entity.Show;
import com.cg.entity.Theatre;
import com.cg.exception.NullPropertyException;

import javax.persistence.EntityNotFoundException;

@Service
public interface ShowService {

	public String getShowName(Integer id) throws EntityNotFoundException;
	
	public Show getShow(Integer id) throws EntityNotFoundException;
	
	public LocalDateTime getShowStartTime(Integer id) throws EntityNotFoundException,NullPropertyException;
	
	public LocalDateTime getShowEndTime(Integer id) throws EntityNotFoundException,NullPropertyException;
	
	public List<Seat> getSeats(Integer id) throws EntityNotFoundException,NullPropertyException;

	public Screen getScreen(Integer id) throws EntityNotFoundException;
	
	public Theatre getTheatre(Integer id) throws EntityNotFoundException;

}
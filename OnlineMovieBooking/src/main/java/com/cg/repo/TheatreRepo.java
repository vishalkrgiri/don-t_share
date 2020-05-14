package com.cg.dao;

import java.util.List;

import com.cg.entity.Theatre;

public interface TheatreDao {

	List<Theatre> getTheatresByCity(String city);

}

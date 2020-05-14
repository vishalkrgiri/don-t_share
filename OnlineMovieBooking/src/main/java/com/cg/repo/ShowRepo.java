package com.cg.dao;

import java.util.List;

import com.cg.entity.Show;

public interface ShowDao {

	List<Show> findActiveShows();

}

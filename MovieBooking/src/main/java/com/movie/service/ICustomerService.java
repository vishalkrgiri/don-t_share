package com.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.IUniversalDao;
import com.movie.entities.Customer;

@Service
public interface ICustomerService {


	public Customer getCustomer(Integer id);
	
	
}

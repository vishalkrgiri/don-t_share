package com.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.IUniversalDao;
import com.movie.entities.Customer;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	IUniversalDao<Customer> customerDao;

	@Override
	public Customer getCustomer(Integer id) {
		// TODO Auto-generated method stub
		return customerDao.findById(id);
	}
	
	
	
}

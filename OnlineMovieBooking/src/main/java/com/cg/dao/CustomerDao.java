package com.cg.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;

import com.cg.entity.Admin;
import com.cg.entity.Booking;
import com.cg.entity.Customer;
import com.cg.entity.Ticket;
import com.cg.entity.User;
@Repository
@Transactional
public class CustomerDao implements UniversalDao<Customer> {

	@PersistenceContext
	private EntityManager em;
	
	
	public CustomerDao() {
		super();
	}


	@Override
	public void save(Customer entityObject) {
		// TODO Auto-generated method stub
		em.persist(entityObject);
	}

	@Override
	public Customer findById(Integer id) throws NullPointerException{
		// TODO Auto-generated method stub
		Customer customer = em.find(Customer.class,id);
		if(customer==null)
		{
			throw new EntityNotFoundException("Customer not found");
		}
		return customer;
	}

	@Override
	public Customer remove(Integer id) {
		// TODO Auto-generated method stub
		Customer customer=findById(id);
		if(customer!=null)
		{
			em.remove(customer);
		}
		return null;
		
	}

	@Override
	public Customer remove(Customer entityObject) {
		// TODO Auto-generated method stub
		em.remove(entityObject);
		return entityObject;
	}

	@Override
	public Customer update(Integer id, Customer entityObject) {
		// TODO Auto-generated method stub
		Customer customer=findById(id);
		if(customer==null)
		{
			System.out.println("Update error: no such entity exists first save then do this update operation");
			return null;
		}
		
		return em.merge(entityObject);
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("From Customer customer");
		System.out.println(q.getResultList()==null);
		return (List<Customer>) q.getResultList();
	}

	@Override
	public Customer update(Customer entityObject) {
		// TODO Auto-generated method stub
		Customer customer=findById(entityObject.getUserId());
		if(customer==null)
		{
			System.out.println("update error: no such entity exists first save then do this update operation");
			return null;
		}
		
		return em.merge(entityObject);
	}

}
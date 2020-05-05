package com.movie.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.movie.entities.Customer;

@Repository
@Transactional
public class CustomerDao implements IUniversalDao<Customer> {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void save(Customer entityObject) {
		// TODO Auto-generated method stub
		em.persist(entityObject);
	}

	@Override
	public Customer findById(Integer id) throws EntityNotFoundException{
		// TODO Auto-generated method stub
		Customer c=em.find(Customer.class, id);
		if(c==null)
		{
			throw new EntityNotFoundException("Customer with id : "+id+" is not found");
		}
		return c;
	}

	@Override
	public Customer remove(Integer id) {
		// TODO Auto-generated method stub
		Customer c=findById(id);
		em.remove(c);
		return c;
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
		
		Customer c=findById(id);
		
		return em.merge(entityObject);
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("from Customer customer");
		return q.getResultList();
	}

	@Override
	public Customer update(Customer entityObject) {
		// TODO Auto-generated method stub
		return em.merge(entityObject);
	}

	@Override
	public Integer saveAndgetId(Customer entityObject) {
		// TODO Auto-generated method stub
		em.merge(entityObject);
		em.flush();
		return entityObject.getUserId();
	}

}

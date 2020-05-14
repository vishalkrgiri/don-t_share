package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.Admin;
import com.cg.entity.Booking;
@Transactional
@Repository
public class BookingDao implements UniversalDao<Booking> {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void save(Booking entityObject) {
		// TODO Auto-generated method stub
		em.persist(entityObject);
	}

	@Override
	public Booking findById(Integer id) throws NullPointerException,EntityNotFoundException {
		// TODO Auto-generated method stub
		Booking booking=em.find(Booking.class,id);
		if(booking==null)
		{
			throw new EntityNotFoundException("Booking Not found");
		}
		return booking;
	}

	@Override
	public Booking remove(Integer id) {
		// TODO Auto-generated method stub
		Booking booking=findById(id);
		if(booking!=null)
		{
			em.remove(booking);
		}
		return null;
	}

	@Override
	public Booking remove(Booking entityObject) {
		// TODO Auto-generated method stub
		 em.remove(entityObject);
		return entityObject;
	}

	@Override
	public Booking update(Integer id, Booking entityObject) {
		// TODO Auto-generated method stub
		Booking bookingid=findById(id);
		if(bookingid==null)
		{
			System.out.println("update error: no such entity exists first save then do this update operation");
			return null;
		}
		
		return em.merge(entityObject);
	}

	@Override
	public List<Booking> findAll() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("From Booking booking");
		return q.getResultList();
	}

	@Override
	public Booking update(Booking entityObject) {
		// TODO Auto-generated method stub
		Booking booking=findById(entityObject.getBookingId());
		if(booking==null)
		{
			System.out.println("update error: no such entity exists first save then do this update operation");
			return null;
		}
		
		return em.merge(entityObject);
	}

}
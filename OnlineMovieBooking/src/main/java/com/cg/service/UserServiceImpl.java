package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.Admin;
import com.cg.entity.Movie;
import com.cg.entity.User;
import com.cg.entity.UserType;

@Repository
@Transactional
public class UserDao implements UniversalDao<User>{

	@PersistenceContext
	private EntityManager em;


	@Override
	public void save(User entityObject) {
		// TODO Auto-generated method stub
		em.persist(entityObject);
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		User user= em.find(User.class,id);
		if(user==null)
		{
			throw new EntityNotFoundException();
		}
		return user;
	}

	@Override
	public User remove(Integer id) {
		// TODO Auto-generated method stub
		User user=findById(id);
		if(user!=null)
		{
			em.remove(user);
		}
		return null;
	}

	@Override
	public User remove(User entityObject) {
		// TODO Auto-generated method stub
		em.remove(entityObject);
		return entityObject;
	}

	@Override
	public User update(Integer id, User entityObject) {
		// TODO Auto-generated method stub
		User user=findById(id);
		if(user==null)
		{
			System.out.println("Update error: no such entity exists first save then do this update operation");
			return null;
		}
		
		return em.merge(entityObject);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		
		Query q=em.createQuery("From User user");
		System.out.println(q.getResultList()==null);
		return (List<User>) q.getResultList();
	}

	@Override
	public User update(User entityObject) {
		// TODO Auto-generated method stub
		User user=findById(entityObject.getUserId());
		if(user==null)
		{
			System.out.println("update error: no such entity exists first save then do this update operation");
			return null;
		}
		
		return em.merge(entityObject);
	}


}
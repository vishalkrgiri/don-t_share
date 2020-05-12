package com.cg.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.Admin;

@Repository
@Transactional
public class AdminDao implements UniversalDao<Admin> {

	@PersistenceContext
	private EntityManager em;


	@Override
	public void save(Admin entityObject) {
		// TODO Auto-generated method stub
		em.persist(entityObject);
	}

	@Override
	public Admin findById(Integer id) throws NullPointerException {
		// TODO Auto-generated method stub
		Admin admin= em.find(Admin.class,id);
		if(admin==null)
		{
			throw new EntityNotFoundException("Admin not found");
		}
		return admin;
	}

	@Override
	public Admin remove(Integer id) throws NullPointerException {
		// TODO Auto-generated method stub
		Admin admin=findById(id);
		if(admin!=null)
		{
			em.remove(admin);
		}
		System.out.println("The entity u want to delete is not found");
		return null;
	}

	@Override
	public Admin remove(Admin entityObject) {
		// TODO Auto-generated method stub
		em.remove(entityObject);
		return entityObject;
	}

	@Override
	public Admin update(Integer id, Admin entityObject) {
		// TODO Auto-generated method stub
		Admin admin=findById(id);
		if(admin==null)
		{
			System.out.println("update error: no such entity exists first save then do this update operation");
			return null;
		}
		
		return em.merge(entityObject);
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("From Admin admin");
		return q.getResultList();
	}

	@Override
	public Admin update(Admin entityObject) {
		// TODO Auto-generated method stub
		Admin admin=findById(entityObject.getUserId());
		if(admin==null)
		{
			System.out.println("update error: no such entity exists first save then do this update operation");
			return null;
		}
		
		return em.merge(entityObject);
	}

}
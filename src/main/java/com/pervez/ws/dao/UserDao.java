package com.pervez.ws.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pervez.ws.domain.User;



@Repository
public class UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public User fetchUserById(int id){
		
		Session session = sessionFactory.getCurrentSession();
		
		User user = (User)session.createQuery("from User where id = :id").setParameter("id", id).uniqueResult();
		
		return user;
	}
	
}

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
		
		//select * from user where id = 1
		
		User user = (User)session.createQuery("from User where id = :id").setParameter("id", id).uniqueResult();
		
		return user;
	}
	
	public void addUser(User user){
		
		Session session = sessionFactory.getCurrentSession();
		
		session.save(user);
	}
	
	public void updateUser(User user){
		Session session = sessionFactory.getCurrentSession();
		
		
		
		session.saveOrUpdate(user);
	}
	
}

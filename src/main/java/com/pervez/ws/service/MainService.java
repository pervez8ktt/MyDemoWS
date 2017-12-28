package com.pervez.ws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pervez.ws.dao.UserDao;
import com.pervez.ws.model.MyResponse;
import com.pervez.ws.model.User;

@Service
@Transactional
public class MainService {

	@Autowired
	UserDao userDao;
	
	
	public MyResponse getMyResponse(String name, String lastName){
		List<User> users = new ArrayList<User>();
		
		MyResponse myResponse = new MyResponse();
		
		User user = new User();
		
		user.setName(name);
		user.setLastname(lastName);
		
		users.add(user);
		
		User user1 = new User();
		
		user1.setName(name+"1");
		user1.setLastname(lastName+"2");
		
		users.add(user1);
		
		myResponse.setStatus(true);
		myResponse.setMessage("Success!");
		myResponse.setObject(users);
		
		return myResponse;
	}


	public User fetchUserById(int id) {
		
		MyResponse myResponse = new MyResponse();
		
		com.pervez.ws.domain.User user = userDao.fetchUserById(id);
		
		User userModel = new User();
		
		userModel.setId(user.getId());
		userModel.setName(user.getName());
		
		return userModel;
	}
	
	public void addUser(com.pervez.ws.domain.User user){
		userDao.addUser(user);
	}
	
	public void updateUserName(com.pervez.ws.domain.User user){
		
	}
	
}

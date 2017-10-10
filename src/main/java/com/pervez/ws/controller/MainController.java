package com.pervez.ws.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pervez.ws.model.MyResponse;
import com.pervez.ws.model.User;

@Controller
public class MainController {

	Gson gson = new Gson();
	
	@RequestMapping(value="/helloworld", method=RequestMethod.POST)
	public @ResponseBody String helloWorld(@RequestParam String name, @RequestParam String lastname){
		
		MyResponse myResponse = new MyResponse();
		
		List<User> users = new ArrayList<User>();
		
		User user = new User();
		
		user.setName(name);
		user.setLastname(lastname);
		
		users.add(user);
		
		User user1 = new User();
		
		user1.setName(name+"1");
		user1.setLastname(lastname+"2");
		
		users.add(user1);
		
		myResponse.setStatus(true);
		myResponse.setMessage("Success!");
		myResponse.setObject(users);
		
		return gson.toJson(myResponse);
	}
	
	
	
	
}

package com.pervez.ws.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pervez.ws.model.MyResponse;
import com.pervez.ws.model.User;
import com.pervez.ws.service.MainService;

@Controller
@RequestMapping(value="/another")
public class AnotherController {

	@Autowired
	MainService mainService;
	
	Gson gson = new Gson();
	
	@RequestMapping(value="/helloworld", method=RequestMethod.POST)
	public @ResponseBody String helloWorld(@RequestParam String name, @RequestParam String lastname, @RequestParam String json){
		
		// Is this data is valid?
		
		User user = gson.fromJson(json, User.class);
		
		// Call Service method for business logic
		MyResponse myResponse = mainService.getMyResponse(name, lastname);
		
		
		myResponse.getObject().add(user);
		myResponse.setMessage("another");
		
		//Is return data from service is valid or not
		
		//return desired object
		return gson.toJson(myResponse);
	}
	
	
	@RequestMapping(value="/fetchuser", method=RequestMethod.POST)
	public @ResponseBody String helloWorld(@RequestParam String id){
		
		
		User user = mainService.fetchUserById(Integer.parseInt(id));
		
		return gson.toJson(user);
	}
	
	
	@RequestMapping(value="/adduser", method=RequestMethod.POST)
	public @ResponseBody String helloWorld(@ModelAttribute com.pervez.ws.domain.User user){
		
		try{
			mainService.addUser(user);
			return "Success";
		}catch(Exception e){
			return "Fail";
		}
		
	}
}

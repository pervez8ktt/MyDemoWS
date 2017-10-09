package com.pervez.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pervez.ws.model.MyResponse;

@Controller
public class MainController {

	Gson gson = new Gson();
	
	@RequestMapping(value="/helloworld", method=RequestMethod.POST)
	public @ResponseBody String helloWorld(@RequestParam String name, @RequestParam String lastname){
		
		MyResponse myResponse = new MyResponse();
		myResponse.setName(name);
		myResponse.setLastname(lastname);
		
		return gson.toJson(myResponse);
	}
	
	
	
	
}

package com.pervez.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping(value="/helloworld", method=RequestMethod.GET)
	public @ResponseBody String helloWorld(){
		return "hello World";
	}
	
}

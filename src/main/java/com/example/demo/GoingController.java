package com.example.demo;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/going")
public class GoingController {
		
	@Autowired
	PostRepository postRepository;
	
	@RequestMapping(value="/going", method=RequestMethod.POST)
	public String index(@CookieValue(value = "pplGoing", defaultValue="0") Long pplGoing, HttpServletResponse response){
		
				
		
		return "index";
	}	
}

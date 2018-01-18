package com.example.demo;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetingController {
	
	private static final String template ="Hello %s";
	private final AtomicLong counter = new AtomicLong();
	@Autowired
	PostRepository postRepository;
	
	
	//Rather than relying on a view technology to perform server-side rendering 
	//of the greeting data to HTML, this RESTful web service controller 
	//simply populates and returns a Greeting object. The object data will be 
	//written directly to the HTTP response as JSON.	
	
	@RequestMapping("/rest_test")
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name){
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
		
		
	}
	
	@RequestMapping("/get_all")
	public List<Post> getAllPosts(){
		return postRepository.findAllByOrderByDateDescTimeDesc();
	}
	
	
}

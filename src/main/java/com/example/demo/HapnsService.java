package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HapnsService {
	
	@Autowired
	PostRepository postRepository;
	
	public List<Post> getPosts(String display) {		
		
		if(display.equals("today")){
			return postRepository.findAllToday();
		}
		if(display.equals("thisWeek")){
			return postRepository.findAllThisWeek();
		}
		if(display.equals("all")){
			return postRepository.findAllByOrderByDateDescTimeDesc();
		}
		return null;
	}	
}

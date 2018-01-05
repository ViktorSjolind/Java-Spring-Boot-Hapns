package com.example.demo;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ChristmasController {
	
	@Autowired
	PostRepository postRepository;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Model model){
		/*
		List<Post> postList = postRepository.findAll();		
		postList.addAll(postRepository.findAllByDate());
		*/
		
		List<Post> postList = postRepository.findAllByOrderByDateDesc();
		
		if(postList != null){
			model.addAttribute("posts", postList);
		}		
		
		return "index";
	}	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String login(@CookieValue(value="pressed", defaultValue = "")String pressed, Long id, HttpServletResponse response){		
		System.out.println("id: " + id.toString() + "\n" + pressed);
		//every cookie is a pseudo array
		// id_id_id_id
		// id's denote which posts the user have set to going
		
		Utilities utilities = new Utilities();
		List pressedList = utilities.getListFromPseudoArray(pressed);		
		
		if(!pressedList.contains(id.toString())){
			Post post = postRepository.findOne(id);
			System.out.println(post.getId());
			System.out.println(post.getGoing());
			int temp = post.getGoing();
			temp++;
			post.setGoing(temp);
			System.out.println("new: " + post.getGoing());
			postRepository.save(post);
			
			Cookie cookie = new Cookie("pressed", pressed+"_"+id.toString());
			response.addCookie(cookie);
		
		}
		return "redirect:/";
	}

}

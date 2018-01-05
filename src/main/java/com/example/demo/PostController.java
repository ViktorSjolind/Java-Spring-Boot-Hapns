package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {
	
	@Autowired
	PostRepository postRepository;
	
	@RequestMapping(value="/createPost", method=RequestMethod.GET)
	public String createPostForm(Model model){
		model.addAttribute("post", new Post());
		return "createPost";
	}
	
	@RequestMapping(value="/createPost", method=RequestMethod.POST)
	public String createPost(@ModelAttribute Post post, String dateInputString, String timeInputString){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUser = authentication.getName();		
		post.setUser(currentUser);
		
		System.out.println("***date from form? " + dateInputString + "\n" + timeInputString);
		
		
		/*
		 You can only bind Model Objects which can be defined with simple types.
		 when the object serialized from the client side to the server , 
		 It has no knowledge about the complex types(like java.time.LocalDate) 
		 unless they are expressed interms of simple types.
		 */
		
		Utilities utilities = new Utilities();				
		post.setDate(utilities.getDateFromString(dateInputString));
		post.setTime(utilities.getTimeFromString(timeInputString));
		
		postRepository.save(post);
		return "redirect:/";
	}
	
	
}

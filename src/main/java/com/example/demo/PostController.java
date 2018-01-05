package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String createPost(@ModelAttribute Post post){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUser = authentication.getName();
		
		post.setUser(currentUser);
		postRepository.save(post);
		return "redirect:/";
	}
	
	
}

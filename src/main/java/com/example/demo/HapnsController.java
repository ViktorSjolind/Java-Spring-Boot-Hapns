package com.example.demo;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HapnsController {
	
	@Autowired
	PostRepository postRepository;	
	@Autowired
	Utilities utilities;
	@Autowired
	HapnsService hapnsService;
	
	@RequestMapping(value={"/"}, method=RequestMethod.GET)
	public String index(){	
		/*
		List<Post> postList = postRepository.findAllByOrderByDateDescTimeDesc();		
		if(postList != null){
			model.addAttribute("posts", postList);
		}				
		*/
		//return "redirect:/index?display=all";
		
		return "index";
	}	
	
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String indexOption(@RequestParam("display") String display, Model model){		
		List<Post> postList = null;
		
		if(display == null || display.isEmpty()){
			return "redirect:/index?display=all";
		}else{
			postList = hapnsService.getPosts(display);
		}		
				
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
	public String login(@CookieValue(value="pressed", defaultValue = "")String pressed, Long id, HttpServletResponse response, String displayOption){		
		//System.out.println("id: " + id + "\n" + pressed);
		
		//every cookie is a pseudo array
		// _id_id_id
		// id's denote which posts the user have set to going		
		
		List pressedList = utilities.getListFromPseudoArray(pressed);		
		
		if(!pressedList.contains(id.toString())){
			Post post = postRepository.findOne(id);
			int temp = post.getGoing();
			temp++;
			post.setGoing(temp);
			postRepository.save(post);			
			Cookie cookie = new Cookie("pressed", pressed+"_"+id.toString());
			response.addCookie(cookie);
		
		}
		return "redirect:/";
	}

}

package com.pizzalover.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pizzalover.dao.CategoryDAO;
import com.pizzalover.dao.UserDAO;
import com.pizzalover.domain.Category;
import com.pizzalover.domain.User;

@Controller
public class UserController {
	
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired UserDAO userDAO;
	@Autowired User user;
	@Autowired CategoryDAO categoryDAO;
	@Autowired Category category;
	
	@RequestMapping("registerUser")
	public ModelAndView registerUser(@ModelAttribute User user){
		
		ModelAndView mv= new ModelAndView("/Home");
		  if (userDAO.getByUserId(user.getUser_id())==null)
		  {
			  user.setRole("ROLE_USER");
			  userDAO.save(user);
			  mv.addObject("message", " Register Successful , " +user.getUser_id());
			  
			  
		  }
		  
		  else
		  {
			  mv.addObject("message", " Sign Up Failed..... Please try again ");

	}
		return mv;
	}
	
	
	@RequestMapping("/validate")
	public ModelAndView Login(@RequestParam("user_id") String user_id, @RequestParam("password") String password)
{
log.debug("Starting of validate");
	ModelAndView mav= new ModelAndView("/Home");
	User user=userDAO.getByUserId(user_id);
	if(userDAO.validate(user_id, password)==true)
	{
	 userDAO.getByUserId(user_id);
	 mav.addObject("user_id",user_id);
	 
	 mav.addObject("message", " Welcome Pizza Lover , " + user_id);
	 
	 mav.addObject("categoryList",categoryDAO.list());
	 mav.addObject("category", category);
	 
	 
		//check wheter role is admin or user.
	 
	 if(user.getRole().equals("ROLE_ADMIN"))
	 {
		 log.debug("IsAdmin True "+user.getRole());
		 mav.addObject("isAdmin", "true");
	 }
	 else
	 {
		 log.debug("IsAdmin False "+user.getRole());
		 mav.addObject("isAdmin", "false");
	 }
	 
	}
	
	else
	{
		 mav.addObject("message", " Invalid credentials... Please try again ");
		
	}
	return  mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

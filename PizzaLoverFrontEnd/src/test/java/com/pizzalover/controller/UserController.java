package com.pizzalover.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pizzalover.dao.UserDAO;
import com.pizzalover.domain.User;

@Controller
public class UserController {
	
	@Autowired UserDAO userDAO;
	@Autowired User user;
	
	
	@RequestMapping("registerUser")
	public ModelAndView registerUser(@ModelAttribute User user)
	{
		
		  ModelAndView mv= new ModelAndView("/Home");
		  if (userDAO.getByUserId(user.getUser_id())==null)
		  {
			  userDAO.save(user);
			  mv.addObject("message", "Welcone to Pizza Lover" +user.getUser_id());
			  
			  
		  }
		  
		  else
		  {
			  mv.addObject("message", " Sign Up Failed..... Please try again ");
		  }
		return mv;
	}

	@RequestMapping("/validate")
	public ModelAndView Login(@RequestParam("username") String id, @RequestParam ("password") String password)
	{
	
		ModelAndView mvv= new ModelAndView("/Home");
		if(userDAO.validate(user.getUser_id(), password)==true)
		{
			userDAO.getByUserId(user.getUser_id());
			mvv.addObject("message", "Welcone to Pizza Lover" +user.getUser_id());
		}
		
		else
		{
			mvv.addObject("message", "Invalid credentials... Please try again");
			
		}
		return mvv;
	}
	
}

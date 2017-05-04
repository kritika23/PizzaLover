package com.pizzalover.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	 
	private static  Logger log = LoggerFactory.getLogger(AdminController.class);
	
	
	@RequestMapping("/manageCategories")
	public ModelAndView manageCategories()
	{
		log.debug("Starting of the manage Categories");
		ModelAndView mv= new ModelAndView("Home");
		
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");
		log.debug("Ending of the manage Categories");

		return mv;
	}
	
	@RequestMapping("/manageSuppliers")
	public ModelAndView manageSuppliers()
	{
		log.debug("Starting of the manage Suppliers");

		ModelAndView mv= new ModelAndView("Home");
		
		mv.addObject("isAdminClickedSuppliers", "true");
		mv.addObject("isAdmin", "true");
		log.debug("Ending of the manage Suppliers");

		return mv;
	}
	
	
	
	@RequestMapping("/manageProducts")
	public ModelAndView manageProducts()
	{
		log.debug("Starting of the manage Products");

		ModelAndView mv= new ModelAndView("Home");
		
		mv.addObject("isAdminClickedProducts", "true");
		mv.addObject("isAdmin", "true");
		log.debug("Ending of the manage Products");

		return mv;
	}
	
	
	
}

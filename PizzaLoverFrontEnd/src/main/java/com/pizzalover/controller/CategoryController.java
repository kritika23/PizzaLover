package com.pizzalover.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pizzalover.dao.CategoryDAO;
import com.pizzalover.domain.Category;

@Controller
public class CategoryController {

	private static  Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	
	@Autowired CategoryDAO categoryDAO;
	@Autowired Category category;
	@Autowired HttpSession session;
	 
	@RequestMapping("manage_category_add")
	public ModelAndView createCategory(@RequestParam("category_id")String category_id, @RequestParam("name")String name, @RequestParam("description")String description)
	{
		log.debug("Starting of Manage Category Add");
		category.setCategory_id(category_id);
		category.setName(name);
		category.setDescription(description);
		
		
		ModelAndView mv= new ModelAndView("/Home");
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");
		
		if(categoryDAO.getByCategoryId(category_id)!=null)
		{
			log.debug("Category Id exists");
			mv.addObject("message", "Category already exists eith the id" +category_id);
			return mv;
		}
		else
		{
			log.debug("Creation of new Category Id");
			categoryDAO.save(category);
			mv.addObject("message", "Successfully created the category");
		}
			
			
			session.setAttribute("categoryList",categoryDAO.list());
			session.setAttribute("category", category);
			log.debug("Ending of the Manage Category Add ");
			
			return mv;
		}

	
	@RequestMapping("/manage_category_delete/{category_id}")
	public ModelAndView deleteCategory(@PathVariable("category_id") String category_id)
	{
	Category category=	categoryDAO.getByCategoryId(category_id);
		log.debug("Starting of the detetion of category");
		ModelAndView mv=new ModelAndView("forward:/manageCategories");
		if(categoryDAO.delete(category))
		{
			log.debug("Starting of the detetion of category succesfully");
			mv.addObject("message", "Sucessfully deleted category");
		}
		else
		{
			log.debug("Ending of the detetion of category failed");
			mv.addObject("message", "Unable to delete the category");
		}
	log.debug("Ending of the detetion of category");
	return mv;
}
}

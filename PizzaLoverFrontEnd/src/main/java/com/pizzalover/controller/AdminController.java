package com.pizzalover.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pizzalover.dao.CategoryDAO;
import com.pizzalover.dao.ProductDAO;
import com.pizzalover.dao.SupplierDAO;
import com.pizzalover.domain.Category;
import com.pizzalover.domain.Product;
import com.pizzalover.domain.Supplier;

@Controller
public class AdminController {
	 
	@Autowired Category category;
	@Autowired CategoryDAO categoryDAO;
	@Autowired SupplierDAO supplierDAO;
	@Autowired Supplier supplier;
	@Autowired ProductDAO productDAO;
	@Autowired Product product;
	
	private static  Logger log = LoggerFactory.getLogger(AdminController.class);
	
	
	@RequestMapping("/manageCategories")
	public ModelAndView manageCategories()
	{
		log.debug("Starting of the manage Categories");
		ModelAndView mv= new ModelAndView("Home");
		
		mv.addObject("categoryList", categoryDAO.list());
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
		mv.addObject("supplierList", supplierDAO.list());
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
		mv.addObject("productList", productDAO.list());
		mv.addObject("categoryList", categoryDAO.list());
		mv.addObject("supplierList", supplierDAO.list());
		mv.addObject("isAdminClickedProducts", "true");
		mv.addObject("isAdmin", "true");
		log.debug("Ending of the manage Products");

		return mv;
	}
	
	
	
}

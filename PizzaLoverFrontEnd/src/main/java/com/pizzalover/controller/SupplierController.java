package com.pizzalover.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pizzalover.dao.CategoryDAO;
import com.pizzalover.dao.ProductDAO;
import com.pizzalover.dao.SupplierDAO;
import com.pizzalover.domain.Category;
import com.pizzalover.domain.Product;
import com.pizzalover.domain.Supplier;

@Controller
public class SupplierController {
	
	
	
private static  Logger log = LoggerFactory.getLogger(SupplierController.class);
	

	@Autowired SupplierDAO supplierDAO;
	@Autowired Supplier supplier;
	@Autowired Product product;
	@Autowired ProductDAO productDAO;

	@Autowired HttpSession session;
	 
	//@RequestMapping("/manage_supplier_add")
	@GetMapping("/manage_supplier_add")
	public ModelAndView createSupplier(@RequestParam("supplier_id")String supplier_id, @RequestParam("address")String address,@RequestParam("contact")String contact, @RequestParam("name")String name)
	{
		log.debug("Starting of Manage Supplier Add");
	supplier.setSupplier_id(supplier_id);
	supplier.setAddress(address);
	supplier.setContact(contact);
	supplier.setName(name);
	
		
		
		ModelAndView mv= new ModelAndView("/Home");
		mv.addObject("isAdminClickedSupplier", "true");
		mv.addObject("isAdmin", "true");
		
		if(supplierDAO.getBySupplierId(supplier_id)!=null)
		{
			log.debug("Supplier Id exists");
			mv.addObject("message", "Supplier already exists with the id" +supplier_id);
			return mv;
		}
		else
		{
			log.debug("Creation of new Supplier Id");
			supplierDAO.save(supplier);
			mv.addObject("message", "Successfully created the supplier");
		}
			
			
			session.setAttribute("supplierList",supplierDAO.list());
			session.setAttribute("supplier", supplier);
			log.debug("Ending of the Manage Supplier Add ");
			
			return mv;
		}

	

	//@RequestMapping("/manage_supplier_delete/{supplier_id}")
	@GetMapping("/manage_supplier_delete/{supplier_id}")
	public ModelAndView deleteSupplier(@PathVariable("supplier_id") String supplier_id)
	{
		log.debug("Starting of the deletion of supplier");
		log.debug("You are going to delete :" +supplier_id);
		
		ModelAndView mv=new ModelAndView("redirect:/manageSuppliers");
	    if(productDAO.getAllProductsBySupplierId(supplier_id).size()!=0)
        {
	    	log.debug("Few products are there under this supplier. You cannot delete this Id");
        	mv.addObject("message", "Few products are there under this supplier. You cannot delete this Id");
        	return mv;
        }
	Supplier supplier=supplierDAO.getBySupplierId(supplier_id);
	  if(supplierDAO.delete(supplier))
		{
			log.debug("Deletion of supplier succesfully");
			mv.addObject("message", "Sucessfully deleted supplier");
		}
		else
		{
			log.debug(" Detetion of supplier failed");
			mv.addObject("message", "Unable to delete the supplier");
		}
	log.debug("Ending of the deletion of supplier");
	return mv;
}
	
	
	
	

	@RequestMapping("/manage_supplier_edit/{supplier_id}")

		public ModelAndView editSupplier(@PathVariable("supplier_id") String supplier_id)
		{
		
		 log.debug("Starting of method Edit supplier");
		 log.debug("Going to Edit of Supplier :" +supplier_id);
		 
		 supplier=supplierDAO.getBySupplierId(supplier_id);
		
			
			ModelAndView mv= new ModelAndView("redirect:/manageSuppliers");
			mv.addObject("selectedSupplier", supplier);
			
			session.setAttribute("selectedSupplier", supplier);
			log.debug("Ending of the method editSupplier ");
			return mv;
			}
	
	
	
	
//	@RequestMapping("/manage_supplier_edit/manage_supplier_update")
	@PostMapping("/manage_supplier_update")
	public ModelAndView updateSupplier(@RequestParam("supplier_id")String supplier_id, @RequestParam("address")String address,@RequestParam("contact")String contact, @RequestParam("name")String name)
	{
		log.debug("Starting of Manage Update Supplier");
		supplier.setSupplier_id(supplier_id);
		supplier.setAddress(address);
		supplier.setContact(contact);
		supplier.setName(name);

		
		
		ModelAndView mv= new ModelAndView("redirect:/manageSuppliers");
		/*mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");*/
		
		if(supplierDAO.getBySupplierId(supplier_id)==null)
		{
			log.debug("Supplier Id exists");
			mv.addObject("message", "Supplier does not exists with the id :" +supplier_id);
			return mv;
		}
		else
		{
			log.debug("Updation of new Supplier Id");
			supplierDAO.update(supplier);
			mv.addObject("message", "Successfully updated the supplier");
		}
			
			
			/*session.setAttribute("categoryList",categoryDAO.list());
			session.setAttribute("category", category);*/
			log.debug("Ending of the Manage Update Supplier");
			
			return mv;
		}
	
	
}

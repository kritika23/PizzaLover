package com.pizzalover.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pizzalover.dao.CategoryDAO;
import com.pizzalover.dao.ProductDAO;
import com.pizzalover.dao.SupplierDAO;
import com.pizzalover.domain.Category;
import com.pizzalover.domain.Product;
import com.pizzalover.domain.Supplier;
import com.pizzalover.util.FileUtil;
import com.pizzalover.util.Util;



@Controller
public class ProductController {
	
private static  Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired ProductDAO productDAO;
	@Autowired Product product;
	@Autowired CategoryDAO categoryDAO;
	@Autowired Category category;
	@Autowired SupplierDAO supplierDAO;
	@Autowired Supplier supplier;

	
	
	 private String path   ="D://DT//Kritika23//PizzaLoverFrontend//src//main//webapp//WEB-INF//resources//images";
	@Autowired HttpSession session;
	 
	

	
/*	@RequestMapping("/all/product/viewproduct")
	public ModelAndView viewAllProducts(@RequestParam("description")String description, @RequestParam("name")String name,@RequestParam("price")String price)
	{
	  product= productDAO.getByProductId(description);
	  product= productDAO.getByProductId(price);
	  product=productDAO.getByProductName(name);
	  
	  

		ModelAndView mv= new ModelAndView("redirect:/Home");
		mv.addObject("selectedProduct", product);
		
		session.setAttribute("selectedProduct", product);
		return mv;
		
	}*/

	
	
	
	@RequestMapping("/search_product/{search_string}")
	public ModelAndView getAllProductBySearchString(@PathVariable("search_string")
		String search_string)
	{
	  List<Product> products=productDAO.getSimilarProducts(search_string);
	  ModelAndView mv= new ModelAndView("/home");
	  
	  if(products.isEmpty())
	  {
		  mv.addObject("msg", "No products are available with the search text :" +search_string );
	  }
	  else
	  {
		  mv.addObject("productList", products);
	  }
  
	  return mv;
	
	}
 	@RequestMapping(value = "/manage_products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		log.debug("Starting of the method listProducts");
		model.addAttribute("product", new Product());
		/*model.addAttribute("category", new Category());
		model.addAttribute("supplier", new Supplier());*/
		model.addAttribute("productList", this.productDAO.list());
		/*model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("supplierList", this.supplierDAO.list());*/
		model.addAttribute("isAdminClickedProducts", "true");
		log.debug("Ending of the method listProducts");
		return "/home";
	}
	 
	//@RequestMapping("/manage_product_add")
	@RequestMapping(value = "/manage_product_add")
	public ModelAndView createProduct(@RequestParam("image") MultipartFile file,@RequestParam("product_id")String product_id, @RequestParam("category_name")String category_name,@RequestParam("description")String description, @RequestParam("name")String name,@RequestParam("price")String price, @RequestParam("supplier_name")String supplier_name, @RequestParam("type")String type)
	{
		log.debug("Starting of Manage Product Add");
		Category category=categoryDAO.getByCategoryName(category_name);
		Supplier supplier=supplierDAO.getBySupplierName(supplier_name);
		log.debug("supplier id selected category id ",supplier.getSupplier_id());
		product.setProduct_id(product_id);
		product.setCategory_id(category.getCategory_id());
		product.setDescription(description);
		product.setName(name);
		product.setPrice(price);
		product.setSupplier_id(supplier.getSupplier_id());
		product.setType(type);
	product.setImage(file);
		ModelAndView mv= new ModelAndView("Home");
		mv.addObject("isAdminClickedProducts", "true");
		mv.addObject("isAdmin", "true");
		
		if(productDAO.getByProductId(product_id)!=null)
		{
			log.debug("Product Id exists");
			mv.addObject("message", "Product already exists with the id" +product_id);
			return mv;
		}
		else
		{
			log.debug("Creation of new Product Id");
			productDAO.save(product);
			mv.addObject("message", "Successfully created the product");
		}
		
		MultipartFile image=product.getImage();
		if(image!=null && !image.isEmpty()){
		Path path=Paths.get(""+product.getProduct_id()+"D://DT//Kritika23//PizzaLoverFrontend//src//main//webapp//WEB-INF//resources//images/"+product.getProduct_id()+".png");

		try {
			image.transferTo(new File(path.toString()));
		} catch (IllegalStateException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		}
		return mv;

		}

	
	
	
	//@RequestMapping("/manage_product_delete/{product_id}")
	@GetMapping("/manage_product_delete/{product_id}")
	public ModelAndView deleteProduct(@PathVariable("product_id") String product_id)
	{
		log.debug("Starting of the deletion of product");
		log.debug("You are going to delete :" +product_id);
		
		ModelAndView mv=new ModelAndView("redirect:/manageProducts");
		
		Product product=productDAO.getByProductId(product_id);
	  if(productDAO.delete(product))
		{
			log.debug("Deletion of product succesfully");
			mv.addObject("message", "Sucessfully deleted product");
		}
		else
		{
			log.debug(" Deletion of Product failed");
			mv.addObject("message", "Unable to delete the product");
		}
	log.debug("Ending of the deletion of product");
	return mv;
}
	
	
	
	

	@RequestMapping("/manage_product_edit/{product_id}")

		public ModelAndView editProduct(@PathVariable("product_id") String product_id)
		{
		
		 log.debug("Starting of method Edit product");
		 log.debug("Going to Edit of product :" +product_id);
		 
		 product=productDAO.getByProductId(product_id);
		
			
			ModelAndView mv= new ModelAndView("redirect:/manageProducts");
			mv.addObject("selectedProduct", product);
			
			session.setAttribute("selectedProduct", product);
			log.debug("Ending of the method editProduct ");
			return mv;
			}
	
	
	
	
//	@RequestMapping("/manage_product_edit/manage_product_update")
	@PostMapping("/manage_product_update")
	public ModelAndView updateProduct(@RequestParam("product_id")String product_id, @RequestParam("category_id")String category_id,@RequestParam("description")String description, @RequestParam("name")String name,@RequestParam("price")String price, @RequestParam("supplier_id")String supplier_id, @RequestParam("type")String type)
	{
		log.debug("Starting of Manage Update Product");
		product.setProduct_id(product_id);
		product.setCategory_id(category_id);
		product.setDescription(description);
		product.setName(name);
		product.setPrice(price);
		product.setSupplier_id(supplier_id);
		product.setType(type);
		
	
		
		
		ModelAndView mv= new ModelAndView("redirect:/manageProducts");
		mv.addObject("isAdminClickedProduct", "true");
		mv.addObject("isAdmin", "true");
		
		if(productDAO.getByProductId(product_id)==null)
		{
			log.debug("Product Id exists");
			mv.addObject("message", "Product does not exists with the id :" +product_id);
			return mv;
		}
		else
		{
			log.debug("Updation of new Product Id");
			productDAO.update(product);
			mv.addObject("message", "Successfully updated the product");
		}
			
			
			session.setAttribute("productList",productDAO.list());
			session.setAttribute("product", product);
			log.debug("Ending of the Manage Update Product");
			
			return mv;
		}
	
	

}

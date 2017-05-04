package com.pizzalover.controller;

import java.util.List;
import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pizzalover.dao.CategoryDAO;
import com.pizzalover.dao.ProductDAO;
import com.pizzalover.domain.Category;
import com.pizzalover.domain.Product;
import com.pizzalover.test.CategoryDAOTestCase;

@Controller
public class HomeController {
	
	@Autowired HttpSession session;
	@Autowired Category category;
	@Autowired CategoryDAO categoryDAO;
//	@Autowired Product product;
//	@Autowired ProductDAO productDAO;


	@RequestMapping("/")
	public String goToHome(Model model)

	{
		List<Category> categoryList= categoryDAO.list();
		session.setAttribute("categoryList", categoryList);
		session.setAttribute("category", category);

		
		/*List<Product> productList= productDAO.list();
		session.setAttribute("productList", productList);
		session.setAttribute("product", product);

*/		
		
		return "Home";
	}

	@RequestMapping("Home")
	public String loadHome(Model model)

	{
		return "Home";
	}

	@RequestMapping("LoginPage")
	public String LoginPage(Model model) {
		model.addAttribute("isUserClickedLogin", "true");

		return "Home";
	}

	@RequestMapping("LogoutPage")
	public String LogoutPage(Model model) {
		model.addAttribute("isUserClickedLogout", "true");
      session.invalidate();
		return "Home";
	}
	@RequestMapping("RegistrationPage")
	public String RegistrationPage(Model model) {
		model.addAttribute("isUserClickedRegisteration", "true");

		return "Home";
	}
}
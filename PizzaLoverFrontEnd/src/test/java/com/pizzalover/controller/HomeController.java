package com.pizzalover.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class HomeController {

	//http://localhost:8080/ShoppingCartFrontEnd/

	@RequestMapping("/")
	public  String goToHome(Model model)
	
	{
		return "Home";
	}
	@RequestMapping("Home")
	public  String loadHome(Model model)
	
	{
		return "Home";
	}
	
	@RequestMapping("LoginPage")
	public String LoginPage(Model model)
	{
		model.addAttribute("isUserClickedLogin", "true");
	
		return "Home";
	}
	
	@RequestMapping("RegistrationPage")
	public String RegistrationPage(Model model)
	{
		model.addAttribute("isUserClickedRegisteration", "true");
		
		return "Home";
	}
}
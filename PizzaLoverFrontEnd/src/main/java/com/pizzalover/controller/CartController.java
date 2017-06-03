package com.pizzalover.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.pizzalover.dao.CartDAO;
import com.pizzalover.dao.ProductDAO;
import com.pizzalover.domain.Cart;
import com.pizzalover.domain.Product;

/*@Controller
public class CartController {
	
	@GetMapping("cart/add/{product_id}")
		public ModelAndView addToCart(@PathVariable("product_id") String product_id)
		{
		
		ModelAndView mv=new ModelAndView("redirect:/");
			return mv;
		
		
		}

}*/


import java.sql.Date;
import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
	Logger log = LoggerFactory.getLogger(CartController.class);
	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private Cart cart;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String myCart(Model model) {
		log.debug("Starting of the method cart");
		model.addAttribute("cart", cart);
		// get the logged-in user id 
		//if you added the loggedInUserID in session
		String loggedInUserid = (String) session.getAttribute("loggedInUserID");

		/*if (loggedInUserid == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			loggedInUserid = auth.getName();
			Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)   auth.getAuthorities();
			authorities.contains("ROLE_USER");
			
		}*/
		if(loggedInUserid!=null)
		{

		int cartSize = cartDAO.list(loggedInUserid).size();

		if (cartSize == 0) {
			model.addAttribute("errorMessage", "You do not have any products in your Cart");
		} else {
			model.addAttribute("cartList", cartDAO.list(loggedInUserid));
			model.addAttribute("totalAmount", cartDAO.getTotalAmount(loggedInUserid));
			model.addAttribute("displayCart", "true");
			model.addAttribute("cart",cart);

		}
		
		}
		log.debug("Ending of the method cart");
		return "/Home";
	}

	// For add and update myCart both
	@RequestMapping(value ="/cart/add/{id}", method = RequestMethod.GET)
	public ModelAndView addToCart(@PathVariable("id") String id) {
		log.debug("Starting of the method addToCart");
		// get the product based on product id
		Product product = productDAO.getByProductId(id);
		cart.setPrice(Integer.parseInt(product.getPrice()));
		cart.setProduct_name(product.getName());
		String loggedInUserid = (String) session.getAttribute("loggedInUserID");
		if (loggedInUserid == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			loggedInUserid = auth.getName();
		}
		cart.setUser_id(loggedInUserid);
		//It is not required if you given default value while creating the table
		cart.setStatus("New"); // Status is New. Once it is Purschaed/order
		                     // changed to 'P'  O
		cart.setQuantity(1);
		cart.setDateAdded( new Date(  System.currentTimeMillis()) );
		
		//To get sequence number, you can do programmatically in DAOImpl
		//myCart.setId(ThreadLocalRandom.current().nextLong(100, 1000000 + 1));

		//check same product is added earlier.
	/*	
		if(cartDAO.getCart(loggedInUserid, myCart.getProductName()) !=null)
		{
			//increase the quantity and update it.
			 int presentQuantity = cartDAO.getQuantity(loggedInUserid, myCart.getProductName());
					 myCart.setQuantity(presentQuantity + 1);	 
			 cartDAO.update(myCart);
					 
		}
		else
		{
			cartDAO.save(myCart);
			
			
		}*/
		cartDAO.save(cart);
	
		// return "redirect:/views/home.jsp";

		ModelAndView mv = new ModelAndView("redirect:/Home");
		mv.addObject("successMessage", " Successfuly add the product to cart");
		log.debug("Ending of the method addToCart");
		return mv;

	}

	
}

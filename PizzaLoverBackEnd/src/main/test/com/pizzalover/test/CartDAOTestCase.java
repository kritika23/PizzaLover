package com.pizzalover.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pizzalover.dao.CartDAO;
import com.pizzalover.domain.Cart;
import com.pizzalover.dao.ProductDAO;
import com.pizzalover.domain.Product;



public class CartDAOTestCase {
	
	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static CartDAO cartDAO;
	@Autowired static Cart cart;
	
	@Autowired static ProductDAO productDAO;
	@Autowired static Product product;
	
	private String createCartTestCase;
	 
	 
	 
		@BeforeClass
		public static void intialize() {
			context = new AnnotationConfigApplicationContext();
			context.scan("com.pizzalover");
			context.refresh();

			cartDAO = (CartDAO) context.getBean("cartDAO");
			cart = (Cart) context.getBean("cart");
			
			productDAO=(ProductDAO) context.getBean("productDAO");
			product=(Product) context.getBean("product");

		}
		
		
		
		@Test
			public void createCartTestCase(){

			product = productDAO.getByProductId("P_03");
			// cart.setCart_id(1);
			cart.setUser_id("ankita");
			cart.setPrice(350);
			cart.setProduct_name(product.getName());
			System.out.println(new Date());
		cart.setDateAdded(new Date());
	
		cart.setQuantity(5);
		cart.setStatus("New");
	
		
			boolean flag = cartDAO.save(cart);

			assertEquals("createCartTestCase",true, flag);
				
				
				
			}
	
}

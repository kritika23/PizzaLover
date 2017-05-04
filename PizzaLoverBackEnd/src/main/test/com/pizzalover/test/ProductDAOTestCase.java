package com.pizzalover.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pizzalover.dao.ProductDAO;
import com.pizzalover.domain.Category;
import com.pizzalover.domain.Product;

public class ProductDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static ProductDAO productDAO;
	@Autowired
	static Product product;

	@BeforeClass
	public static void intialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.pizzalover");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");
		product = (Product) context.getBean("product");

	}


@Test
	
	public void createProductTestCase() {
		
		product.setProduct_id("P_06");
		product.setName("Egg Pizza ");
		product.setDescription("This Egg Pizza is a pizza with lots of scrambled eggs,fries eggs and toppings of pizza.");
		product.setType("Small");
		product.setPrice("300");
		product.setCategory_id("C_06");		
        product.setSupplier_id("S_02");

	
		boolean flag = productDAO.save(product);

		assertEquals("createProductTestCase", true, flag);
	}




//@Test
public void updateProductTestCase() {
	
	product.setProduct_id("P_02");
	product.setName("Chunky Chicken Pizza ");
	product.setDescription("This Non-Veg Chicken Pizza is with combination of cheese,barbeque chicken, pepperoni and spicy toppings.");
	product.setType("Large");
	product.setPrice("800");
	product.setCategory_id("C_02");		
    product.setSupplier_id("S_03");


	boolean flag = productDAO.update(product);

	assertEquals("updateProductTestCase", true, flag);
}



}

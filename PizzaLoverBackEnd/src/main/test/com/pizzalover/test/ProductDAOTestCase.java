package com.pizzalover.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pizzalover.dao.ProductDAO;
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

	private String createProductTestCase;

	// @Test
	public void createProductTestCase() {

		product.setProduct_id("p-001");
		product.setName("Veg Chesse Pizza");
		product.setDescription("Tbjfkb");
		product.setType("Small");
		product.setPrice("450");

		boolean flag = productDAO.save(product);

		assertEquals("saveProductTestCase", true, flag);
	}

	@Test
	public void updateProductTestCase() {

		product.setProduct_id("P_001");
		product.setName("Veg Chesse Pizza");
		product.setDescription(
				"This Veg Chesse Pizza comes with thick crust of cheese and sauces and is filled with cheddar, parmesan and gouda. ");
		product.setType("Medium");
		product.setPrice("450");

		boolean flag = productDAO.save(product);

		assertEquals("saveProductTestCase", true, flag);
	}

}

package com.pizzalover.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pizzalover.dao.CategoryDAO;
import com.pizzalover.domain.Category;




public class CategoryDAOTestCase {
	
	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static CategoryDAO categoryDAO;
	@Autowired static Category category;
	
	
	@BeforeClass
	public static void intialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.pizzalover");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		category = (Category) context.getBean("category");

	}
	
	 private String createCategoryTestCase;
	 
	 @Test
		public void createCategoryTestCase() {
		 
		category.setCategory_id("C_01");
		category.setName("Veg Pizza");
		category.setDescription("Chesse");
		
		boolean flag = categoryDAO.save(category);

		assertEquals("saveCategoryTestCase", true, flag);
	}
	 }


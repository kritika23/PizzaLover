package com.pizzalover.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pizzalover.dao.UserDAO;
import com.pizzalover.domain.User;

public class UserDAOTestCase {

	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static UserDAO userDAO;
	@Autowired static User user;
	
	
	@BeforeClass
	public static void initalize(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.pizzalover");
		context.refresh();
		
		userDAO =(UserDAO)context.getBean("userDAO");
		
		user=(User)context.getBean("user");
		
	}

	private String createUserTestCase;
	
	@Test
	public void createUserTestCase(){
		
		user.setUser_id("kritika");
		user.setPassword("kri");
		user.setFname("Kritika");
		user.setLname("Poojari");
		user.setAdd("Mumbai");
		user.setNumber("9841521564");
		user.setRole("ROLE_ADMIN");
		user.setEmail("kritika@gmail.com");
	
		
		boolean flag=userDAO.save(user);
	
		assertEquals("createUserTestCase", true,flag);
	}
	//@Test
public void updateUserTestCase(){
		
		user.setUser_id("evan");
		user.setPassword("ev");
		user.setFname("Evan");
		user.setLname("Dsouza");
		user.setAdd("Mumbai");
		user.setNumber("987456123");
		user.setRole("ROLE_USER");
	
		
		boolean flag=userDAO.update(user);
	
		assertEquals("updateUserTestCase", true,flag);
	
		
}
}
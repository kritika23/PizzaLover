package com.pizzalover.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pizzalover.dao.SupplierDAO;
import com.pizzalover.domain.Supplier;

public class SupplierDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static SupplierDAO supplierDAO;
	@Autowired
	static Supplier supplier;

	@BeforeClass
	public static void intialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.pizzalover");
		context.refresh();

		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		supplier = (Supplier) context.getBean("supplier");

	}

	private String createSupplierTestCase;

	@Test
	public void createSupplierTestCase() {

		supplier.setSupplier_id("S_04");
		supplier.setName("Agarwal & Company");
		supplier.setContact("05215-564163");
		supplier.setAddress("Banglore");

		boolean flag = supplierDAO.save(supplier);

		assertEquals("saveSupplierTestCase", true, flag);
	}
}

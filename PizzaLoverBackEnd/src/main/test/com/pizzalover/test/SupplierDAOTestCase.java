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

		supplier.setSupplier_id("S_001");
		supplier.setName("Counter No.1");
		supplier.setContact("C-00201");
		supplier.setAddress("First Counter");

		boolean flag = supplierDAO.save(supplier);

		assertEquals("saveSupplierTestCase", true, flag);
	}
}

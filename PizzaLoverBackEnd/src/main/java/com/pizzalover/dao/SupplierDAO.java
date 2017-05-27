package com.pizzalover.dao;

import java.util.List;

import com.pizzalover.domain.Supplier;

public interface SupplierDAO {
	
	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public boolean delete(Supplier supplier);
	public List<Supplier> list();
	
	public Supplier getBySupplierId(String supplier_id);
	 
	public Supplier getBySupplierName(String name);
	

}

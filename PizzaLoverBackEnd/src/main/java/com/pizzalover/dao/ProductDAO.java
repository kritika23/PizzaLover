package com.pizzalover.dao;

import java.util.List;

import com.pizzalover.domain.Product;

public interface ProductDAO {
	
	public boolean save(Product product);
	public boolean update(Product product);
	public boolean delete(Product product);
	public List<Product> list();
	
	public Product getByProductId(String product_id);
	
	public Product getByProductName(String name);

	public List<Product> getAllProductsByCategoryId(String category_id);
}

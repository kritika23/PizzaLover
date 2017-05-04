package com.pizzalover.dao;

import java.util.List;

import com.pizzalover.domain.Category;

public interface CategoryDAO {
	
	public boolean save(Category category);
	public boolean update(Category category);
	public boolean delete(Category category);
	public List<Category> list();
		
	
	public Category getByCategoryId(String category_id);
	
	public Category getByCategoryName(String name);

}

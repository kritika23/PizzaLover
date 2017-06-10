package com.pizzalover.dao;

import java.util.List;

import com.pizzalover.domain.Cart;



public interface CartDAO {
	
	public List<Cart> list(String user_id);
	public Cart get(int id);

	public boolean save(Cart cart);
	public boolean update(Cart cart);
	public boolean delete(Cart Cart);

	

	public Long getTotalAmount(String id);
	
	public Cart getCart(String user_id, String product_name);
	
	public Integer getQuantity(String user_id, String product_name);
	

}

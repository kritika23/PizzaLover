package com.pizzalover.dao;

import java.util.List;

import com.pizzalover.domain.User;



public interface UserDAO  {

	public boolean save(User user);
	public boolean update(User user);
	public boolean delete(User user);
	public List<User> list();
	public User getByUserId(String user_id);
    public boolean validate(String user_id, String password);
    


	

}

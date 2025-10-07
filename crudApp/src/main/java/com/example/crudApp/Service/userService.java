package com.example.crudApp.Service;

import java.util.List;

import com.example.crudApp.Models.User;


public interface userService {
	
	public List<User> findAll();
	
	public User findById(int theId);
	
	public void save(User theContact);
	
	public void deleteById(int theId);

}

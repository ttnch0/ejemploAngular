package com.example.crudApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudApp.Models.User;
import com.example.crudApp.Repository.userRepository;

@Service
public class userServiceImpl implements userService{
	
	private userRepository userRep;
	
	@Autowired
	public userServiceImpl(userRepository theUserRep) {
		userRep = theUserRep;
	}

	@Override
	public List<User> findAll() {
		return userRep.findAll();
	}

	@Override
	public User findById(int theId) {
		Optional<User> result = userRep.findById(theId);
		
		User theUser = null;
		
		if (result.isPresent()) {
			theUser = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find user id - " + theId);
		}
		
		return theUser;
	}

	@Override
	public void save(User theUser) {
		userRep.save(theUser);
		
	}

	@Override
	public void deleteById(int theId) {
		userRep.deleteById(theId);
		
	}

}

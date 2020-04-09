package com.vinay.rest.webservices.restfulwebservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinay.rest.webservices.restfulwebservices.data.User;
import com.vinay.rest.webservices.restfulwebservices.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User save(User user) {
		return userRepo.save(user);
	}
	
	public User findOne(int id) {
		return userRepo.findById(id).orElse(null);
	}
	
	public User deleteUser(int id) {
		User user = userRepo.findById(id).orElse(null);
		userRepo.deleteById(id);
		return user;
	}
}

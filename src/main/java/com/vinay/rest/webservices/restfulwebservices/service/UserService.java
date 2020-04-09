package com.vinay.rest.webservices.restfulwebservices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vinay.rest.webservices.restfulwebservices.data.User;

@Service
public class UserService {
	
	private static List<User> users = new ArrayList<>();
	private static int usersCount = 3;
	
	static {
		users.add(new User(1, "Vinay", new Date()));
		users.add(new User(2, "Kumar", new Date()));
		users.add(new User(3, "Sudha", new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
	}
	
	public User deleteUser(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}

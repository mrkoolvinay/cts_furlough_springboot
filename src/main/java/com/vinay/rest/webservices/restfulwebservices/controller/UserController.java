package com.vinay.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vinay.rest.webservices.restfulwebservices.data.User;
import com.vinay.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.vinay.rest.webservices.restfulwebservices.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	// GET /users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userService.findAll();
	}

	// GET /users/{id} with HATEOAS
	/*@GetMapping("users/{id}")
	public EntityModel<User> findUserById(@PathVariable int id) throws MissingServletRequestParameterException {
		User user = userService.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("User not found with id" + id);
		}
		return new EntityModel<User>(user, linkTo(methodOn(UserController.class).retrieveAllUsers()).withRel("all-users"));
	}*/
	
	@GetMapping("users/{id}")
	public User findUserById(@PathVariable int id) throws MissingServletRequestParameterException {
		User user = userService.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("User not found with id" + id);
		}
		return user;
	}

	// POST /users
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		// return new ResponseEntity<>(userService.save(user),
		// HttpStatus.CREATED);
		User savedUser = userService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}
	
	// DELETE /users/{id}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userService.deleteUser(id);
		if (user == null) {
			throw new UserNotFoundException("User not Found for ID "+ id);
		}
		
	}
}

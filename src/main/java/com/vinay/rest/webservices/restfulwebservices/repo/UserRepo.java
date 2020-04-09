package com.vinay.rest.webservices.restfulwebservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinay.rest.webservices.restfulwebservices.data.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}

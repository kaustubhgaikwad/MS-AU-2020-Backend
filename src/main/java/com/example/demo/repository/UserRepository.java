package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.User;

@CrossOrigin(origins = "http://localhost:4200")
public interface UserRepository extends CrudRepository<User,Long> {

	User findByUsername(String name);
	
}

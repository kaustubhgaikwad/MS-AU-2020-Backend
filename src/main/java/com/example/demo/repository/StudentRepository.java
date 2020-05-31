package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.Student;
@CrossOrigin(origins = "http://localhost:4200")
public interface StudentRepository extends CrudRepository<Student,Long> {
	
	Optional<Student> findByEmailId(String email);

}

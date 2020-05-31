package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Optional<Student> getStudent(long id) {
		return studentRepository.findById(id);
	}
	
	public Optional<Student> getStudentByEmail(String email) {
		return studentRepository.findByEmailId(email);
	}
	
}

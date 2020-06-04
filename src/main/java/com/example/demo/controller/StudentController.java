package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/{id}")
	public Optional<Student> getStudent(@PathVariable("id") long id) {
		return studentService.getStudent(id);
	}
	
	@GetMapping("/email/{email}")
	public Optional<Student> getStudentByEmail(@PathVariable("email") String email) {
		return studentService.getStudentByEmail(email);
	}
	
	@GetMapping("/all")
	public List<Student> getAll(){
		return studentService.getAll();
	}
	
	@GetMapping("/score/{id}")
	public Optional<Student> getScore(@PathVariable("id") long id) {
		return studentService.getAssignmentMarks(id);
	}
	
	@PutMapping("/finalscore")
	public Student addScore(@RequestBody Student student) {
		studentService.CalculatePercentile();
		return studentService.addFinalScore(student);
	}
	@GetMapping("/calculatefinalScore")
	public Optional<Student> score() {
		System.out.println("inside score function");
		studentService.CalculatePercentile();
		System.out.println("calculate done");
		return studentService.getStudent(1);
	}
	
	

	
}

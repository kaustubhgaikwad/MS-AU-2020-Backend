package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.StudentAssignment;
import com.example.demo.service.AssessmentService;
import com.example.demo.service.StudentAssignmentService;
import com.example.demo.service.StudentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/studentassignments")
public class StudentAssignmentController {
	
	@Autowired
	StudentAssignmentService service;
	
	@Autowired
	StudentService studentservice;
	
	@Autowired
	AssessmentService assessmentservice;
	
	
	
	@GetMapping("/all")
	public List<StudentAssignment> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional<StudentAssignment> get(@PathVariable("id") long id) {
		return service.get(id);
	}
	
	@PostMapping("/add")
	public StudentAssignment addRecord(@RequestBody StudentAssignment _record)
	{
		String name = studentservice.getStudentByEmail(_record.getStudentEmail()).get().getName();
		_record.setStudentName(name);
		System.out.println("Inside Conroller Record added="+_record);
		return service.addRecord(_record);
	}
	
	@GetMapping("/{id}/{email}")
	public StudentAssignment getRecord(@PathVariable("id") long id,@PathVariable("email") String email) {
		String title= assessmentservice.get(id).get().getTitle();
		System.out.println("Title="+title);
		return service.getRecord(title,email);
	}
	
	@PutMapping("/{id}")
	public StudentAssignment update(@PathVariable("id") long id, @RequestBody StudentAssignment record) {
		Optional<StudentAssignment> data = service.get(id);
		if(data != null) {
			StudentAssignment update_record = data.get();
			update_record.setAssignmentDescription(record.getAssignmentDescription());
			update_record.setAssignmentSolution(record.getAssignmentSolution());
			update_record.setAssignmentTitle(record.getAssignmentTitle());
			update_record.setStudentEmail(record.getStudentEmail());
			update_record.setStudentName(record.getStudentName());
			return service.addRecord(update_record);
		}else {
			return null;
		}
	}
	
	@GetMapping("/all/{email}")
	public List<StudentAssignment> getByEmail(@PathVariable("email") String email) {
		return service.getByEmail(email);
	}

}

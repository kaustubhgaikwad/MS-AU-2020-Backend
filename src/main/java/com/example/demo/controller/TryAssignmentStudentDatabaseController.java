package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Assessment;
import com.example.demo.model.TryAssignmentStudentDatabase;
import com.example.demo.service.TryAssignmentStudentDatabaseService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/assignmentrecords")
public class TryAssignmentStudentDatabaseController {

	@Autowired
	TryAssignmentStudentDatabaseService service;
	
	@GetMapping("/all")
	public List<TryAssignmentStudentDatabase> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/add")
	public TryAssignmentStudentDatabase addRecord(@RequestBody TryAssignmentStudentDatabase _record)
	{
		return service.addRecord(_record);
	}
}

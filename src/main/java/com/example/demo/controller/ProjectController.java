package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Project;
import com.example.demo.service.ProjectService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	ProjectService service;
	
	@GetMapping("/{id}")
	public Project getByStudentId(@PathVariable("id") long id) {
		System.out.println("Id="+id);
		return service.getByStudentId(id); 
	}
	
	@PostMapping("/add")
	public Project add(@RequestBody Project project) {
		System.out.println("Inside Project Controller="+ project);
		return service.add(project);
	}
	
	@PutMapping("/update")
	public Project update(@RequestBody Project project) {
		return service.update(project.getId(), project);
	}

}

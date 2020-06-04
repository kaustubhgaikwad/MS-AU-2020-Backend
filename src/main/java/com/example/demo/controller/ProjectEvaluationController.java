package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProjectEvaluation;
import com.example.demo.service.ProjectEvaluationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/projectevaluation")
public class ProjectEvaluationController {

	@Autowired
	ProjectEvaluationService service;
	
	@PutMapping("/update")
	public ProjectEvaluation update(@RequestBody ProjectEvaluation record) {
		System.out.println(record);
		return service.update(record, record.getId());
	}
	
	@GetMapping("/get")
	public List<ProjectEvaluation> get() {
		return service.get();
	}
	
	@PostMapping("/add")
	public ProjectEvaluation add(@RequestBody ProjectEvaluation record) {
		return service.add(record);
		
	}
	
}

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

import com.example.demo.model.Weightage;
import com.example.demo.service.WeightageService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/weightage")
public class WeightageController {
	
	@Autowired
	WeightageService service;
	
	@GetMapping("/get")
	public List<Weightage> get() {
		return service.get();
	}
	
	@PutMapping("/update")
	public Weightage update(@RequestBody Weightage weightage) {
		System.out.println(weightage);
		return service.update(weightage);
	}
	
	@PostMapping("/add")
	public Weightage add(@RequestBody Weightage weightage) {
		
		return service.add(weightage);
	}
	
}

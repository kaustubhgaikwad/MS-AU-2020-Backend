package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Location;
import com.example.demo.service.StudentDetailsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/studentdetails")
public class StudentDetailsController {

	@Autowired
	StudentDetailsService service;
	
	@GetMapping("/details")
	public List<List<Location>> getDetails() {
		return service.getDetails();
	}
	
	
}

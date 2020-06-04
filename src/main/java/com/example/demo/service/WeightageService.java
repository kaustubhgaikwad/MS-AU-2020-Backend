package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Weightage;
import com.example.demo.repository.WeightageRepository;

@Service
public class WeightageService {
	
	@Autowired
	WeightageRepository repository;
	
	public Weightage update(Weightage weightage) {
		Weightage data = repository.findById(weightage.getId()).get();
		data.setAssignment(weightage.getAssignment());
		data.setProject(weightage.getProject());
		return repository.save(weightage);
	}
	public Weightage add(Weightage weightage) {
		return repository.save(weightage);
	}
	
	public List<Weightage> get() {
		return (List<Weightage>) repository.findAll();
	}

}

package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Assessment;
import com.example.demo.repository.AssessmentRepository;

@Service
public class AssessmentService {

	@Autowired
	AssessmentRepository assessmentRepository;

	public List<Assessment> getAll() {
		return (List<Assessment>) assessmentRepository.findAll();
	}

	public Optional<Assessment> getAssessment(long id) {
		return assessmentRepository.findById(id);
	}

	public Assessment add(Assessment assessment) {
		return assessmentRepository.save(assessment);
	}

	public void delete(long id) {
		 assessmentRepository.deleteById(id);
	}
	public Optional<Assessment> get(long id) {
		return assessmentRepository.findById(id);
	}
	
	
}

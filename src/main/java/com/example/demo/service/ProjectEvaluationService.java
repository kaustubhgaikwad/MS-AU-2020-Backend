package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ProjectEvaluation;
import com.example.demo.repository.ProjectEvaluationRepository;

@Service
public class ProjectEvaluationService {

	@Autowired
	ProjectEvaluationRepository repository;
	
	public ProjectEvaluation update(ProjectEvaluation record,Long id) {
		
		ProjectEvaluation data= repository.findById(id).get();
		data.setBuildWeightage(record.getBuildWeightage());
		data.setProcessWeightage(record.getProcessWeightage());
		data.setTestingWeightage(record.getTestingWeightage());
		
		return repository.save(data);
	}
	
	public List<ProjectEvaluation> get() {
		return (List<ProjectEvaluation>) repository.findAll();
		//return repository.findById(id);
	}

	public ProjectEvaluation add(ProjectEvaluation record) {
		
		return repository.save(record);
	}
	
}

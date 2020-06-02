package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Project;
import com.example.demo.model.Student;
import com.example.demo.model.TryAssignmentStudentDatabase;
import com.example.demo.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository repository;
	
	public Project add(Project project) {
		return repository.save(project);
	}
	
	public Project getByStudentId(Long id) {
		return repository.findByStudentId(id);
	}
	
	public Project update(Long projectId,Project project) {

		Project data= repository.findById(projectId).get();
		data.setGithubLink(project.getGithubLink());
		return repository.save(data);
		
		//Optional<Student> _student = service.getStudentByEmail(email);
		
		
		
//		TryAssignmentStudentDatabase _record = new TryAssignmentStudentDatabase();
//		_record.setAssignmentDescription(_assessment.getDescription());
//		_record.setAssignmentTitle(_assessment.getTitle());
//		_record.setAssignmentSolution(solution);
//		_record.setStudentEmail(email);
//		_record.setStudentName(_student.get().getName());
//		
//		return repository.save(_record);
//		
	}
	
	
}

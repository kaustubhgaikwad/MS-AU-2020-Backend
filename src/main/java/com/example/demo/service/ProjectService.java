package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Project;
import com.example.demo.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository repository;
	
	@Autowired
	StudentService service;
	
	public Project add(Project project) {
		return repository.save(project);
	}
	
	public Project getByStudentId(Long id) {
		return repository.findByStudentId(id);
	}
	
	public Project update(Long projectId,Project project) {
		System.out.println(project);
		Project data= repository.findById(projectId).get();
		data.setProjectTitle(project.getProjectTitle());
		data.setProjectDescription(project.getProjectDescription());
		data.setBuild(project.getBuild());
		data.setScore(project.getScore());
		data.setGithubLink(project.getGithubLink());
		data.setCompletionPercentage(project.getCompletionPercentage());
		data.setTestingCoverage(project.getTestingCoverage());
		data.setCurrentlyWorkingOn(project.getCurrentlyWorkingOn());
		data.setProcessMarks(project.getProcessMarks());
		data.setBuildMarks(project.getBuildMarks());
		data.setTestingMarks(project.getTestingMarks());
		service.addProjectScore(project.getScore(),project.getStudentId());
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

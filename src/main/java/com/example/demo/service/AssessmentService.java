package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Assessment;
import com.example.demo.model.TryAssignmentStudentDatabase;
import com.example.demo.repository.AssessmentRepository;
import com.example.demo.repository.TryAssignmentStudentDatabaseRepository;

@Service
public class AssessmentService {

	@Autowired
	AssessmentRepository assessmentRepository;
	
	@Autowired
	TryAssignmentStudentDatabaseService service;

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
		List<TryAssignmentStudentDatabase> list = service.getByAssignmentId(id);
		for(int i=0;i<list.size();i++) {
			service.delete(list.get(i).getId());
		}
		 assessmentRepository.deleteById(id);
	}
	public Optional<Assessment> get(long id) {
		return assessmentRepository.findById(id);
	}
	public Assessment getByTitle(String title) {
		System.out.println("Inside assignment service title="+title);
		Assessment data=assessmentRepository.findByTitle(title);
		System.out.println("data return from assignment table="+data);
		return data;
	}
	public void update(Assessment assessment) {
		System.out.println("Inside update Assessment of assement service data="+assessment);
		List<TryAssignmentStudentDatabase> list = service.getByAssignmentId(assessment.getId());
		for(int i=0;i<list.size();i++) {
			list.get(i).setAssignmentTitle(assessment.getTitle());
			list.get(i).setAssignmentDescription(assessment.getDescription());
			service.updateTryAssignmentStudentDatabase(list.get(i).getId(),list.get(i));
		}
		
	}
	
	
}

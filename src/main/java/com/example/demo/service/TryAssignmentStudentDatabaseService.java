package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Assessment;
import com.example.demo.model.Student;
import com.example.demo.model.TryAssignmentStudentDatabase;
import com.example.demo.repository.TryAssignmentStudentDatabaseRepository;

@Service
public class TryAssignmentStudentDatabaseService {

	@Autowired
	TryAssignmentStudentDatabaseRepository repository;
	
	@Autowired
	StudentService service;
	
	public List<TryAssignmentStudentDatabase> getAll() {
		return (List<TryAssignmentStudentDatabase>) repository.findAll();
	}
	
	public TryAssignmentStudentDatabase add(Assessment _assessment,String email,String solution) {
		
		Optional<Student> _student = service.getStudentByEmail(email);
		
		TryAssignmentStudentDatabase _record = new TryAssignmentStudentDatabase();
		_record.setAssignmentDescription(_assessment.getDescription());
		_record.setAssignmentTitle(_assessment.getTitle());
		_record.setAssignmentSolution(solution);
		_record.setStudentEmail(email);
		_record.setStudentName(_student.get().getName());
		
		return repository.save(_record);
		
		
	}

	public TryAssignmentStudentDatabase addRecord(TryAssignmentStudentDatabase _record) {
		
		return repository.save(_record);
	}
	
}
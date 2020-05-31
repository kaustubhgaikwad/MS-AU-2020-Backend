package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Assessment;
import com.example.demo.model.Student;
import com.example.demo.model.StudentAssignment;
import com.example.demo.model.TryAssignmentStudentDatabase;
import com.example.demo.repository.AssessmentRepository;
import com.example.demo.repository.StudentAssignmentRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TryAssignmentStudentDatabaseRepository;

@Service
public class StudentAssignmentService {

	@Autowired
	StudentAssignmentRepository repository;
	
//	@Autowired
//	StudentService service;
//	
	
	
	
	public List<StudentAssignment> getAll() {
		return (List<StudentAssignment>) repository.findAll();
	}
	
//	public TryAssignmentStudentDatabase add(Assessment _assessment,String email,String solution) {
//		
//		Optional<Student> _student = service.getStudentByEmail(email);
//		
//		TryAssignmentStudentDatabase _record = new TryAssignmentStudentDatabase();
//		_record.setAssignmentDescription(_assessment.getDescription());
//		_record.setAssignmentTitle(_assessment.getTitle());
//		_record.setAssignmentSolution(solution);
//		_record.setStudentEmail(email);
//		_record.setStudentName(_student.get().getName());
//		
//		return repository.save(_record);
//		
//		
//	}

	public StudentAssignment addRecord(StudentAssignment _record) {
		StudentAssignment data;
		 data=repository.save(_record);
		System.out.println("Inside service record adding="+data.toString());
		return repository.save(_record);
	}

	public StudentAssignment getRecord(String title, String email) {
		return repository.findByAssignmentTitleAndStudentEmail(title, email);
	}

	public Optional<StudentAssignment> get(long id) {
		return repository.findById(id);
	}
	
	public List<StudentAssignment> getByEmail(String email){
		return repository.findByStudentEmail(email);
	}

}

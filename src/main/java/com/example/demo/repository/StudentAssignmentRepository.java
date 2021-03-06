package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.Student;
import com.example.demo.model.StudentAssignment;

@CrossOrigin(origins = "http://localhost:4200")
public interface StudentAssignmentRepository extends CrudRepository<StudentAssignment,Long>{
	
	StudentAssignment findByAssignmentTitleAndStudentEmail(String title,String email);
	
	List<StudentAssignment> findByStudentEmail(String email);
	
}

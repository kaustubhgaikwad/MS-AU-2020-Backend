package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.TryAssignmentStudentDatabase;

@CrossOrigin(origins = "http://localhost:4200")
public interface TryAssignmentStudentDatabaseRepository extends CrudRepository<TryAssignmentStudentDatabase,Long> {
	
	TryAssignmentStudentDatabase findByAssignmentTileAndByStudentEmail(String title,String email);
	
	
}

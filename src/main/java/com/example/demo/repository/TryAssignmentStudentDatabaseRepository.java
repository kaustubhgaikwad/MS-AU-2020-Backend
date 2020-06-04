package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.AssignmentDone;
import com.example.demo.model.TryAssignmentStudentDatabase;

@CrossOrigin(origins = "http://localhost:4200")
public interface TryAssignmentStudentDatabaseRepository extends CrudRepository<TryAssignmentStudentDatabase,Long> {
	
	TryAssignmentStudentDatabase findByAssignmentTitleAndStudentEmail(String title,String email);
	List<TryAssignmentStudentDatabase> findByStudentEmail(String email);
	List<TryAssignmentStudentDatabase> findByStudentId(Long id);
	
	@Query("select assignmentTitle as title, count(studentId) as count from TryAssignmentStudentDatabase  group by assignmentId")
	List<?> findAssignmentsDone();
	
	@Query("select sum(score) as score from TryAssignmentStudentDatabase group by assignmentId having assignmentId= 1 ")
	List<?> getScore(Long id);
	
	
}

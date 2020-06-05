package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.StudentDetails;

public interface StudentDetailsRepository extends CrudRepository<StudentDetails,Long>{
	
	//@Query("select courseId,courseName, count()")
//	@Query("select courseName,courseId,count(Location) as Location from StudentDetails group by Location")
//	List<?> findLocationStatus();
//	
	
}

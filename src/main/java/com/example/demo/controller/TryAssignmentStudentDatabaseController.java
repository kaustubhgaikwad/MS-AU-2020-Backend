package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.model.StudentAssignment;
import com.example.demo.model.TryAssignmentStudentDatabase;
import com.example.demo.service.StudentService;
import com.example.demo.service.TryAssignmentStudentDatabaseService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/assignmentrecords")
public class TryAssignmentStudentDatabaseController {

	@Autowired
	TryAssignmentStudentDatabaseService service;
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/all")
	public List<TryAssignmentStudentDatabase> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional<TryAssignmentStudentDatabase> get(@PathVariable("id") long id) {
		return service.get(id);
	}
	
	@GetMapping("/all/{email}")
	public List<TryAssignmentStudentDatabase> getByEmail(@PathVariable("email") String email) {
		return service.getByEmail(email);
	}
	
	@PostMapping("/add")
	public TryAssignmentStudentDatabase addRecord(@RequestBody TryAssignmentStudentDatabase _record)
	{
		System.out.println("Inside Conroller Record added="+_record);
		Student student = studentService.getStudentByEmail(_record.getStudentEmail()).get();
		String name = student.getName();
		Long id = student.getId();
		_record.setStudentName(name);
		_record.setStudentId(id);
		_record.setScore(0L);
		System.out.println("Inside Conroller Record added="+_record);
		//return service.addRecord(_record);
		return service.addRecord(_record);
	}
	
	@GetMapping("/{title}/{email}")
	public TryAssignmentStudentDatabase getRecord(@PathVariable("title") String title,@PathVariable("email") String email) {
		return service.getRecord(title,email);
	}
	
	@PutMapping("/{id}")
	public TryAssignmentStudentDatabase update(@PathVariable("id") long id, @RequestBody TryAssignmentStudentDatabase record) {
		Optional<TryAssignmentStudentDatabase> data = service.get(id);
		if(data != null) {
			TryAssignmentStudentDatabase update_record = data.get();
			update_record.setAssignmentDescription(record.getAssignmentDescription());
			update_record.setAssignmentSolution(record.getAssignmentSolution());
			update_record.setAssignmentTitle(record.getAssignmentTitle());
			update_record.setStudentEmail(record.getStudentEmail());
			update_record.setStudentName(record.getStudentName());
			return service.addRecord(update_record);
		}else {
			return null;
		}
	}
//	public Assessment update(@PathVariable("id") long id, @RequestBody Assessment assessment) {
//		Optional<Assessment> assessmentData = assessmentService.getAssessment(id);
//		if(assessmentData != null) {
//			Assessment _assessment = assessmentData.get();
//			System.out.println("Output of .get method()= "+ _assessment);
//			_assessment.setTitle(assessment.getTitle());
//			_assessment.setDescription(assessment.getDescription());
//			return assessmentService.add(_assessment);
//		}
//		else {
//			return null;
//		}
//	}
	
}

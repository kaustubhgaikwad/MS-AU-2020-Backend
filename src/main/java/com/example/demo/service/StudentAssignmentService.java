//package com.example.demo.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.model.Assessment;
//import com.example.demo.model.Student;
//import com.example.demo.model.StudentAssignment;
//import com.example.demo.repository.AssessmentRepository;
//import com.example.demo.repository.StudentAssignmentRepository;
//import com.example.demo.repository.StudentRepository;
//
//@Service
//public class StudentAssignmentService {
//
//	@Autowired
//	StudentAssignmentRepository studentAssignmentRepository;
//	
//	@Autowired
//	StudentService studentService;
//	
////	@Autowired
////	AssessmentRepository assementRepository;
////	
//	@Autowired
//	AssessmentService assessmentService;
//	
//	public List<StudentAssignment> getAll(){
//		return (List<StudentAssignment>) studentAssignmentRepository.findAll();
//	}
//	
//	public StudentAssignment add(long assessmentId,String studentEmail) {
//		
//		Optional<Assessment> _assessment = assessmentService.getAssessment(assessmentId);
//		Optional<Student> _student = studentService.getStudentByEmail(studentEmail);
////		if((_assessment!=null)&&(_student!=null)) {
////			StudentAssignment _studentAssignment=new StudentAssignment(_assessment.get(),_student.get());
////			
////		}else {
////			return null;
////		}
//		return studentAssignmentRepository.save(new StudentAssignment(_assessment.get(),_student.get()));
//		
//	}
//}

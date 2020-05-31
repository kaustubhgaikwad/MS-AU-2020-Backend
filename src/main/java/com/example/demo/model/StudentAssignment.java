//package com.example.demo.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity(name="try_student_assignment")
//public class StudentAssignment {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//	private Assessment assessment;
//	private Student student;
//	
//	public StudentAssignment() {
//		
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public Assessment getAssessment() {
//		return assessment;
//	}
//
//	public void setAssessment(Assessment assessment) {
//		this.assessment = assessment;
//	}
//
//	public Student getStudent() {
//		return student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}
//
//	public StudentAssignment(Assessment assessment, Student student) {
//		
//		this.assessment = assessment;
//		this.student = student;
//	}
//
//	@Override
//	public String toString() {
//		return "StudentAssignment [id=" + id + ", assessment=" + assessment + ", student=" + student + "]";
//	}
//	
//	
//	
//
//}

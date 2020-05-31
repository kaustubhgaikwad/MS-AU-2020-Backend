package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TryAssignmentStudentDatabase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String assignmentTitle;
	private String assignmentDescription;
	private String assignmentSolution;
	private String studentName;
	private String studentEmail;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		this.Id = id;
	}
	public String getAssignmentTitle() {
		return assignmentTitle;
	}
	public void setAssignmentTitle(String assignmentTitle) {
		this.assignmentTitle = assignmentTitle;
	}
	public String getAssignmentDescription() {
		return assignmentDescription;
	}
	public void setAssignmentDescription(String assignmentDescription) {
		this.assignmentDescription = assignmentDescription;
	}
	public String getAssignmentSolution() {
		return assignmentSolution;
	}
	public void setAssignmentSolution(String assignmentSolution) {
		this.assignmentSolution = assignmentSolution;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	
	public TryAssignmentStudentDatabase(){
		
	}
	public TryAssignmentStudentDatabase(String assignmentTitle, String assignmentDescription, String assignmentSolution,
			String studentName, String studentEmail) {
		
		this.assignmentTitle = assignmentTitle;
		this.assignmentDescription = assignmentDescription;
		this.assignmentSolution = assignmentSolution;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
	}
	@Override
	public String toString() {
		return "TryAssignmentStudentDatabase [Id=" + Id + ", assignmentTitle=" + assignmentTitle
				+ ", assignmentDescription=" + assignmentDescription + ", assignmentSolution=" + assignmentSolution
				+ ", studentName=" + studentName + ", studentEmail=" + studentEmail + "]";
	}
	
	
	
	
}

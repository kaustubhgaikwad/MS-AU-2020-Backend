package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TryAssignmentStudentDatabase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String assignmentTitle;
	private String assignmentDescription;
	private String assignmentSolution;
	private String studentName;
	private String studentEmail;
	private Long assignmentId;
	private Long studentId;
	private Long score;
	public TryAssignmentStudentDatabase(String assignmentTitle, String assignmentDescription, String assignmentSolution,
			String studentName, String studentEmail, Long assignmentId, Long studentId, Long score) {
		this.assignmentTitle = assignmentTitle;
		this.assignmentDescription = assignmentDescription;
		this.assignmentSolution = assignmentSolution;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.assignmentId = assignmentId;
		this.studentId = studentId;
		this.score = score;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(Long assignmentId) {
		this.assignmentId = assignmentId;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	
	public TryAssignmentStudentDatabase() {
		
	}
	
	
}

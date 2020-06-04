package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String emailId;
	private Long assignmentMarks;
	private Long projectMarks;
	private Long score;
	private Long percentile;
	
	
	
	public Student(String name, String emailId, Long assignmentMarks, Long projectMarks, Long score, Long percentile,
			Long rank) {
	
		this.name = name;
		this.emailId = emailId;
		this.assignmentMarks = assignmentMarks;
		this.projectMarks = projectMarks;
		this.score = score;
		this.percentile = percentile;
		
	}
	
	public Student() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getAssignmentMarks() {
		return assignmentMarks;
	}

	public void setAssignmentMarks(Long assignmentMarks) {
		this.assignmentMarks = assignmentMarks;
	}

	public Long getProjectMarks() {
		return projectMarks;
	}

	public void setProjectMarks(Long projectMarks) {
		this.projectMarks = projectMarks;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Long getPercentile() {
		return percentile;
	}

	public void setPercentile(Long percent) {
		this.percentile = percent;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", emailId=" + emailId + ", assignmentMarks=" + assignmentMarks
				+ ", projectMarks=" + projectMarks + ", score=" + score + ", percentile=" + percentile + ", rank="
				+  "]";
	}
	
	
	
}

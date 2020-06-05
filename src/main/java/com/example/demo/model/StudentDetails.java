package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Long courseId;
	private String courseName;
	private Long workExp;
	private String Location;
	
	public StudentDetails(String name, Long courseId, String courseName, Long workExp, String location) {
		
		this.name = name;
		this.courseId = courseId;
		this.courseName = courseName;
		this.workExp = workExp;
		this.Location = location;
	}
	
	public StudentDetails() {
		
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

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Long getWorkExp() {
		return workExp;
	}

	public void setWorkExp(Long workExp) {
		this.workExp = workExp;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		this.Location = location;
	}

	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", name=" + name + ", courseId=" + courseId + ", courseName=" + courseName
				+ ", workExp=" + workExp + ", Location=" + Location + "]";
	}
	
	
	
		
}

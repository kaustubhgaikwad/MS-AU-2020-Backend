package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Weightage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long project;
	private Long assignment;
	
	public Weightage() {
		
	}
	public Weightage(Long project, Long assignment) {
		
		this.project = project;
		this.assignment = assignment;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProject() {
		return project;
	}
	public void setProject(Long project) {
		this.project = project;
	}
	public Long getAssignment() {
		return assignment;
	}
	public void setAssignment(Long assignment) {
		this.assignment = assignment;
	}
	@Override
	public String toString() {
		return "Wieghtage [id=" + id + ", project=" + project + ", assignment=" + assignment + "]";
	}
	
	
	
	

}

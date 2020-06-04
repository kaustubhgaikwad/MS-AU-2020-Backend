package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProjectEvaluation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long projectId;
	private Long buildWeightage;
	private Long processWeightage;
	private Long testingWeightage;
	public ProjectEvaluation(Long projectId, Long buildWeightage, Long processWeightage, Long testingWeightage) {
		
		this.projectId = projectId;
		this.buildWeightage = buildWeightage;
		this.processWeightage = processWeightage;
		this.testingWeightage = testingWeightage;
	}
	public ProjectEvaluation() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public Long getBuildWeightage() {
		return buildWeightage;
	}
	public void setBuildWeightage(Long buildWeightage) {
		this.buildWeightage = buildWeightage;
	}
	public Long getProcessWeightage() {
		return processWeightage;
	}
	public void setProcessWeightage(Long processWeightage) {
		this.processWeightage = processWeightage;
	}
	public Long getTestingWeightage() {
		return testingWeightage;
	}
	public void setTestingWeightage(Long tesitngWeightage) {
		this.testingWeightage = tesitngWeightage;
	}
	@Override
	public String toString() {
		return "ProjectEvaluation [id=" + id + ", projectId=" + projectId + ", buildWeightage=" + buildWeightage
				+ ", processWeightage=" + processWeightage + ", tesingWeightage=" + testingWeightage + "]";
	}
	
	
	
	
	
}

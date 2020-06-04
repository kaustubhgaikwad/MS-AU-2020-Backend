package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long projectId;
	private String projectTitle;
	private String projectDescription;
	private Long studentId;
	private String studentName;
	private String githubLink;
	private Long testingCoverage;
	private Long build;
	private Long completionPercentage;
	private Long score;
	private String currentlyWorkingOn;
	private Long buildMarks;
	private Long testingMarks;
	private Long processMarks;
	
	
	
	public Project() {
		
	}
	
	public Project(Long projectId, String projectTitle, String projectDescription, Long studentId, String studentName,
			String githubLink, Long testingCoverage, Long build, Long completionPercentage, Long score,
			String currentlyWorkingOn, Long buildMarks, Long testingMarks, Long processMarks) {
		
		this.projectId = projectId;
		this.projectTitle = projectTitle;
		this.projectDescription = projectDescription;
		this.studentId = studentId;
		this.studentName = studentName;
		this.githubLink = githubLink;
		this.testingCoverage = testingCoverage;
		this.build = build;
		this.completionPercentage = completionPercentage;
		this.score = score;
		this.currentlyWorkingOn = currentlyWorkingOn;
		this.buildMarks = buildMarks;
		this.testingMarks = testingMarks;
		this.processMarks = processMarks;
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

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGithubLink() {
		return githubLink;
	}

	public void setGithubLink(String githubLink) {
		this.githubLink = githubLink;
	}

	public Long getTestingCoverage() {
		return testingCoverage;
	}

	public void setTestingCoverage(Long testingCoverage) {
		this.testingCoverage = testingCoverage;
	}

	public Long getBuild() {
		return build;
	}

	public void setBuild(Long build) {
		this.build = build;
	}

	public Long getCompletionPercentage() {
		return completionPercentage;
	}

	public void setCompletionPercentage(Long completionPercentage) {
		this.completionPercentage = completionPercentage;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public String getCurrentlyWorkingOn() {
		return currentlyWorkingOn;
	}

	public void setCurrentlyWorkingOn(String currentlyWorkingOn) {
		this.currentlyWorkingOn = currentlyWorkingOn;
	}

	public Long getBuildMarks() {
		return buildMarks;
	}

	public void setBuildMarks(Long buildMarks) {
		this.buildMarks = buildMarks;
	}

	public Long getTestingMarks() {
		return testingMarks;
	}

	public void setTestingMarks(Long testingMarks) {
		this.testingMarks = testingMarks;
	}

	public Long getProcessMarks() {
		return processMarks;
	}

	public void setProcessMarks(Long processMarks) {
		this.processMarks = processMarks;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectId=" + projectId + ", projectTitle=" + projectTitle
				+ ", projectDescription=" + projectDescription + ", studentId=" + studentId + ", studentName="
				+ studentName + ", githubLink=" + githubLink + ", testingCoverage=" + testingCoverage + ", build="
				+ build + ", completionPercentage=" + completionPercentage + ", score=" + score
				+ ", currentlyWorkingOn=" + currentlyWorkingOn + ", buildMarks=" + buildMarks + ", testingMakrs="
				+ testingMarks + ", processMarks=" + processMarks + "]";
	}
	
	
	
	
}

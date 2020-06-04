package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class AssignmentDone {

	private String AssignmentTitle;
	private Long no;
	
	public AssignmentDone() {
		
	}

	public AssignmentDone(String assignmentTitle, Long no) {
		
		AssignmentTitle = assignmentTitle;
		this.no = no;
	}

	public String getAssignmentTitle() {
		return AssignmentTitle;
	}

	public void setAssignmentTitle(String assignmentTitle) {
		AssignmentTitle = assignmentTitle;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "AssignmentDone [AssignmentTitle=" + AssignmentTitle + ", no=" + no + "]";
	}
	
	
	
}

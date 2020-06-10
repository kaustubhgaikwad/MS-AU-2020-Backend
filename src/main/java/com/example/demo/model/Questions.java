package com.example.demo.model;

import java.util.List;

public class Questions {

	private Long id;
	private String question;
	private List<String> options;
	private Long ans;
	
	public Long getAns() {
		return ans;
	}
	public void setAns(Long ans) {
		this.ans = ans;
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public List<String> getOptions() {
		return options;
	}
	
	public void setOptions(List<String> options) {
		this.options = options;
	}
	
	public Questions(Long id, String question, List<String> options,Long ans) {
		this.id = id;
		this.question = question;
		this.options = options;
		this.ans = ans;
	}
	public Questions() {
		
	}
	
	
	
}

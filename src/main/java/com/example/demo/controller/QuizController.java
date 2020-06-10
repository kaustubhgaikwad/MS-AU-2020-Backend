package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Questions;
import com.example.demo.service.QuizService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	QuizService service;
	
	@GetMapping("/questions")
	public List<Questions> getQuestions(){
		return service.getQuestions();
	}
	
	@GetMapping("/questions/{id}")
	public List<Questions> getQuestionsById(@PathVariable("id") Long id){
		return service.getQuestionsByid(id);
	}

}

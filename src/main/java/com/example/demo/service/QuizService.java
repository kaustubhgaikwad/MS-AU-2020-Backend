package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Questions;
import com.example.demo.model.Quiz;
import com.example.demo.repository.QuizRepository;

@Service
public class QuizService {

	@Autowired
	QuizRepository repository;
	
	
	public List<Questions> getQuestions() {
		
		List<Quiz> quiz = (List<Quiz>) repository.findAll();
		List<Questions> response=new ArrayList<>();
		for(int i=0;i<quiz.size();i++) {
			
			Questions question = new Questions();
			question.setId(quiz.get(i).getId());
			question.setQuestion(quiz.get(i).getQuestion());
			List<String> options = new ArrayList<>();
			options.add(quiz.get(i).getOption1());
			options.add(quiz.get(i).getOption2());
			options.add(quiz.get(i).getOption3());
			options.add(quiz.get(i).getOption4());
			question.setOptions(options);
			question.setAns(quiz.get(i).getAnswer());
			response.add(question);
		}
		return response;
		
	}
	
	public List<Questions> getQuestionsByid(Long id) {
		
		List<Quiz> list = (List<Quiz>) repository.findByQuizId(id);
		List<Questions> response=new ArrayList<>();
		int totalItems=5;
		Random rand = new Random(); 
		List<Quiz> quiz = new ArrayList<>();
		
		for (int i = 0; i < totalItems; i++) { 
			int randomIndex = rand.nextInt(list.size()); 
			quiz.add(list.get(randomIndex)); 
            list.remove(randomIndex); 
        }
		
		for(int i=0;i<quiz.size();i++) {
			
			Questions question = new Questions();
			question.setId(quiz.get(i).getId());
			question.setQuestion(quiz.get(i).getQuestion());
			List<String> options = new ArrayList<>();
			options.add(quiz.get(i).getOption1());
			options.add(quiz.get(i).getOption2());
			options.add(quiz.get(i).getOption3());
			options.add(quiz.get(i).getOption4());
			question.setOptions(options);
			question.setAns(quiz.get(i).getAnswer());
			response.add(question);
		}
		return response;
		
	}
	
}

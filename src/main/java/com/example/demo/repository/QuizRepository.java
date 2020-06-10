package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Quiz;

public interface QuizRepository extends CrudRepository<Quiz,Long> {
	
	List<Quiz> findByQuizId(Long id);

}

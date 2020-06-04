package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Assessment;
import com.example.demo.service.AssessmentService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/assignments")
public class AssessmentController {

	@Autowired
	AssessmentService assessmentService;
	
	@GetMapping("/all")
	public List<Assessment> getAll(){
		System.out.println("Inside getall");
		return assessmentService.getAll();
	}
	@GetMapping("/title")
	public Assessment getByTitle(@RequestBody String title) {
		System.out.println("Inside assignment controller="+title);
		return assessmentService.getByTitle(title);
	}
	
	@GetMapping("/{id}")
	public Optional<Assessment> getAssessment(@PathVariable("id") long id) {
		return assessmentService.getAssessment(id);
	}
	
	@PostMapping("/add")
	public Assessment add(@RequestBody Assessment assessment) {
		return assessmentService.add(assessment);
	}
	
	@PutMapping("/{id}")
	public Assessment update(@PathVariable("id") long id, @RequestBody Assessment assessment) {
		Optional<Assessment> assessmentData = assessmentService.getAssessment(id);
		if(assessmentData != null) {
			Assessment _assessment = assessmentData.get();
			System.out.println("Output of .get method()= "+ _assessment);
			_assessment.setTitle(assessment.getTitle());
			_assessment.setDescription(assessment.getDescription());
			assessmentService.update(_assessment);
			return assessmentService.add(_assessment);
		}
		else {
			return null;
		}
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") long id) {
		assessmentService.delete(id);
	}
	
	
	
	
//	@GetMapping("/tutorials/{id}")
//	  public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
//	    Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
//
//	    if (tutorialData.isPresent()) {
//	      return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
//	    } else {
//	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	  }
//
//	  @PostMapping("/tutorials")
//	  public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
//	    try {
//	      Tutorial _tutorial = tutorialRepository
//	          .save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
//	      return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
//	    } catch (Exception e) {
//	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
//	    }
//	  }
//
//	  @PutMapping("/tutorials/{id}")
//	  public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
//	    Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
//
//	    if (tutorialData.isPresent()) {
//	      Tutorial _tutorial = tutorialData.get();
//	      _tutorial.setTitle(tutorial.getTitle());
//	      _tutorial.setDescription(tutorial.getDescription());
//	      _tutorial.setPublished(tutorial.isPublished());
//	      return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
//	    } else {
//	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	  }
//
//	  @DeleteMapping("/tutorials/{id}")
//	  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
//	    try {
//	      tutorialRepository.deleteById(id);
//	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	    } catch (Exception e) {
//	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
//	    }
//	  }
//
//	  @DeleteMapping("/tutorials")
//	  public ResponseEntity<HttpStatus> deleteAllTutorials() {
//	    try {
//	      tutorialRepository.deleteAll();
//	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	    } catch (Exception e) {
//	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
//	    }
//	  }
	
}



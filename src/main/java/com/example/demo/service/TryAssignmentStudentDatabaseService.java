package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Assessment;
import com.example.demo.model.Student;
import com.example.demo.model.TryAssignmentStudentDatabase;
import com.example.demo.repository.TryAssignmentStudentDatabaseRepository;

@Service
public class TryAssignmentStudentDatabaseService {

	@Autowired
	TryAssignmentStudentDatabaseRepository repository;
	
	@Autowired
	StudentService service;
	
	@Autowired
	AssessmentService assessmentService;
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public List<TryAssignmentStudentDatabase> getByAssignmentId(Long id){
		return repository.findByAssignmentId(id);
		
	}
	
	public void updateTryAssignmentStudentDatabase(Long id,TryAssignmentStudentDatabase record) {
		System.out.println("Inside studentassignment service data="+record);
		TryAssignmentStudentDatabase data = repository.findById(id).get();
		data.setAssignmentTitle(record.getAssignmentTitle());
		data.setAssignmentDescription(record.getAssignmentDescription());
		repository.save(data);
		
	}
	
	public List<?> findAssignmentsDone(){
		return (List<?>) repository.findAssignmentsDone();
	}
	
	public List<TryAssignmentStudentDatabase> getAllById(Long id){
		
		return repository.findByStudentId(id);
	}
	
	public List<TryAssignmentStudentDatabase> getAll() {
		return (List<TryAssignmentStudentDatabase>) repository.findAll();
	}
	
	public TryAssignmentStudentDatabase add(Assessment _assessment,String email,String solution) {
		
		Optional<Student> _student = service.getStudentByEmail(email);
		
		TryAssignmentStudentDatabase _record = new TryAssignmentStudentDatabase();
		_record.setAssignmentDescription(_assessment.getDescription());
		_record.setAssignmentTitle(_assessment.getTitle());
		_record.setAssignmentSolution(solution);
		_record.setStudentEmail(email);
		_record.setStudentName(_student.get().getName());
		
		return repository.save(_record);
		
		
	}

	public TryAssignmentStudentDatabase addRecord(TryAssignmentStudentDatabase _record) {
		TryAssignmentStudentDatabase data;
		 data=repository.save(_record);
		System.out.println("Inside service record adding="+data.toString());
		return data;
	}

	public TryAssignmentStudentDatabase getRecord(String title, String email) {
		return repository.findByAssignmentTitleAndStudentEmail(title, email);
	}

	public Optional<TryAssignmentStudentDatabase> get(long id) {
		
		return repository.findById(id);
	}

	public List<TryAssignmentStudentDatabase> getByEmail(String email) {
		return (List<TryAssignmentStudentDatabase>) repository.findByStudentEmail(email);
	}

	public Long getScore(Long id) {
		int number = assessmentService.getAll().size(); 
		System.out.println("id=");
		Long score=0L;
		List<TryAssignmentStudentDatabase> data = repository.findByStudentId(id);
		for(TryAssignmentStudentDatabase record : data) {
			score+=record.getScore();
		}
		score = (score*100)/(number*10);
		System.out.println("No of assignments="+number);
		System.out.println("Score = "+score);
		service.addAssignmentScore(score, id);
		return  score;
	}
	
	
}

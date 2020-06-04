package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TryAssignmentStudentDatabaseRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	TryAssignmentStudentDatabaseService service;
	
	public Optional<Student> getStudent(long id) {
		return studentRepository.findById(id);
	}
	
	public Optional<Student> getStudentByEmail(String email) {
		return studentRepository.findByEmailId(email);
	}
	
	public List<Student> getAll() {
		return (List<Student>) studentRepository.findAll();
	}
	public Optional<Student> getAssignmentMarks(Long id) {
		Long no= service.getScore(id);
		return studentRepository.findById(id);
	}
	public Long getProjectMarks(Long id) {
		return studentRepository.findById(id).get().getProjectMarks();
	}
	public Long getSCore(Long id) {
		return studentRepository.findById(id).get().getScore();
	}
	public void addAssignmentScore(Long score,Long id) {
		
		Student data=studentRepository.findById(id).get(); 
		data.setAssignmentMarks(score);
		studentRepository.save(data);
	}
	public void addProjectScore(Long score,Long id) {
		Student data=studentRepository.findById(id).get(); 
		data.setProjectMarks(score);
		studentRepository.save(data);
	}
	public Student addFinalScore(Student student) {
		Student data=studentRepository.findById(student.getId()).get(); 
		data.setScore(student.getScore());
		return studentRepository.save(data);
	}
	
	public void CalculatePercentile() {
		List<Student> students = (List<Student>) studentRepository.findAll();
		int i,j,count;
		Long percent;
		for(i = 0;i<students.size();i++) {
			count=0;
			for(j=0;j<students.size();j++) {
				if(students.get(i).getScore() > students.get(j).getScore()) {
					count++;
				}
			}
			percent = (long) ((count * 100) / (students.size()-1));
			System.out.println("Percentile of "+students.get(i).getName()+"="+percent);
			Student data = studentRepository.findById(students.get(i).getId()).get();
			data.setPercentile(percent);
			studentRepository.save(data);
			//students.get(i).setPercentile(percent);
		}
		
		List<Student> updatedStudents = (List<Student>) studentRepository.findAll();
		System.out.println("Inside percentile function");
		for(i=0 ;i<students.size();i++) {
			System.out.println(students.get(i).getPercentile());
		}
		
	}

	
	

	
	
}

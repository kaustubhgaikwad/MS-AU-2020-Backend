package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.model.Assessment;
import com.example.demo.repository.AssessmentRepository;

public class AssessmentServiceTest {
	
	
	@Mock
	AssessmentRepository repository;
	
	@InjectMocks
	AssessmentService service;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		Assessment assessment1 = new Assessment("Spring Title","Spring Decription");
		Assessment assessment2 = new Assessment("Angular Title","Angular Decription");
		List<Assessment> list = new ArrayList<Assessment>();
		assessment1.setId(1L);
		assessment1.setId(2L);
		list.add(assessment1);
		list.add(assessment2);
		Assessment assessment3 = new Assessment("Angular Title","Angular Decription");
		assessment3.setId(3L);
		when(repository.findAll()).thenReturn(list);
		when(repository.findById((long) 3)).thenReturn(Optional.of(assessment3));
		when(repository.save(assessment3)).thenReturn(assessment3);
	}  

	@Test
	public void testGetAll() {
		List<Assessment> list = service.getAll();

		assertThat(list.size()).isEqualTo(2);
	}

	@Test
	public void testGetAssessment() {
		Optional<Assessment> assessment = service.get(3L);
		  assertThat(assessment.get().getId())
	      .isEqualTo(3);
	}

	@Test
	public void testAdd() {
		
		Assessment assessment4 = new Assessment("Angular Title","Angular Decription");
		when(repository.save(assessment4)).thenReturn(assessment4);
		assessment4.setId(3L);
		Assessment record=service.add(assessment4);
		assertEquals(record.getTitle(),"Angular Title");
		}

	@Test
	public void testGetByTitle() {
		Assessment assessment4 = new Assessment("Angular Title","Angular Decription");
		when(repository.findByTitle("Angular Title")).thenReturn(assessment4);
		Assessment record = service.getByTitle("Angular Title");
		assertEquals(record.getTitle(),"Angular Title");
		
	}

}

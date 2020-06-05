package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.model.Assessment;
import com.example.demo.model.ProjectEvaluation;
import com.example.demo.service.ProjectEvaluationService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class ProjectEvaluationControllerTest {
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	ProjectEvaluationService service;
	
	//ResponseDto response = new ResponseDto();

//	List<Course> courseList = new ArrayList<>();

	@Before
	public void init() {
        MockitoAnnotations.initMocks(this);
        
    }
	
	
	@Test
	public void test() throws Exception {
		ProjectEvaluation proj= new ProjectEvaluation(1L,30L,60L,10L);
		List<ProjectEvaluation> list = new ArrayList<>();
		list.add(proj);
		when(service.get()).thenReturn(list);
		mockMvc.perform(get("/projectevaluation/get")).andDo(print()).andExpect(status().isOk());
		//mockMvc.perform(get("/assignments/all")).andDo(print()).andExpect(status().isOk());	
	}

}

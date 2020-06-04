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
import com.example.demo.model.Student;
import com.example.demo.service.AssessmentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class AssessmentControllerTest {

	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	@MockBean
	AssessmentService service;
	
	@Autowired
	private MockMvc mockMvc;

	@Before
	public void init() {
        MockitoAnnotations.initMocks(this);
        
    }
	
	@Test
	public void testgetall() throws Exception {
		
		Assessment assessment = new Assessment("a","b");
		assessment.setId(1L);
		List<Assessment> list = new ArrayList<>();
		when(service.getAll()).thenReturn(list);
		mockMvc.perform(get("/assignments/all")).andDo(print()).andExpect(status().isOk());		
	}
	
	@Test
	public void testgetid() throws Exception {
		Assessment assessment = new Assessment("a","b");
		assessment.setId(1L);
		List<Assessment> list = new ArrayList<>();
		when(service.getAll()).thenReturn(list);
		mockMvc.perform(get("/assignments/1")).andDo(print()).andExpect(status().isOk());
	}
	

}

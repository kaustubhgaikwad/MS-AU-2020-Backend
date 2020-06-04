package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.model.Project;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {
	
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	@MockBean
	StudentService studentservice;
	
	@Autowired
	private MockMvc mockMvc;

	@Before
	public void init() {
        MockitoAnnotations.initMocks(this);
        
    }
	
	@Test
	public void testgetAll() throws Exception {
		
		Student s = new Student("a","e",3L,4L,5L,6L,7L);
		s.setId(1L);
		List<Student> list = new ArrayList<>();
		list.add(s);
		when(studentservice.getAll()).thenReturn(list);
		mockMvc.perform(get("/student/all")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void testgetId() throws Exception {
		
		Student s = new Student("a","e",3L,4L,5L,6L,7L);
		s.setId(1L);
		List<Student> list = new ArrayList<>();
		list.add(s);
		when(studentservice.getAll()).thenReturn(list);
		mockMvc.perform(get("/student/1")).andDo(print()).andExpect(status().isOk());
		
	}
	@Test
	public void addfinalSCoreTest() throws Exception {
		Student s = new Student("a","e",3L,4L,5L,6L,7L);
		s.setId(1L);
		when(studentservice.addFinalScore(Mockito.any(Student.class))).thenReturn(s);
		mockMvc.perform(MockMvcRequestBuilders.put("/student/finalscore")
                .content(asJsonString(s))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());	
	//	when(studentservice.addProjectScore(6L, 1L)).thenReturn(s);
	}
	

}

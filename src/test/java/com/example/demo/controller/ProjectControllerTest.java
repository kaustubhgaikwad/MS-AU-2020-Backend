package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
import com.example.demo.service.ProjectService;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
class ProjectControllerTest {
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	@MockBean
	ProjectService projectservice;
	
	@Autowired
	private MockMvc mockMvc;

	@Before
	public void init() {
        MockitoAnnotations.initMocks(this);
        
    }

	@Test
	void testGetAll()  throws Exception {
	
		Project p1 = new Project(1L,"a","b",2L,"c","d",3L,4L,5L,6L,"s",5L,6L,6L);
		p1.setId(1L);
		List <Project> list = new ArrayList<>();
		list.add(p1);
		when(projectservice.getByStudentId(2L)).thenReturn(p1);
		mockMvc.perform(get("/project/2")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test 
	public void addtest() throws Exception{
		Project p1 = new Project(1L,"a","b",2L,"c","d",3L,4L,5L,6L,"s",5L,6L,6L);
		p1.setId(1L);
		when(projectservice.add(Mockito.any(Project.class))).thenReturn(p1);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/project/add")
                .content(asJsonString(p1))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().isOk());	
		
	}

}

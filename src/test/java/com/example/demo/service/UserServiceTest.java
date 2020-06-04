package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;



public class UserServiceTest {
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserService userService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		User user1 = new User("Kaustubh","Password",false);
		when(userRepository.findByUsername("Kaustubh")).thenReturn(user1);
	}  

	@Test
	public void testGetUser() {
		
		User user = userService.getUser("Kaustubh");
		
		assertThat(user.getUsername()).isEqualTo("Kaustubh");
	}

}

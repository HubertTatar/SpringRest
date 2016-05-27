package com.example.controller;

import static org.junit.Assert.fail;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.example.employee.repository.EmployeeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class EmployeeCtrlTest {
//http://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-rest-api/
	private MockMvc mockMvc;
	
	@Test
	public void findAll() throws Exception {
		mockMvc.perform(get("/users/list"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		fail("Not yet implemented");
	}

}

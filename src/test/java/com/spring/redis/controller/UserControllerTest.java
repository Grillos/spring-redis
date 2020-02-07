package com.spring.redis.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
    public void saveTest() throws Exception {
		this.mockMvc.perform(
				post("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"username\": \"test\",\"password\": \"*****\"}")
				.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isCreated());
    }
	
	@Test
    public void findAllTest() throws Exception {
		this.mockMvc.perform(
				get("/users"))
					.andExpect(status().isOk());
    }
	
	@Test
    public void findNotFoundTest() throws Exception {
		this.mockMvc.perform(
				get("/users/0"))
					.andExpect(status().isNotFound());	
    }

}

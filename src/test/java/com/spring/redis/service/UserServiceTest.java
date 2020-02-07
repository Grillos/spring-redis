package com.spring.redis.service;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.redis.domain.User;
import com.spring.redis.repository.UserRepository;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class UserServiceTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Before
	public void setUp() {
		User userPreenchido = populaUser();
	 
	}
	
	@Test	
	public void findByIdTest() throws Exception {
		User user = userRepository.findById(2L).orElse(null);
		assertThat(user.getId()).isEqualTo(populaUser().getId());
		
	}
	
	private User populaUser() {
		return User
				.builder()
				.id(2L)
				.username("teste")
				.password("*****")
				.build();
	}

}

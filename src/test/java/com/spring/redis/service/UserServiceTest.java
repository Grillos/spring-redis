package com.spring.redis.service;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.redis.domain.User;
import com.spring.redis.repository.UserRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
	
	@MockBean
	private UserRepository userRepository;
	
	@Before
	public void setUp() {
		User userPreenchido = populaUser();
	 
	}
	
	@Test	
	public void findByIdTest() throws Exception {
		User user = userRepository.findById(1L).orElse(null);
		assertThat(user.getId()).isEqualTo(populaUser().getId());
		
	}
	
	private User populaUser() {
		return User
				.builder()
				.id(1L)
				.username("teste")
				.password("*****")
				.build();
	}

}

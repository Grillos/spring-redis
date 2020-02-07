package com.spring.redis.service;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.redis.domain.User;
import com.spring.redis.repository.UserRepository;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class UserServiceTest {
	
	@MockBean
	private UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	private Optional<User> user;
	
	@Before
	public void setUp() {
		user = populaUser();
	}
	
	@Test	
	public void findByIdTest() throws Exception {
		BDDMockito.when(userService.findById(2L)).thenReturn(user);
		Assertions.assertThat(user).isNotNull();
	}
	
	private Optional<User> populaUser() {
		return Optional.of(
				User
					.builder()
					.id(2L)
					.username("teste")
					.password("*****")
					.build());
	}

}

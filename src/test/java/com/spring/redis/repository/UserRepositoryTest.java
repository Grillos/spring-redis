package com.spring.redis.repository;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.redis.domain.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void createSuccess() {
		User user = createUserObject();
		userRepository.save(user);
		
		Assertions.assertThat(user).isNotNull();
	}
	
	private User createUserObject() {
		
		return User
				.builder()
				.id(1L)
				.username("teste.username")
				.password("1qaz2wsx")
				.build();
	}
}

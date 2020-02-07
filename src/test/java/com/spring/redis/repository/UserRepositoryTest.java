package com.spring.redis.repository;

import javax.validation.ConstraintViolationException;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.redis.domain.User;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace=Replace.NONE)
@DataJpaTest
public class UserRepositoryTest {
	
	User user;
	
	@Autowired
	private UserRepository userRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void createSuccess() {
		user = createUserObject();
		userRepository.save(user);
		
		Assertions.assertThat(user).isNotNull();
	}
	
	@Test
	public void saveWithUsernameAndPasswordIsEmptyTest() {
		thrown.expect(ConstraintViolationException.class);
		thrown.expectMessage("username cannot be empty");
		thrown.expectMessage("password cannot be empty");
		userRepository.save(User.builder().build());
	}
	
	private User createUserObject() {
		return User
				.builder()
				.username("teste.username")
				.password("1qaz2wsx")
				.build();
	}
}

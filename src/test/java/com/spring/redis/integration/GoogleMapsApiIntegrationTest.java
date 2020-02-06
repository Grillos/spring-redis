package com.spring.redis.integration;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.redis.domain.User;
import com.spring.redis.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GoogleMapsApiIntegrationTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	@MockBean
	private UserRepository UserRepository;
	
	
	@TestConfiguration
	static class config {
		public RestTemplateBuilder restTemplateBuilder() {
			return new RestTemplateBuilder().basicAuthentication("robson", "1qaz2wsx");
		}
		
	}
	
	@Test
	public void findAllUserControllerReturnStatus401() {
		restTemplate = restTemplate.withBasicAuth("1", "1");
		ResponseEntity<User> response = restTemplate.getForEntity("/v1/users", User.class);
		Assertions.assertThat(response.getStatusCode()).isEqualTo(401);
		
	}

}

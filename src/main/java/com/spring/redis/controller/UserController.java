package com.spring.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.redis.domain.User;
import com.spring.redis.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;
	 
    @GetMapping
    public List<User> findAll() {
    	return userService.findAll();
    }
    
    @PostMapping
    public void create(@RequestBody User user) {
    	userService.create(user);
    }
    
    @PutMapping("/{id}")
    public void send(@PathVariable Long id, @RequestBody User user) {
    	userService.update(id, user);
    }
    
}

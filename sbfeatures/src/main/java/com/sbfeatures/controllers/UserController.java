package com.sbfeatures.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbfeatures.entity.BaseUser;
import com.sbfeatures.error.BaseUserException;
import com.sbfeatures.service.BaseUserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	BaseUserService userService;
	
	@PostMapping("/users")
	public BaseUser createUser(@Valid @RequestBody BaseUser user) {
		logger.info("Inside create user method");
		return userService.createUser(user);
	}
	
	@GetMapping("/users/{userId}")
	public BaseUser getUserById(@PathVariable long userId) throws BaseUserException {
		return userService.getUserById(userId);
	}
	
	@GetMapping("/users/ew/{name}")
	public List<BaseUser> findByUserNameEndsWith(@PathVariable String name){
		return userService.findByUserNameEndsWith(name);
	}
	

}

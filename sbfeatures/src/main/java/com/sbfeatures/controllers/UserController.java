package com.sbfeatures.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbfeatures.entity.BaseUser;
import com.sbfeatures.service.BaseUserService;

@RestController
public class UserController {
	
	@Autowired
	BaseUserService userService;
	
	@PostMapping("/users")
	public BaseUser createUser(@RequestBody BaseUser user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/users/{userId}")
	public BaseUser getUserById(@PathVariable long userId) {
		return userService.getUserById(userId);
	}
	
	@GetMapping("/users/ew/{name}")
	public List<BaseUser> findByUserNameEndsWith(@PathVariable String name){
		return userService.findByUserNameEndsWith(name);
	}
	

}

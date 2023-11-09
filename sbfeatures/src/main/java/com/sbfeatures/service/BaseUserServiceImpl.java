package com.sbfeatures.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbfeatures.entity.BaseUser;
import com.sbfeatures.repository.BaseUserRepository;

@Service
public class BaseUserServiceImpl implements BaseUserService{
	
	@Autowired
	BaseUserRepository userRepository;

	@Override
	public BaseUser getUserById(long userId) {
		return userRepository.getReferenceById(userId);  
	}

	@Override
	public BaseUser createUser(BaseUser user) {
		return userRepository.save(user);
	}

	@Override
	public List<BaseUser> findByUserNameEndsWith(String name) {
		return userRepository.findByUserNameEndsWith(name);
	}
}

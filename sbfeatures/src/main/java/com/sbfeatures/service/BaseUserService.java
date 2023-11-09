package com.sbfeatures.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sbfeatures.entity.BaseUser;

@Service
public interface BaseUserService {
	
	public BaseUser getUserById(long userId);

	public BaseUser createUser(BaseUser user);

	public List<BaseUser> findByUserNameEndsWith(String name);	

}

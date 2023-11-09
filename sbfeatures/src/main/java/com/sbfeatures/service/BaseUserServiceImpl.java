package com.sbfeatures.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbfeatures.entity.BaseUser;
import com.sbfeatures.error.BaseUserException;
import com.sbfeatures.repository.BaseUserRepository;

@Service
public class BaseUserServiceImpl implements BaseUserService {

	@Autowired
	BaseUserRepository userRepository;

	@Override
	public BaseUser getUserById(long userId) throws BaseUserException {
		Optional<BaseUser> baseuser = Optional.ofNullable(userRepository.getReferenceById(userId));
		if (!baseuser.isPresent()) {
			throw new BaseUserException("Base user is not present.");
		}
		return baseuser.get();
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

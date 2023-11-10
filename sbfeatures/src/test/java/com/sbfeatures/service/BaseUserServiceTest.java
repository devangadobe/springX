package com.sbfeatures.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sbfeatures.entity.BaseUser;
import com.sbfeatures.error.BaseUserException;
import com.sbfeatures.repository.BaseUserRepository;
import com.sbfeatures.service.BaseUserService;

@SpringBootTest
class BaseUserServiceTest {

	@Autowired
	BaseUserService baseUserService;

	@MockBean
	BaseUserRepository baseUserRepository;

	@BeforeEach
	void setUp() throws Exception {
		BaseUser baseUser = BaseUser.builder().email("piy2@gmail.com").userName("rabi")
				.userId(1L).build();
		
		Mockito.when(baseUserRepository.getReferenceById(1L)).thenReturn(baseUser);
	}

	@Test
	public void whenValidUserId_thenBaseUserShouldFound() throws BaseUserException {
		long userId = 1L;

		BaseUser found = baseUserService.getUserById(userId);

		assertEquals(userId, found.getUserId());
	}
}

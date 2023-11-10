package com.sbfeatures.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.sbfeatures.entity.BaseUser;
import com.sbfeatures.error.BaseUserException;

@DataJpaTest
class BaseUserRepositoryTest {
	
	@Autowired
	BaseUserRepository baseUserRepository;
	
	@Autowired
	TestEntityManager testEntityManager;

	@BeforeEach
	void setUp() throws Exception {
		BaseUser baseUser = BaseUser.builder().email("piy2@gmail.com").userName("rabi")
				            .build();
		
		testEntityManager.persist(baseUser);
	}
	
	@Test
	public void whenValidUserId_thenBaseUserShouldFound() throws BaseUserException {
		String userName = "rabi";

		BaseUser found = baseUserRepository.getReferenceById(1L);

		assertEquals(userName, found.getUserName());
	}
	 
}

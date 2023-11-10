package com.sbfeatures.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.sbfeatures.entity.BaseUser;
import com.sbfeatures.service.BaseUserService;

@WebMvcTest(UserController.class)
class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BaseUserService baseUserService;

	private BaseUser baseUser;

	@BeforeEach
	void setUp() throws Exception {

		baseUser = BaseUser.builder().email("piy2@gmail.com").userName("rabi").build();
	}

	@Test
	public void createUserTest() throws Exception {
		
		BaseUser inputBaseUser = BaseUser.builder().email("piy2@gmail.com").userName("rabi").build();
		
		Mockito.when(baseUserService.createUser(inputBaseUser)).thenReturn(baseUser);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/users")
			  .contentType(MediaType.APPLICATION_JSON)
			  .content("{\n"
			  		+ "    \"userName\" : \"rabi\",\n"
			  		+ "    \"password\" : \"asdban\",\n"
			  		+ "    \"email\" : \"piy2@gmail.com\"\n"
			  		+ "}"))
		      .andExpect(MockMvcResultMatchers.status().isOk());
			  
	}

	@Test
	public void getUserByIdTest() throws Exception {
		
		Mockito.when(baseUserService.getUserById(1L)).thenReturn(baseUser);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/users/1")
				  .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(MockMvcResultMatchers.status().isOk())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.userName").value(baseUser.getUserName()));

	}

}

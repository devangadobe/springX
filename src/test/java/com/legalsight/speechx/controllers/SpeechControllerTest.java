package com.legalsight.speechx.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.legalsight.speechx.AbstractTest;
import com.legalsight.speechx.dto.SearchDto;
import com.legalsight.speechx.dto.SpeechDto;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;


class SpeechControllerTest extends AbstractTest {

	SpeechDto speechDto;

	SearchDto searchDto;

	@Test
	void testSave() throws Exception {
		speechDto = new SpeechDto();
		speechDto.setId(1);
		speechDto.setAuthor("devang");
		speechDto.setContent("sample content for test");
		speechDto.setAddedDate(Date.from(LocalDate.of(2023, 4, 21).atStartOfDay(ZoneId.systemDefault()).toInstant()));

		String uri = "/speechx/";
		String inputJson = super.mapToJson(speechDto);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
	}

	@Test
	void testDelete() throws Exception {
		speechDto = new SpeechDto();
		speechDto.setId(1);
		speechDto.setAuthor("devang");
		speechDto.setContent("sample content for test");
		speechDto.setAddedDate(Date.from(LocalDate.of(2023, 4, 22).atStartOfDay(ZoneId.systemDefault()).toInstant()));

		String uri = "/speechx/";
		String inputJson = super.mapToJson(speechDto);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		uri = "/speechx/del/1";
		mvcResult = mvc.perform(
				MockMvcRequestBuilders.delete(uri).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

	    status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}


	@Test
	void testFindOneInt() throws Exception {
		speechDto = new SpeechDto();
		speechDto.setId(3);
		speechDto.setAuthor("devang");
		speechDto.setContent("sample content for test");
		speechDto.setAddedDate(Date.from(LocalDate.of(2023, 4, 22).atStartOfDay(ZoneId.systemDefault()).toInstant()));

		String uri = "/speechx/";
		String inputJson = super.mapToJson(speechDto);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		uri = "/speechx/3";
		mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

	    status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

}

package com.legalsight.speechx.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.legalsight.speechx.dto.SearchDto;
import com.legalsight.speechx.dto.SpeechDto;
import com.legalsight.speechx.mappers.SpeechMapper;
import com.legalsight.speechx.model.Speech;
import com.legalsight.speechx.services.SpeechService;

@RestController
@RequestMapping("/speechx")
public class SpeechController {

	@Autowired
	SpeechService service;

	@Autowired
	SpeechMapper mapper;

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody SpeechDto dto) {
		Speech speech = mapper.dtoToModel(dto);
		service.save(speech);
	}
	
	@PostMapping("/edit")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> edit(@RequestBody SpeechDto dto) {
		if(dto.getId() < 1) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if(this.findOne(dto.getId())==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Speech speech = mapper.dtoToModel(dto);
		service.save(speech);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/del/{id}")
	public void delete(@PathVariable("id") int id) {
	  service.deleteSpeechById(id);
	}

	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public List<SpeechDto> findAll() {
		return mapper.modelsToDtos(service.findAll());
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public SpeechDto findOne(@PathVariable("id") int id) {
		return mapper.modelToDto(service.findOne(id));
	}
	
	@GetMapping("/author")
	@ResponseStatus(HttpStatus.OK)
	public List<SpeechDto> findOne(@RequestBody SearchDto dto) {
		return mapper.modelsToDtos(service.findByAuthor(dto.getAuthor()));
	}
	
	@GetMapping("/subject")
	@ResponseStatus(HttpStatus.OK)
	public List<SpeechDto> findSub(@RequestBody SearchDto dto) {
		return mapper.modelsToDtos(service.findBySubject(dto.getSubject()));
	}
	
	@GetMapping("/content")
	@ResponseStatus(HttpStatus.OK)
	public List<SpeechDto> findContent(@RequestBody SearchDto dto) {
		return mapper.modelsToDtos(service.findByContent(dto.getKeyword()));
	}
	
	@GetMapping("/date-range")
	@ResponseStatus(HttpStatus.OK)
	public List<SpeechDto> findByDates(@RequestBody SearchDto dto) {
		return mapper.modelsToDtos(service.findByAddedDateBetween(dto));
	}

}

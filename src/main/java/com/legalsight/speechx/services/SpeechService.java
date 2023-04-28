package com.legalsight.speechx.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legalsight.speechx.dto.SearchDto;
import com.legalsight.speechx.model.Speech;
import com.legalsight.speechx.repository.SpeechRepository;

@Service
public class SpeechService {

	@Autowired
	SpeechRepository repository;

	public void save(Speech speech) {
		repository.save(speech);
	}
	
	public void edit(Speech speech) {
		repository.save(speech);
	}

	public List<Speech> findAll() {
		return repository.findAll();
	}

	public Speech findOne(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Speech> findByAuthor(String string) {
		return repository.findByAuthor(string);
	}
	
	public List<Speech> findBySubject(String string) {
		return repository.findBySubjectContaining(string);
	}

	public void deleteSpeechById(int id) {
		repository.deleteById(id);
	}

	public List<Speech> findByContent(String keyword) {
		return repository.findByContentContaining(keyword);
	}

	public List<Speech> findByAddedDateBetween(SearchDto dto) {
		Date startDate = dto.getStartDate();
		Date endDate = dto.getEndDate();
		if(null != startDate && null != endDate){
			return repository.findByAddedDateBetween(startDate,endDate);
		}else {
			return null;
		}		
	}

}

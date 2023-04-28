package com.legalsight.speechx.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.legalsight.speechx.model.Speech;

@Repository
public interface SpeechRepository extends JpaRepository<Speech, Integer>{

	List<Speech> findByAuthor(String string);

	List<Speech> findBySubjectContaining(String string);

	List<Speech> findByContentContaining(String keyword);

	List<Speech> findByAddedDateBetween(Date startDate, Date endDate);

}

package com.legalsight.speechx.model;

import java.util.Date;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author devangbagora
 *
 */
@Getter
@Setter
@Entity
@Table(name = "speech")
public class Speech {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	int id;
	String content;
	String subject;
	String author;
	@ElementCollection
	List<String> keywords;	
	Date addedDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}

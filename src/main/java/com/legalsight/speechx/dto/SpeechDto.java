package com.legalsight.speechx.dto;

import java.util.Date;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpeechDto {	
	
		@Id
		@GeneratedValue
		int id;
		String content;
		String subject;
		String author;
		List<String> keywords;
		Date addedDate;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public List<String> getKeywords() {
			return keywords;
		}
		public void setKeywords(List<String> keywords) {
			this.keywords = keywords;
		}
		public Date getAddedDate() {
			return addedDate;
		}
		public void setAddedDate(Date addedDate) {
			this.addedDate = addedDate;
		}

}

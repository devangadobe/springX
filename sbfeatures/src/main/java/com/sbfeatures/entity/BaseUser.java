package com.sbfeatures.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "baseuser")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseUser {

	@Id
	@GeneratedValue
	public Long userId;
	
	@NotBlank(message = "Username cannot be blank.")
	public String userName;
	
	public String password;
	
	//jakarta validation is useful like that
	@Email
	public String email;
}

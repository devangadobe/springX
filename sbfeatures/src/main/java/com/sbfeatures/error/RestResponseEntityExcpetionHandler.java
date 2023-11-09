package com.sbfeatures.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sbfeatures.entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExcpetionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BaseUserException.class)
	public ResponseEntity<ErrorMessage> baseUserException(BaseUserException baseUserException, WebRequest request) {

		ErrorMessage errMsg = new ErrorMessage(HttpStatus.NOT_FOUND, 
				                  baseUserException.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errMsg);
	}

}

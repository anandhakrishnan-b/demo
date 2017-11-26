package com.sangam.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorEntity {

	private HttpStatus status;
	private LocalDateTime timestamp;
	private String message;
	private String debugMessage;
	private List<FieldError> fieldErrors;

	private ErrorEntity() {
		timestamp = LocalDateTime.now();
	}

	public ErrorEntity(HttpStatus status) {
		this();
		this.status = status;
	}

	public ErrorEntity(HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.message = "Unexpected error";
		this.debugMessage = ex.getLocalizedMessage();
	}

	public ErrorEntity(HttpStatus status, String message, Throwable ex) {
		this();
		this.status = status;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}

	public HttpStatus getStatus() {
		return status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}	
	
	

}

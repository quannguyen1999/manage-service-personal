package com.main.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.main.controller.GalleryPage;
import com.main.model.ErrorResponse;

@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice(basePackageClasses = {GalleryPage.class})
public class CustomExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		
		List<String> details = new ArrayList<>();
		
		details.add(ex.getLocalizedMessage());
		
		System.out.println(ex.getLocalizedMessage());
		
		ErrorResponse error = new ErrorResponse("Server Error", true);
		
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}


	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		
		for(ObjectError error : ex.getBindingResult().getAllErrors()) {
			
			details.add(error.getDefaultMessage());
			
		}
		
		ErrorResponse error = new ErrorResponse("Validation Failed", true);
		
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}
}

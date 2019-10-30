package com.comviva.col.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.comviva.col.exceptions.DuplicateException;
import com.comviva.col.exceptions.InvalidPasswordException;
import com.comviva.col.exceptions.NotFoundException;

/**
 * REST Exception handler.
 * 
 * @author samarth.sangam
 *
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Malformed JSON request";
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFound(NotFoundException ex) {
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
		apiError.setMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}

	@ExceptionHandler(DuplicateException.class)
	public ResponseEntity<Object> handleDuplicateException(DuplicateException ex) {
		ApiError apiError = new ApiError(HttpStatus.CONFLICT);
		apiError.setMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}

	@ExceptionHandler({ FileNotFoundException.class, IOException.class, InvalidPasswordException.class })
	public ResponseEntity<Object> handleFileNotFoundException(FileNotFoundException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
		apiError.setMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}
}

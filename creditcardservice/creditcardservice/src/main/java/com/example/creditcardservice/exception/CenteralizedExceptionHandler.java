package com.example.creditcardservice.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.example.creditcardservice.models.ErrorResponse;


@ControllerAdvice
@RestController
public class CenteralizedExceptionHandler {

	@ExceptionHandler(CreditCardNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleClaimNotFoundException(CreditCardNotFoundException ex, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(new Date(), ex.getLocalizedMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
}

package br.com.brainweb.interview.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.brainweb.interview.dto.ResponseErrorDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		log.info("Hero is not valid.");
		
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });		

		ResponseErrorDTO responseErrorDTO = ResponseErrorDTO.builder().code(1).description("Hero is not valid.").errors(errors).build();		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(responseErrorDTO);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		log.info("Hero is required.");

		ResponseErrorDTO responseErrorDTO = ResponseErrorDTO.builder().code(2).description("Hero is required.").build();		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(responseErrorDTO);		
	}	
	
	
	@ExceptionHandler(HeroExistsException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ResponseEntity<ResponseErrorDTO> handing(HeroExistsException exception) {

		log.info("Hero exists.");

		ResponseErrorDTO responseErrorDTO = ResponseErrorDTO.builder().code(3).description("Hero exists.").build();		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(responseErrorDTO);
	}	

	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ResponseErrorDTO> handing(NotFoundException exception) {

		log.info("Hero not found.");

		ResponseErrorDTO responseErrorDTO = ResponseErrorDTO.builder().code(4).description("Hero not found.").build();		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseErrorDTO);
	}	
}

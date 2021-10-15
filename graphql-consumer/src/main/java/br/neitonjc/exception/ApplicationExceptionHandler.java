package br.neitonjc.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.neitonjc.dto.ExceptionDTO;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(IOException.class)
	public ResponseEntity<ExceptionDTO> handleIOException(Exception e){
		ExceptionDTO erro = new ExceptionDTO(HttpStatus.NOT_FOUND.value(), "Não Encontrado.");
		return new ResponseEntity<ExceptionDTO>(erro, HttpStatus.NOT_FOUND);
	}
	
}

package com.example.addressbook.exceptions;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.addressbook.dto.ResponceDTO;

import lombok.extern.slf4j.Slf4j;



@ControllerAdvice
@Slf4j
public class AddressBookExceptionHandler {

private static final String message = "Exception while processing REST Request ";
	
	/**
	 * Method to handle any Exception thrown
	 * @param exception
	 * @return : ResponseEntity of Exception
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity< ResponceDTO> handlerMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errMsg = errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
		 ResponceDTO responseDTO = new  ResponceDTO(message, errMsg);
		return new ResponseEntity< ResponceDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Method to handle when user Id not found
	 * @param exception
	 * @return : Response Entity of Exception
	 */
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity< ResponceDTO> handlerEmployeePayrollException(NoSuchElementException exception) {
		 ResponceDTO responseDTO = new  ResponceDTO(message, exception.getMessage());
		return new ResponseEntity< ResponceDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}

}

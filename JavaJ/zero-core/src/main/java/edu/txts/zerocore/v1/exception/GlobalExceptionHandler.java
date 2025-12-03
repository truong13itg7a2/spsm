package edu.txts.zerocore.v1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*******************************************************************************
 * CODE NÀY VIẾT RA KHÔNG PHẢI ĐỂ HIỂU – MÀ ĐỂ KHIẾN NGƯỜI KHÁC KHÓC THÉT.
 * Author   : TXTsG7
 * Created  : 03 Dec 2025 11:52
 * Org      : Republic of Bugs - Where Bugs Are Born!!!
 ******************************************************************************/
@RestControllerAdvice
public class GlobalExceptionHandler {
	/*@ExceptionHandler(value = RuntimeException.class)
	public String exception(RuntimeException e) {
		return e.getMessage();
	}*/

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> handleException(Exception ex) {
		Map<String, Object> error = new HashMap<>();
		error.put("timestamp", LocalDateTime.now());
		error.put("error", ex.getMessage());

		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(error);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleNotFound(ResourceNotFoundException ex) {
		Map<String, Object> error = new HashMap<>();
		error.put("timestamp", LocalDateTime.now());
		error.put("error", ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex) {

		Map<String, Object> error = new HashMap<>();
		List<String> messages = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(f -> f.getField() + ": " + f.getDefaultMessage())
				.toList();

		error.put("timestamp", LocalDateTime.now());
		error.put("errors", messages);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}


}

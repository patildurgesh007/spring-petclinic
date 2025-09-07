package org.springframework.samples.petclinic.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Map<String, Object>> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT) // 409 Conflict
			.body(Map.of("timestamp", LocalDateTime.now().toString(), "status", 409, "error", "Conflict", "message",
					"Record cannot be deleted because it is referenced by other records"));
	}

	@ExceptionHandler(RecordAlreadyExistsException.class)
	public ResponseEntity<Map<String, Object>> handleRecordAlreadyExistsException(RecordAlreadyExistsException ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT) // 409 Conflict
			.body(Map.of("timestamp", LocalDateTime.now().toString(), "status", 409, "error", "Conflict", "message",
				ex.getMessage()));
	}


	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND) // 409 Conflict
			.body(Map.of("timestamp", LocalDateTime.now().toString(), "status", 404, "error", "NOT FOUND", "message",
				ex.getMessage()));
	}


}

package org.springframework.samples.petclinic.exception;

public class RecordAlreadyExistsException extends RuntimeException {
	public RecordAlreadyExistsException(String message) {
		super(message);
	}
}

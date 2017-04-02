package com.gigamog.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorizedHttpException extends RuntimeException {
	/*
	 * this class allowed me to throw exceptions to http code so it's kinda cool
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnauthorizedHttpException(String errorMessage) {
		super(errorMessage);
	}

}

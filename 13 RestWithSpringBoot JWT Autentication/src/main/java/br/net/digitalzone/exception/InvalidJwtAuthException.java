package br.net.digitalzone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.security.core.AuthenticationException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidJwtAuthException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	public InvalidJwtAuthException(String exception) {
		super(exception);
	}

}

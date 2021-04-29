package com.projeto.appalergias.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class UsuarioDuplicadoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	
	public UsuarioDuplicadoException(String msg) {
		super(msg);
	}

//	public UsuarioDuplicadoException(String msg, Throwable cause) {
//		super(msg, cause);
//	}

}

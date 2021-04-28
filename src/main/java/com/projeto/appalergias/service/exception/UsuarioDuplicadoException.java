package com.projeto.appalergias.service.exception;

public class UsuarioDuplicadoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsuarioDuplicadoException(String msg) {
		super(msg);
	}

	public UsuarioDuplicadoException(String msg, Throwable cause) {
		super(msg, cause);
	}

}

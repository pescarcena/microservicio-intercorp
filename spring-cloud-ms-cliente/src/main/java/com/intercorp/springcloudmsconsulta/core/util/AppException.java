package com.intercorp.springcloudmsconsulta.core.util;

public class AppException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public AppException(String message) {
		super(message);
	}
}
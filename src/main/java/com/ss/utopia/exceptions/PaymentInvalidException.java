package com.ss.utopia.exceptions;

public class PaymentInvalidException extends Exception {

	private static final long serialVersionUID = 1L;

	public PaymentInvalidException() {}
	public PaymentInvalidException(String message) {
		super(message);
	}
}

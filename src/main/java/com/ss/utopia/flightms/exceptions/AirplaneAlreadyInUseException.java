package com.ss.utopia.flightms.exceptions;

public class AirplaneAlreadyInUseException extends Exception {

	private static final long serialVersionUID = 1L;

	public AirplaneAlreadyInUseException() {}
	public AirplaneAlreadyInUseException(String message) {
		super(message);
	}
}
package com.ss.utopia.flightms.exceptions;

public class FlightAlreadyExistsException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public FlightAlreadyExistsException() {}
	public FlightAlreadyExistsException(String message) {
		super(message);
	}
}

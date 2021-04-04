package com.ss.utopia.flightms.exceptions;

public class RouteNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public RouteNotFoundException() {}
	public RouteNotFoundException(String message) {
		super(message);
	}
}

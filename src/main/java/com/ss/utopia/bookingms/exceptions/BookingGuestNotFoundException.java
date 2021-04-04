package com.ss.utopia.bookingms.exceptions;

public class BookingGuestNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public BookingGuestNotFoundException() {}
	public  BookingGuestNotFoundException(String message) {
		super(message);
	}
}

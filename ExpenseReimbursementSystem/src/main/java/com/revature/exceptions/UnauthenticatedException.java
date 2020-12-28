package com.revature.exceptions;

public class UnauthenticatedException extends AbstractHttpException {

	public UnauthenticatedException() {
		super("Please log in!", 401);

	}

}

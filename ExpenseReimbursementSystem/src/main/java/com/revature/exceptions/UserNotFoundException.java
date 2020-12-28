package com.revature.exceptions;

public class UserNotFoundException extends AbstractHttpException {

	public UserNotFoundException() {
		super("Wrong user or password", 404);
	}

}

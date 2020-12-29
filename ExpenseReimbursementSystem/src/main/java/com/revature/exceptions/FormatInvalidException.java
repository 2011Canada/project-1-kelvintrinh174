package com.revature.exceptions;

public class FormatInvalidException extends AbstractHttpException {

	public FormatInvalidException() {
		super("Input is invalid", 422);
	}

}

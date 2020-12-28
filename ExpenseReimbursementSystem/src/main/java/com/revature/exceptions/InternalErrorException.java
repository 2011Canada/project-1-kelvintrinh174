package com.revature.exceptions;

public class InternalErrorException extends AbstractHttpException {

	public InternalErrorException() {
		super("Internal Server Error", 500);

	}
		
}

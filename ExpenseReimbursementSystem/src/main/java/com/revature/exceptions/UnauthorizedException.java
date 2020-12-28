package com.revature.exceptions;

public class UnauthorizedException extends AbstractHttpException {

	public UnauthorizedException() {
		super("You're not authorized to do this", 403);
		// TODO Auto-generated constructor stub
	}

}

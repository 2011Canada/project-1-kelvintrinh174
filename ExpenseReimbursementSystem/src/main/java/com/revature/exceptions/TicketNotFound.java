package com.revature.exceptions;

public class TicketNotFound extends AbstractHttpException {

	public TicketNotFound() {
		super("Ticket Not Found", 404);
		
	}

}

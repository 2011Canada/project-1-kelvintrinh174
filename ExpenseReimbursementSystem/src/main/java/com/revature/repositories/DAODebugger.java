package com.revature.repositories;

public class DAODebugger {

	public static void main(String[] args) {
		UserDAO ud = new UserDAO();
		ud.findByUserName(null);
		System.out.println("Connection Good");

	}

}

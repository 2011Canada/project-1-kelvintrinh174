package com.revature.repositories;

import com.revature.models.User;

public class DAODebugger {

	public static void main(String[] args) {
		UserDAO ud = new UserDAO();
		//ud.findByUserName(null);
		System.out.println("Connection Good");
		User u = new User();
	    ReimbursementDAO rd = new ReimbursementDAO();
		//u.setUserName("kelvintrinh");
		//u.setPassword("12345");
		u.setUserId(1);
		//System.out.println(ud.findByUserName("kelvintrinh", "12345"));
		System.out.println(rd.findAllByUserId(1));
	}

}

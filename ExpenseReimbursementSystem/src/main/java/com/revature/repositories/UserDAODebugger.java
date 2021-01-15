package com.revature.repositories;

import java.security.NoSuchAlgorithmException;

import com.revature.models.User;

public class UserDAODebugger {

	public UserDAODebugger() {
		
	}

	public static void main(String[] args) {
		UserDAO ud = new UserDAO();
		User u = new User();
		u.setEmail("bob@gmail.com");
		u.setUserName("Bob");
		try {
			u.setPassword("12345");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		u.setUserRoleId(2);
		u.setFirstName("Bob");
		u.setLastName("Culinan");
		System.out.println(ud.createUser(u));
		
		//User u = new User();
		u.setEmail("kelvintrinh@gmail.com");
		u.setUserName("kelvintrinh");
		try {
			u.setPassword("12345");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		u.setUserRoleId(1);
		u.setFirstName("Kelvin");
		u.setLastName("Trinh");
		System.out.println(ud.createUser(u));
		
		//User u = new User();
		u.setEmail("max123@gmail.com");
		u.setUserName("max123");
		try {
			u.setPassword("12345");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		u.setUserRoleId(1);
		u.setFirstName("Max");
		u.setLastName("A");
		System.out.println(ud.createUser(u));
		
	}

}

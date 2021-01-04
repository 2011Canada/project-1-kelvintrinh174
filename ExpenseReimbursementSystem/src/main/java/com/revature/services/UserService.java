package com.revature.services;

import java.security.NoSuchAlgorithmException;

import com.revature.models.Credentials;
import com.revature.models.User;
import com.revature.repositories.UserDAO;

public class UserService implements IUserService {
	
	private UserDAO ud;
	
	public UserService(UserDAO ud) {
		super();
		this.ud = ud;
	}



	@Override
	public User logIn(Credentials credential) {
		User u = new User();
		u.setUserName(credential.getUsername());
		try {
			u.setPassword(credential.getPassword());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		u = ud.findByUserName(u);
		return u;
	}

}

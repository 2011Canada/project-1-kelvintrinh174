package com.revature.services;

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
		User u = ud.findByUserName(credential.getUsername(),credential.getPassword());
		return u;
	}

}

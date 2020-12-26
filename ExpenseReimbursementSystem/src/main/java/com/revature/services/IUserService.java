package com.revature.services;

import java.util.List;

import com.revature.models.Credentials;
import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface IUserService {
	
	public User logIn(Credentials credential);
}

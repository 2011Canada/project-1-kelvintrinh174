package com.revature.repositories;

import com.revature.models.Credentials;
import com.revature.models.User;

public interface IUserDAO {
	   public User findByUserName(Credentials credential);
	   
}

package com.revature.repositories;

import com.revature.models.User;

public interface IUserDAO {
	   public User findByUserName(String username, String password);
	   
}

package com.revature.repositories;

import com.revature.models.User;

public interface IUserDAO {
	   public User findByUserName(User user);
	   
	   public int createUser(User user);
	   
}

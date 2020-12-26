package com.revature.repositories;

import java.sql.Connection;

import com.revature.models.Credentials;
import com.revature.models.User;
import com.revature.utilities.ConnectionFactory;

public class UserDAO implements IUserDAO {
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();

	@Override
	public User findByUserName(Credentials credential) {
		Connection conn = cf.getConnection();
		return null;
	}

}

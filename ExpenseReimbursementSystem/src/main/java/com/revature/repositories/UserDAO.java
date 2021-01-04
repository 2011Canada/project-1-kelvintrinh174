package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.utilities.ConnectionFactory;

public class UserDAO implements IUserDAO {
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	@Override
	public int createUser(User user) {
		Connection conn = cf.getConnection();
		try {
			String sql = "insert into \"ers_users\" (ers_username,ers_password,user_email,"
					   + "user_role_id,user_first_name,user_last_name) "
					   + "values (?,?,?,?,?,?) returning \"ers_users_id\";";
			PreparedStatement createUser = conn.prepareStatement(sql);
			createUser.setString(1, user.getUserName());
			createUser.setString(2, user.getPassword());
			createUser.setString(3, user.getEmail());
			createUser.setInt(4, user.getUserRoleId());
			createUser.setString(5, user.getFirstName());
			createUser.setString(6, user.getLastName());
			ResultSet res = createUser.executeQuery();

			if(res.next()) {

				int userId = res.getInt("ers_users_id");
				return userId;
			} else {
				throw new SQLException();
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InternalErrorException();			
		}
		finally {
			
			try {
				cf.releaseConnection(conn);
			} catch (SQLException e) {	
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public User findByUserName(User user) {
		Connection conn = cf.getConnection();
		try {
			String sql = "select * from ers_users eu\r\n"
					+ "inner join ers_user_roles eur on eu.user_role_id = eur.ers_user_role_id \r\n"
					+ "where ers_username = ? and ers_password = ?;";
			PreparedStatement getUser = conn.prepareStatement(sql);
			getUser.setString(1, user.getUserName());
			getUser.setString(2, user.getPassword());
			ResultSet res = getUser.executeQuery();
			if(res.next()) {

				User u = new User();
				u.setEmail(res.getString("user_email"));
				u.setUserName(res.getString("ers_username"));
				u.setUserId(res.getInt("ers_users_id"));
				u.setUserRoleId(res.getInt("ers_user_role_id"));
				u.setUserRole(res.getString("user_role"));
				u.setFirstName(res.getString("user_first_name"));
				u.setLastName(res.getString("user_last_name"));
				return u;
			} else {
				throw new UserNotFoundException();
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InternalErrorException();			
		}
		finally {
			
			try {
				cf.releaseConnection(conn);
			} catch (SQLException e) {	
				e.printStackTrace();
			}
		}
				
	}

	

}

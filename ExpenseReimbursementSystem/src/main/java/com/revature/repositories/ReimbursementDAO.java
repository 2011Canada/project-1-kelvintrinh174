   package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.InternalErrorException;
import com.revature.models.Reimbursement;
import com.revature.utilities.ConnectionFactory;

public class ReimbursementDAO implements IReimbursementDAO {
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();

	@Override
	public List<Reimbursement> findAllByUserId(int userId) {
		Connection conn = cf.getConnection();
		List<Reimbursement> list = new ArrayList<>();
		try { 
			
			String sql = "select * from ers_reimbursement er \r\n"
					+ "inner join ers_reimbursement_status ers on er.reimb_status_id = ers.reimb_status_id\r\n"
					+ "inner join ers_reimbursement_type ert on er.reimb_type_id = ert.reimb_type_id\r\n"
					+ "where reimb_author = ?;";
			PreparedStatement findAllTickets = conn.prepareStatement(sql);
			findAllTickets.setInt(1, userId);
			
			ResultSet res = findAllTickets.executeQuery();
			while(res.next()) {
				Reimbursement ticket = new Reimbursement();
				ticket.setAmount(res.getDouble("reimb_amount"));
				ticket.setDateSubmitted(res.getString("reimb_submited"));
				ticket.setDateResolved(res.getString("reimb_resolved"));
				ticket.setDescription(res.getString("reimb_description"));
				ticket.setAuthorId(res.getInt("reimb_author"));
				ticket.setReimbId(res.getInt("reimb_id"));
				ticket.setStatusId(res.getInt("reimb_status_id"));
				ticket.setReimbStatus(res.getString("reimb_status"));
				ticket.setResolverId(res.getInt("reimb_resolver"));
				ticket.setTypeId(res.getInt("reimb_type_id"));
				ticket.setReimbType(res.getString("reimb_type"));
				list.add(ticket);			
			}
			
			return list;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InternalErrorException();	
		} finally {
			try {
				cf.releaseConnection(conn);
			} catch (SQLException e) {	
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<Reimbursement> findAllByStatusId(int statusId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement findById(int reimbId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement saveOne(Reimbursement reimb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateOne(int reimbId) {
		// TODO Auto-generated method stub
		return false;
	}

}

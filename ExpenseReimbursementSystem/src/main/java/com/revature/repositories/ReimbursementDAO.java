   package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.TicketNotFound;
import com.revature.models.Reimbursement;
import com.revature.utilities.ConnectionFactory;

public class ReimbursementDAO implements IReimbursementDAO {
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
    //find all tickets of an employee
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
				ticket.setReceipt(res.getBytes("reimb_receipt"));
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
	
	//add a new ticket
	@Override
	public Reimbursement saveOne(Reimbursement reimb) {
		Connection conn = cf.getConnection();
		
		try {
			String sql = "insert into \"ers_reimbursement\" "
					+ "(reimb_amount,reimb_submited,reimb_author,"
					+ "reimb_status_id,reimb_type_id,reimb_description,reimb_receipt)\r\n"
					+ "values (?,?,?,?,?,?,?) returning \"reimb_id\";";
			PreparedStatement addNewTicket = conn.prepareStatement(sql);
			LocalDateTime now = LocalDateTime.now();
		
			Timestamp timestamp = Timestamp.valueOf(now);
			addNewTicket.setDouble(1, reimb.getAmount());
			addNewTicket.setTimestamp(2, timestamp);
			addNewTicket.setInt(3, reimb.getAuthorId());
			addNewTicket.setInt(4, reimb.getStatusId());
			addNewTicket.setInt(5, reimb.getTypeId());
			addNewTicket.setString(6, reimb.getDescription());
			addNewTicket.setBytes(7, reimb.getReceipt());
			
			ResultSet res = addNewTicket.executeQuery();
			int reimbId;
			if(res.next()) {
				reimbId = res.getInt("reimb_id");
			} else {
				throw new SQLException();
			}
			
			reimb.setReimbId(reimbId);
			return reimb;
			
		} catch(SQLException e) {
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
	
	//view ticket by Id
	@Override
	public Reimbursement findById(int reimbId) {
		
		Connection conn = cf.getConnection();
		Reimbursement ticket;
		try { 
			
			String sql = "select * from ers_reimbursement er \r\n"
					+ "inner join ers_reimbursement_status ers on er.reimb_status_id = ers.reimb_status_id\r\n"
					+ "inner join ers_reimbursement_type ert on er.reimb_type_id = ert.reimb_type_id\r\n"
					+ "where reimb_id = ?;";
			PreparedStatement getATicket = conn.prepareStatement(sql);
			getATicket.setInt(1, reimbId);
			
			ResultSet res = getATicket.executeQuery();
			if(res.next()) {
				ticket = new Reimbursement();
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
				ticket.setReceipt(res.getBytes("reimb_receipt"));
				return ticket;			
			} 
			else {
				throw new TicketNotFound();
			}
								    			
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
		
		return null;
	}
    //list all tickets
	@Override
	public List<Reimbursement> findAll() {
		Connection conn = cf.getConnection();
		List<Reimbursement> list = new ArrayList<>();
		String sql = "select * from ers_reimbursement er \r\n"
				+ "inner join ers_reimbursement_status ers on er.reimb_status_id = ers.reimb_status_id\r\n"
				+ "inner join ers_reimbursement_type ert on er.reimb_type_id = ert.reimb_type_id\r\n"
				+ "inner join ers_users eu on eu.ers_users_id = er.reimb_author;";
		try {
			PreparedStatement listAllTickets = conn.prepareStatement(sql);
			
			
			ResultSet res = listAllTickets.executeQuery();
			while(res.next()) {
				Reimbursement ticket = new Reimbursement();
				ticket.setAmount(res.getDouble("reimb_amount"));
				ticket.setDateSubmitted(res.getString("reimb_submited"));
				ticket.setDateResolved(res.getString("reimb_resolved"));
				ticket.setDescription(res.getString("reimb_description"));
				ticket.setAuthorId(res.getInt("reimb_author"));
				ticket.setAuthorName(res.getString("user_first_name") +" "+res.getString("user_last_name"));
				ticket.setAuthorEmail(res.getString("user_email"));
				ticket.setReimbId(res.getInt("reimb_id"));
				ticket.setStatusId(res.getInt("reimb_status_id"));
				ticket.setReimbStatus(res.getString("reimb_status"));
				ticket.setResolverId(res.getInt("reimb_resolver"));
				ticket.setTypeId(res.getInt("reimb_type_id"));
				ticket.setReimbType(res.getString("reimb_type"));
				ticket.setReceipt(res.getBytes("reimb_receipt"));
				list.add(ticket);			
			}
			
			return list;
		} catch(SQLException e) {
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
     
	//update ticket status, resolver, and date  
	@Override
	public boolean updateOne(Reimbursement re) {
		Connection conn = cf.getConnection();
		String sql = "update ers_reimbursement "
				+ "set reimb_resolved = ?, reimb_resolver = ?, reimb_status_id =? "
				+ "where reimb_id = ?;";
		try {
			PreparedStatement updateTicket = conn.prepareStatement(sql);
			updateTicket.setTimestamp(1, Timestamp.valueOf(re.getDateResolved()));
			updateTicket.setInt(2, re.getResolverId());
			updateTicket.setInt(3, re.getStatusId());
			updateTicket.setInt(4, re.getReimbId());
			
			
			if(updateTicket.executeUpdate() > 0) {
				return true;
			}
			else {
				throw new SQLException();
			}
			
			
			
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

}

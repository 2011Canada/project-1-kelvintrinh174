   package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.utilities.ConnectionFactory;

public class ReimbursementDAO implements IReimbursementDAO {
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();

	@Override
	public List<Reimbursement> findAllByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
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

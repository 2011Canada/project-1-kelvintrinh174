package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.repositories.ReimbursementDAO;

public class ReimbursementService implements IReimbursementService {
	
	private ReimbursementDAO rid;
	
	

	public ReimbursementService(ReimbursementDAO rid) {
		super();
		this.rid = rid;
	}

	@Override
	public List<Reimbursement> findAllRequestsByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> findAllRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> findAllRequestsByStatusId(int statusId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement findRequestById(int reimbId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement createARequest(Reimbursement reimb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateRequestDetail(int reimbId) {
		// TODO Auto-generated method stub
		return false;
	}

}

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
		List<Reimbursement> list = rid.findAllByUserId(userId);
		return list.size() > 0 ? list : null;
	}

	@Override
	public List<Reimbursement> findAllRequest() {
		List<Reimbursement> list = rid.findAll();
		return list.size() > 0 ? list : null;
	}

	@Override
	public List<Reimbursement> findAllRequestsByStatusId(int statusId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement findRequestById(int reimbId) {
		Reimbursement re = rid.findById(reimbId);
		return re;
	}

	@Override
	public Reimbursement createARequest(Reimbursement reimb) {
		Reimbursement re = rid.saveOne(reimb);
		return re;
	}

	@Override
	public boolean updateRequestDetail(Reimbursement reimb) {		
		return rid.updateOne(reimb);
	}

}

package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;

public interface IReimbursementService {
	public List<Reimbursement> findAllRequestsByUserId(int userId);
	public List<Reimbursement> findAllRequest();
	public List<Reimbursement> findAllRequestsByStatusId(int statusId);
	public Reimbursement findRequestById(int reimbId);
	public Reimbursement createARequest(Reimbursement reimb);
	public boolean updateRequestDetail(Reimbursement reimb);
}

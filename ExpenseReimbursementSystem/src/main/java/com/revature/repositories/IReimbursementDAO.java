package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimbursement;

public interface IReimbursementDAO {
	   public List<Reimbursement> findAllByUserId(int userId);
	   public List<Reimbursement> findAllByStatusId(int statusId);
	   public List<Reimbursement> findAll();
	   public Reimbursement findById(int reimbId);
	   public Reimbursement saveOne(Reimbursement reimb);
	   public boolean updateOne(int reimbId);
	   
}

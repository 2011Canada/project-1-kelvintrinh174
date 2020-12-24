package com.revature.models;

public class Reimbursement {
	   private int reimbId;
	   private double amount;
	   private String dateSubmitted;
	   private String dateResolved;
	   private String description;
	   private byte[] receipt;
	   private int authorId;
	   private int resolverId;
	   private int statusId;
	   private ReimbursementStatus reimbStatus;
	   private int typeId;
	   private ReimbursementType reimbType;

	   public Reimbursement() {
		super();
		
	   }

		public Reimbursement(int reimbId, double amount, String dateSubmitted, String dateResolved, String description,
				byte[] receipt, int authorId, int resolverId, int statusId, int typeId) {
			super();
			this.reimbId = reimbId;
			this.amount = amount;
			this.dateSubmitted = dateSubmitted;
			this.dateResolved = dateResolved;
			this.description = description;
			this.receipt = receipt;
			this.authorId = authorId;
			this.resolverId = resolverId;
			this.statusId = statusId;
			this.typeId = typeId;
		}

		public int getReimbId() {
			return reimbId;
		}
		

		public String getReimbStatus() {
			return reimbStatus.toString();
		}

		public void setReimbStatus(String reimbStatus) {
			
			for(ReimbursementStatus rs : ReimbursementStatus.values()) {
				if(reimbStatus.equals(rs.toString())) {
					this.reimbStatus = rs;
					return;
				}
			}

		}

		public String getReimbType() {
			return reimbType.toString();
		}

		public void setReimbType(String reimbType) {
			for(ReimbursementType rt : ReimbursementType.values()) {
				if(reimbType.equals(rt.toString())) {
					this.reimbType = rt;
					return;
				}
			}
		}

		public void setReimbId(int reimbId) {
			this.reimbId = reimbId;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getDateSubmitted() {
			return dateSubmitted;
		}

		public void setDateSubmitted(String dateSubmitted) {
			this.dateSubmitted = dateSubmitted;
		}

		public String getDateResolved() {
			return dateResolved;
		}

		public void setDateResolved(String dateResolved) {
			this.dateResolved = dateResolved;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public byte[] getReceipt() {
			return receipt;
		}

		public void setReceipt(byte[] receipt) {
			this.receipt = receipt;
		}

		public int getAuthorId() {
			return authorId;
		}

		public void setAuthorId(int authorId) {
			this.authorId = authorId;
		}

		public int getResolverId() {
			return resolverId;
		}

		public void setResolverId(int resolverId) {
			this.resolverId = resolverId;
		}

		public int getStatusId() {
			return statusId;
		}

		public void setStatusId(int statusId) {
			this.statusId = statusId;
		}

		public int getTypeId() {
			return typeId;
		}

		public void setTypeId(int typeId) {
			this.typeId = typeId;
		}
		
		
	   
	   
	   
	   
	   
}

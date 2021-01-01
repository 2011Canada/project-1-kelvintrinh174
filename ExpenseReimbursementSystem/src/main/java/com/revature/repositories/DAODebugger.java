package com.revature.repositories;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public class DAODebugger {

	public static void main(String[] args) {
		UserDAO ud = new UserDAO();
		//ud.findByUserName(null);
		System.out.println("Connection Good");
		User u = new User();
	    ReimbursementDAO rd = new ReimbursementDAO();
	    System.out.println(rd.findAll());
		//u.setUserName("kelvintrinh");
		//u.setPassword("12345");
		//u.setUserId(1);
		//System.out.println(ud.findByUserName("kelvintrinh", "12345"));
		//System.out.println(rd.findAllByUserId(1));
	    //System.out.println(rd.findById(1));
//	    Reimbursement re = new Reimbursement();
//	    re.setReimbId(2);
//	    re.setDateResolved("2020-12-31 10:04:29");
//	    re.setResolverId(2);
//	    re.setStatusId(3);
//	    System.out.println(rd.updateOne(re));
	    
	    
//	    Reimbursement re = new Reimbursement();
//	    re.setAmount(30);
//	    re.setDateSubmitted("2020-12-30 11:20:30");
//	    re.setAuthorId(1);
//	    re.setStatusId(1);
//	    re.setTypeId(3);
//	    re.setDescription("Test");
//	    
//	    InputStream is =null;
//	    ByteArrayOutputStream os = null;
//	    File testFile = new File("p1_Requirement.pdf");
//	    if(testFile.exists()) {
//	    	try {
//		    	is = new FileInputStream(testFile);
//		    	os = new ByteArrayOutputStream();
//		    	byte[] buffer = new byte[1024];
//		    	while(is.read(buffer)!=-1) {
//		    		os.write(buffer);
//		    	}
//		    	
//		    	re.setReceipt(os.toByteArray());
//				os.flush();
//				os.close();
//				is.close();
//		    } catch (IOException e) {
//				e.printStackTrace();
//			} 
//		    
//		    System.out.println(rd.saveOne(re));
//			
//	    }
	    
	}

}

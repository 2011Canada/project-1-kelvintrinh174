package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.UnauthenticatedException;
import com.revature.exceptions.UnauthorizedException;
import com.revature.models.Reimbursement;
import com.revature.repositories.ReimbursementDAO;
import com.revature.services.IReimbursementService;
import com.revature.services.ReimbursementService;

public class ReimbursementController {
	  private IReimbursementService rs = new ReimbursementService(new ReimbursementDAO());
	  //private ObjectMapper om = new ObjectMapper();
	  
	  
	  public void getAllTicketEmployee(HttpServletRequest req,HttpServletResponse res) throws IOException{
		   int userId = Integer.parseInt(req.getParameter("userId"));
		   //System.out.println(userId);
		   HttpSession sess = req.getSession();
			
//			if(sess.getAttribute("User-Role") == null) {
//				throw new UnauthenticatedException();
//			} else if(!sess.getAttribute("User-Role").equals("EMPLOYEE")) {
//				throw new UnauthorizedException();
//			}
			List<Reimbursement> list = rs.findAllRequestsByUserId(userId);
			JSONArray ja = new JSONArray();
			if(list!=null) {
				for(Reimbursement re : list) {
					JSONObject jo = new JSONObject();
					jo.put("reimbId", re.getReimbId());
					jo.put("reimbType", re.getReimbType());
					ja.put(jo);
				}
			}
			
			
			
			//System.out.println(ja.toString());
			res.setStatus(200);
			res.setContentType("application/json");
			res.getWriter().write(ja.toString());
	  }
	  
}

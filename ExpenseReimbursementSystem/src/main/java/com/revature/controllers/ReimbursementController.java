package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.revature.exceptions.FormatInvalidException;
import com.revature.exceptions.UnauthenticatedException;
import com.revature.exceptions.UnauthorizedException;
import com.revature.models.Reimbursement;
import com.revature.repositories.ReimbursementDAO;
import com.revature.services.IReimbursementService;
import com.revature.services.ReimbursementService;

public class ReimbursementController {
	  private IReimbursementService rs = new ReimbursementService(new ReimbursementDAO());
	  private ObjectMapper om = new ObjectMapper();
	  
	  
	  public void getAllTicketEmployee(HttpServletRequest req,HttpServletResponse res) throws IOException{
		  
	    HttpSession sess = req.getSession();
	  	
		if(sess.getAttribute("User-Role") == null) {
			throw new UnauthenticatedException();
		} else if(!sess.getAttribute("User-Role").equals("EMPLOYEE")) {
			throw new UnauthorizedException();
		}
		  int userId; 
		  try {
			   userId = Integer.parseInt(req.getParameter("userId"));
		  } catch(NumberFormatException nfe) {
			  //nfe.printStackTrace();
			  throw new FormatInvalidException();
		  } catch (NullPointerException npe) {
		    	//npe.printStackTrace();
		    	throw new FormatInvalidException();
		  }
		  
		   
		    
			List<Reimbursement> list = rs.findAllRequestsByUserId(userId);
			JSONArray ja = new JSONArray();
			if(list!=null) {
				for(Reimbursement re : list) {
					JSONObject jo = new JSONObject();
					jo.put("reimbId", re.getReimbId());
					jo.put("amount", re.getAmount());
					jo.put("reimbType", re.getReimbType());
					jo.put("dateSubmitted", re.getDateSubmitted());
					jo.put("dateResolved", re.getDateResolved());
					jo.put("description", re.getDescription());
					//jo.put("receipt", re.getReceipt());
					jo.put("statusId", re.getStatusId());
					jo.put("reimbStatus", re.getReimbStatus());
					jo.put("typeId", re.getTypeId());
					jo.put("reimbType", re.getReimbType());
									
					ja.put(jo);
				}
			}
												
			res.setStatus(200);
			res.setContentType("application/json");
			res.getWriter().write(ja.toString());
	  }
	  
	  public void addNewTicket(HttpServletRequest req,HttpServletResponse res) throws IOException{
		    HttpSession sess = req.getSession();
			
			if(sess.getAttribute("User-Role") == null) {
				throw new UnauthenticatedException();
			} else if(!sess.getAttribute("User-Role").equals("EMPLOYEE")) {
				throw new UnauthorizedException();
			}	    
		    Reimbursement re;
		    try {
		    	re = om.readValue(req.getInputStream(), Reimbursement.class);
		    } catch(JsonParseException jpe) {
		    	jpe.printStackTrace();
		    	throw new FormatInvalidException();
		    } catch(InvalidFormatException ife) {
		    	ife.printStackTrace();
		    	throw new FormatInvalidException();
		    }

		    rs.createARequest(re);
		    JSONObject jo = new JSONObject();
		    jo.put("msg", "Your ticket request has been added");
			res.setStatus(201);
			res.setContentType("application/json");
			res.getWriter().write(jo.toString());
	  }
	  
	  public void updateTicket(HttpServletRequest req,HttpServletResponse res) throws IOException {
		   HttpSession sess = req.getSession();
			
			if(sess.getAttribute("User-Role") == null) {
				throw new UnauthenticatedException();
			} else if(!sess.getAttribute("User-Role").equals("MANAGER")) {
				throw new UnauthorizedException();
			}
		    Reimbursement re;
		    try {
		    	re = om.readValue(req.getInputStream(), Reimbursement.class);
		    } catch(JsonParseException jpe) {		    	
		    	throw new FormatInvalidException();
		    } catch(InvalidFormatException ife) {
		    	throw new FormatInvalidException();
		    }
		    
		    rs.updateRequestDetail(re);
		    JSONObject jo = new JSONObject();
		    jo.put("msg", "The ticket request has been updated");
			res.setStatus(200);
			res.setContentType("application/json");
			res.getWriter().write(jo.toString());
	  }
	  
	  public void getTicketById(HttpServletRequest req,HttpServletResponse res) throws IOException{
		   HttpSession sess = req.getSession();
			
			if(sess.getAttribute("User-Role") == null) {
				throw new UnauthenticatedException();
			} else if(!sess.getAttribute("User-Role").equals("MANAGER")) {
				throw new UnauthorizedException();
			}
		  int ticketId;
		  try {
			  ticketId = Integer.parseInt(req.getParameter("ticketId"));
		  } catch(NumberFormatException nfe) {
			  //nfe.printStackTrace();
			  throw new FormatInvalidException();
		  } catch (NullPointerException npe) {
		    	//npe.printStackTrace();
		    	throw new FormatInvalidException();
		  }

		  
		  Reimbursement re = rs.findRequestById(ticketId);
		  res.setStatus(200);
		  res.setContentType("application/json");
		  res.getWriter().write(om.writeValueAsString(re));
	  }

	  public void getAllTicket(HttpServletRequest req,HttpServletResponse res) throws IOException{
		  
		   HttpSession sess = req.getSession();
			
			if(sess.getAttribute("User-Role") == null) {
				throw new UnauthenticatedException();
			} else if(!sess.getAttribute("User-Role").equals("MANAGER")) {
				throw new UnauthorizedException();
			}
		  List<Reimbursement> list = rs.findAllRequest();
			JSONArray ja = new JSONArray();
			if(list!=null) {
				for(Reimbursement re : list) {
					JSONObject jo = new JSONObject();
					jo.put("reimbId", re.getReimbId());
					jo.put("amount", re.getAmount());
					jo.put("reimbType", re.getReimbType());
					jo.put("dateSubmitted", re.getDateSubmitted());
					jo.put("dateResolved", re.getDateResolved());
					jo.put("description", re.getDescription());
					//jo.put("receipt", re.getReceipt());
					jo.put("statusId", re.getStatusId());
					jo.put("reimbStatus", re.getReimbStatus());
					jo.put("typeId", re.getTypeId());
					jo.put("reimbType", re.getReimbType());
					jo.put("authorName", re.getAuthorName());
					jo.put("authorEmail", re.getAuthorEmail());
									
					ja.put(jo);
				}
			}
												
			res.setStatus(200);
			res.setContentType("application/json");
			res.getWriter().write(ja.toString());
	  }


}

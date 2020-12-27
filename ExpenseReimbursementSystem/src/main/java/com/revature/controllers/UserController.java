package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Credentials;
import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.services.IUserService;
import com.revature.services.UserService;

public class UserController {
	
	  private IUserService us = new UserService(new UserDAO());
	  
	  private ObjectMapper om = new ObjectMapper();
	  
	  public void authentication(HttpServletRequest req,HttpServletResponse res) throws IOException{
		  	Credentials credential = om.readValue(req.getInputStream(), Credentials.class);
		  	User u = us.logIn(credential);
		  	
		  	HttpSession sess = req.getSession();
		  	sess.setAttribute("User-Role", u.getUserRole());
		  	
		  	res.setStatus(200);
		  	res.getWriter().write(om.writeValueAsString(u));
		  	
	  }
	  
}

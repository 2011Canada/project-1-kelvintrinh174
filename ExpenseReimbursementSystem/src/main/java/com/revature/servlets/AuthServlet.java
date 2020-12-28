package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.ErrorController;
import com.revature.controllers.UserController;

/**
 * Servlet implementation class FrontControllerServlet
 */
@WebServlet("/login")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserController userController = new UserController();
    private ErrorController errorController = new ErrorController();
    
    /**
    * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();   
    }
    
    protected void directControlRouter(HttpServletRequest req, HttpServletResponse res)
    throws ServletException,IOException
    {
		switch (req.getMethod()) {
				case "POST":{
					userController.authentication(req, res);
					break;
				}
				default:{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported for /login");
					break;
				}
			
			}
    	
    	
    }
    
    protected void directControl(HttpServletRequest req, HttpServletResponse res) throws IOException {
    		 try {
    			 directControlRouter(req,res );
    		 } catch (Throwable t) {
    			 errorController.handle(req, res, t);
    		 }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		directControl(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		directControl(request,response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

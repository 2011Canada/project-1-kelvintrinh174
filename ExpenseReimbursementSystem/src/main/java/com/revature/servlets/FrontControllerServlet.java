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
@WebServlet("/*")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserController userController = new UserController();
    private ErrorController errorController = new ErrorController();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControllerServlet() {
        super();   
    }
    
    protected void directControlRouter(HttpServletRequest req, HttpServletResponse res)
    throws ServletException,IOException
    {
    	String URI = req.getRequestURI().substring(req.getContextPath().length(),req.getRequestURI().length());
    	System.out.println(URI);
    	switch(URI) {
    		case "/login": {
    			switch (req.getMethod()) {
					case "POST":{
						userController.authentication(req, res);
						break;
					}
					default:{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
				
    			}
    			break;
    		}
    		
    		default:{
				res.setStatus(404);
				res.getWriter().write("No Such Resource");
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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		directControl(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doOptions(HttpServletRequest, HttpServletResponse)
	 */
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

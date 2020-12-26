package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontControllerServlet
 */
@WebServlet("/*")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
    		case "/helloworld": {
    			switch (req.getMethod()) {
					case "GET":{
						res.setStatus(200);
						res.getWriter().write("Welcome!");
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
    
    protected void directControl(HttpServletRequest request, HttpServletResponse response) throws IOException {
    		 try {
    			 directControlRouter(request,response);
    		 } catch (Throwable t) {
    			 
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

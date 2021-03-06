package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.ErrorController;
import com.revature.controllers.ReimbursementController;

/**
 * Servlet implementation class GetAllTicketServlet
 */
@WebServlet("/getallticket")
public class GetAllTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReimbursementController reimbursementController = new ReimbursementController();
    private ErrorController errorController = new ErrorController();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllTicketServlet() {
        super();
    }

    protected void directControlRouter(HttpServletRequest req, HttpServletResponse res)
    	    throws ServletException,IOException
    	    {
    			switch (req.getMethod()) {
    					case "GET":{
    						reimbursementController.getAllTicket(req, res);;
    						break;
    					}
    					default:{
    						res.setStatus(400);
    						res.getWriter().write("Method Not Supported for /getallticket");
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
    			directControl(request,response);
    		}

			/**
			 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
			 */
			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				directControl(request,response);
			}

}

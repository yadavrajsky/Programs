package com.RequestDispatch;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDispatching
 */
@WebServlet("/RequestDispatching")
public class RequestDispatching extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String username="akash";
       String password="Yadav@123";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDispatching() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		pw.println("<html><body>");
		pw.println("<form action='RequestDispatching' method='post'>");
		pw.println("Enter username<input type='text' name='username'><br>");
		pw.println("Enter password<input type='text' name='password'><br>");
		pw.println("<input type='submit' name='btn' value='Login'>");
		pw.println("</form></body></html>");
		if(request.getParameter("btn")!=null)
		{
			if(request.getParameter("username").equals(username) && request.getParameter("password").equals(password))
			{
				RequestDispatcher rd=request.getRequestDispatcher("HomePage");
				rd.forward(request, response);
				
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("HomePage");
				rd.include(request, response);
				
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		com.beans.User obj=new com.beans.User();
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		obj.setUname(uname);
		obj.setPassword(pass);
		
		com.helper.Validation obj2=new com.helper.Validation();
		
		if(obj2.validate(obj))
		{
			HttpSession s=request.getSession();
			s.setAttribute("uname", uname);
			s.setAttribute("pass", pass);
			RequestDispatcher rd=request.getRequestDispatcher("HomeLogin.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("Signin.jsp");
			rd.include(request, response);
			response.getWriter().println("<h5 style='text-align:center;'>Username or password is incorrect</h5>");
		}
		
	}

}

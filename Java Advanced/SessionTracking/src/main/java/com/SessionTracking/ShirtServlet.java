package com.SessionTracking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShirtServlet
 */
@WebServlet("/ShirtServlet")
public class ShirtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s=request.getSession(false);
		s.setAttribute("jname", request.getParameter("jname"));
		PrintWriter pw=response.getWriter();
		pw.println("<html>"
				+ "<head>Shirt</head>"
				+"<body>"
				+ "<form action=\"OutputServlet\" method='post'>"
				+ "Select Shirt : <select name='sname'>"
				+ "<option>Lewis</option>"
				+ "<option>Donear</option>"
				+ "<option>Khadi</option>"
				+ "<input type=\"submit\" value=\"Submit\">"
				+ "</select>"
				+ "</form>"
				+ "</body>"
				+ "</html>");
		
	}

}

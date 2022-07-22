package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.GetConnection;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		com.beans.RegisterBean obj=new com.beans.RegisterBean();
		obj.setUname(request.getParameter("uname"));
		obj.setPassword(request.getParameter("password"));
		obj.setMobile(Long.parseLong(request.getParameter("mobile")));
		obj.setAddress(request.getParameter("address"));
		Connection conn=new GetConnection().getConnection();
		try {
		PreparedStatement ps= conn.prepareStatement("insert into users values(?,?,?,?)");
		ps.setString(1,obj.getUname());
		ps.setString(2,obj.getPassword());
		ps.setLong(3, obj.getMobile());
		ps.setString(4,obj.getAddress());
		int x=ps.executeUpdate();
		if(x>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("Signin.jsp");
			rd.include(request, response);
			response.getWriter().println("<h3 style='text-align:center;'>Registred Successfully please Login Now</h3>");
					
		}
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
		}
		
	}



package com.Request.Redirect;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReqRedirect
 */
@WebServlet(urlPatterns = { "/ReqRedirect" }, initParams = {
		@WebInitParam(name = "driver", value = "com.mysql.cj.jdbc.Driver"),
		@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/"), 
		@WebInitParam(name = "db", value = "javaTP"),
		@WebInitParam(name = "user", value = "root"), @WebInitParam(name = "password", value = "toor")

}

)
public class ReqRedirect extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Connection conn;
	PreparedStatement ps;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReqRedirect() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		String driver=getInitParameter("driver");
		String db=getInitParameter("db");
		String user=getInitParameter("user");
		String password=getInitParameter("password");
		String url=getInitParameter("url");
		String u=url+db;
		try {
			Class.forName(driver);
			 conn=DriverManager.getConnection(u,user,password);
			 
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
String bname=request.getParameter("bname");
PrintWriter pw=response.getWriter();
pw.println("<html><body>");
pw.println("<form action='ReqRedirect' method='post'>");
pw.println("Enter book name: <input type='text' name='bname'><br>");
pw.println("<input type='submit' name='btn' value='Submit'>");
pw.println("</form></body></html>");

if(request.getParameter("btn")!=null)
{
	
	
try {
	ps=conn.prepareStatement("select * from books where bname=?");
	ps.setString(1, bname);
	ResultSet rs=ps.executeQuery();
	if(rs.next())
	{
		pw.println("<table>");
		pw.println("<tr>");
		pw.println("<th>Book ID</th>");
		pw.println("<th>Name</th>");
		pw.println("<th>Price</th>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<th>"+rs.getInt("bid")+"</th>");
		pw.println("<th>"+rs.getString("bname")+"</th>");
		pw.println("<th>"+rs.getInt("price")+"</th>");
		pw.println("</tr>");


		pw.println("</table>");
	}
	else
	{
		response.sendRedirect("https://google.com/search?q="+bname);
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}



	}
	}
}

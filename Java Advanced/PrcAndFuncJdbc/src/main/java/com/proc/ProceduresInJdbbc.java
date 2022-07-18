package com.proc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProceduresInJdbbc
 */
@WebServlet(
		urlPatterns = { "/ProceduresInJdbbc","/" }, 
		initParams = { 
				@WebInitParam(name = "driver", value = "com.mysql.cj.jdbc.Driver"), 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/"),
				@WebInitParam(name = "db", value = "javaTP"),
				@WebInitParam(name = "user", value = "root"),
				@WebInitParam(name = "password", value = "toor")

})
public class ProceduresInJdbbc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int []arr;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProceduresInJdbbc() {
		super();
		// TODO Auto-generated constructor stub
	}
	CallableStatement cs;
	Connection conn;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void init()
	{
	
		ServletConfig cfg=getServletConfig();
		String driver =cfg.getInitParameter("driver");
		String url=cfg.getInitParameter("url");
		String db=cfg.getInitParameter("db");
		String user=cfg.getInitParameter("user");
		String password=cfg.getInitParameter("password");
		String u=url+db;
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(u,user,password);
			cs=conn.prepareCall("{call addRecord(?,?,?)}");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		pw.println("<html><body>");
		pw.println("<form action='ProceduresInJdbbc' method='post'>");
		pw.println("Enter Book ID<input type='text' name='bid'><br>");
		pw.println("Enter Book Name<input type='text' name='bname'><br>");
		pw.println("Enter Book Price<input type='text' name='bprice'><br>");
		pw.println("<input type='submit' name='btn' value='Add'>");
		pw.println("<input type='submit' name='btn' value='Insert'>");
		pw.println("</form></body></html>");
		
		if(request.getParameter("btn")!=null)
		{	try {
			
			int bid=Integer.parseInt(request.getParameter("bid"));
			String bname=request.getParameter("bname");
			int bprice=Integer.parseInt(request.getParameter("bprice"));
			cs.setInt(1, bid);
			cs.setString(2, bname);
			cs.setInt(3, bprice);
			
			if(request.getParameter("btn").equals("Add"))
			{
				
				cs.addBatch();
				pw.println("Batch added successfully.");
				
			}
			else
			{
				cs.addBatch();
				arr=cs.executeBatch();
				pw.println("Record added successfully.");
			}
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
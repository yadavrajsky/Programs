package com.batchdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns = { "/BatchInsert" }, 
		initParams = { 
				@WebInitParam(name = "driver", value = "com.mysql.cj.jdbc.Driver"), 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/"),
				@WebInitParam(name = "db", value = "javaTP"),
				@WebInitParam(name = "user", value = "root"),
				@WebInitParam(name = "password", value = "toor")
		})
public class BatchInsertDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conn;
    PreparedStatement ps;
    int[]arr;
    
    public void init()
    {
    	ServletConfig cfg=getServletConfig();
    	String driver=cfg.getInitParameter("driver");
    	String url=cfg.getInitParameter("url");
    	String db=cfg.getInitParameter("db");
    	String user=cfg.getInitParameter("user");
    	String password=cfg.getInitParameter("password");
    	String u=url+db;
    	try
    	{
    		Class.forName(driver);
    		conn=DriverManager.getConnection(u,user,password);
    		ps=conn.prepareStatement("insert into books values(?,?,?)");
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    }
    public BatchInsertDemo() {
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
		pw.println("<form action='BatchInsert' method='post'>");
		pw.println("Enter Book ID<input type='text' name='bid'><br>");
		pw.println("Enter Book Name<input type='text' name='bname'><br>");
		pw.println("Enter Book Price<input type='text' name='bprice'><br>");
		pw.println("<input type='submit' name='btn' value='Add'>");
		pw.println("<input type='submit' name='btn' value='Insert'>");
		pw.println("</form></body></html>");
		
		if(request.getParameter("btn")!=null)
		{
			try
			{		
				
					ps.setInt(1, Integer.parseInt(request.getParameter("bid")));
					pw.println("done1");
					ps.setString(2, request.getParameter("bname"));
					pw.println("done2");
					ps.setInt(3,Integer.parseInt(request.getParameter("bprice")));
					pw.println("done3");
				if(request.getParameter("btn").equals("Add"))
				{
					pw.println("done4");
					ps.addBatch();
					
				}
				else
				{
					ps.addBatch();
					arr=ps.executeBatch();
				}
			}
			catch(Exception e)
			{
				pw.println(e);
			}
			
			int flag=0;
			for(int x:arr)
			{
				if(x!=0)
					flag=1;
			}
			if(flag==0)
				pw.println("All Records Entered Successfully");
			else
				pw.println("All Records not Entered Successfully");
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
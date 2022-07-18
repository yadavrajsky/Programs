package com.proc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.CallableStatement;

/**
 * Servlet implementation class OutParamInJdbc
 */
@WebServlet(urlPatterns={"/OutParamInJdbc"},
initParams= {
		@WebInitParam(name="driver",value="com.mysql.cj.jdbc.Driver"),
		@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/"),
		@WebInitParam(name="db",value="javaTP"),
		@WebInitParam(name="user",value="root"),	
		@WebInitParam(name="password",value="toor")
		
}
		)
public class OutParamInJdbc extends HttpServlet {
	private static final long serialVersionUID = 1L;
Connection conn;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutParamInJdbc() {
        super();
        // TODO Auto-generated constructor stub
    }
public void init()
{
	ServletConfig cfg=getServletConfig();
	String driver=cfg.getInitParameter("driver");
	String url=cfg.getInitParameter("url");
	String db=cfg.getInitParameter("db");
	String user=cfg.getInitParameter("user");
	String password=cfg.getInitParameter("password");
	String u=url+db;
	try {
		Class.forName(driver);
		conn=DriverManager.getConnection(u,user,password);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		pw.println("<html><body>");
		pw.println("<form action='OutParamInJdbc' method='post'>");
		pw.println("Enter First No.<input type='number' name='num1'><br>");
		pw.println("Enter Second No.<input type='number' name='num2'><br>");
		pw.println("<input type='submit' name='btn' value='Add'>");
		pw.println("</form></body></html>");
		
		if(request.getParameter("btn")!=null)
		{
			int num1=Integer.parseInt(request.getParameter("num1"));
			int num2=Integer.parseInt(request.getParameter("num2"));
			try {
				CallableStatement cs=conn.prepareCall("{?=call addnum(?,?)}");
				cs.registerOutParameter(1, Types.INTEGER);
				cs.setInt(2,num1);
				cs.setInt(3,num2);
				cs.execute();
				pw.println("Sum is "+cs.getInt(1));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

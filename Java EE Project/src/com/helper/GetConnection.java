package com.helper;

import java.sql.DriverManager;

import java.sql.*;

public class GetConnection {
	private Connection conn=null;
	
	public Connection getConnection() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","rahul");
		
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
	finally
	{
		return conn;
	}
	}
	

}

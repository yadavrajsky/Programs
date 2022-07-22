/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.*;

/**
 *
 * @author Rahul
 */
public class GetConnection {
   
    private Connection conn=null;
	
	public Connection getConnection() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicalstore","root","rahul");
		
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

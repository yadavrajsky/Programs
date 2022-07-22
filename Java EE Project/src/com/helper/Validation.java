package com.helper;
import java.sql.*;

import com.beans.User;
public class Validation {
	
	public boolean validate(User obj2 )
	{
		boolean flag=false;
		try {
		GetConnection obj=new GetConnection();
		Connection conn=obj.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from users where uname=? and password=?");
		
		
		ps.setString(1, obj2.getUname());
		ps.setString(2, obj2.getPassword());
		ResultSet rs=ps.executeQuery();
		if(rs.next()==true)
			flag=true;
			System.out.println(flag);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			return flag;
		}
	}

}

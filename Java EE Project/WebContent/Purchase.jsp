<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.helper.GetConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.beans.ProductBean"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ include file="HeaderLogout.html" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(request.getParameter("c4")==null)
{
	session.removeAttribute("product4");
}
 if(request.getParameter("c5")==null)
{
	session.removeAttribute("product5");	
}
 if(request.getParameter("c6")==null)
{
	session.removeAttribute("product6");
}

Enumeration e=session.getAttributeNames();
int total=0;
while(e.hasMoreElements())
{
	String s=(String)e.nextElement();
	if(!(s.equals("uname")||s.equals("pass")))
	{
		ProductBean obj=(ProductBean)session.getAttribute(s);
	    out.println("<h4 style='text-align:center;'>Model Name:"+obj.getModel()+"</h4>");
	    out.println("<h4 style='text-align:center;'>Price:"+obj.getPrice()+"</h4>");
	    total=total+obj.getPrice();
	}
}
out.println("<h4 style='text-align:center;'>Total Price:"+ total +"</h4>");
%>
<%
Connection conn=new GetConnection().getConnection();
PreparedStatement ps=conn.prepareStatement("select * from users where uname=? and password=?");
ps.setString(1,(String)session.getAttribute("uname"));
ps.setString(2,(String)session.getAttribute("pass"));
ResultSet rs=ps.executeQuery();
rs.next();
out.println("<h4 style='text-align:center;'>User Name:"+rs.getString("uname")+"</h4>");
out.println("<h4 style='text-align:center;'>Address:"+rs.getString("address")+"</h4>");
out.println("<h4 style='text-align:center;'>Mobile:"+rs.getString("mobile")+"</h4>");
%>
</body>
</html>
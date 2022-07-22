<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file ="Header.html" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session.invalidate();
out.println("<h4 style='text-align:center;'>Successfully logged out</h4>");
%>

</body>
</html>
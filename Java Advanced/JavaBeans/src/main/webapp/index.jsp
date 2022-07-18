<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" import="javax.servlet.RequestDispatcher" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Beans</title>
</head>
<body>

<jsp:useBean id="book" class="com.pojo.Book" scope="session"></jsp:useBean>
<%-- 
<jsp:setProperty property="bookid" name="book" value='<%=Integer.parseInt(request.getParameter("bookid")) %>'/>

<jsp:setProperty property="bname" name="book" value="Head First Java"/>
<jsp:setProperty property="price" name="book" value="500"/>

<jsp:setProperty property="bookid" name="book" param="bookid"/>
<jsp:setProperty property="bname" name="book" param="bname"/>
<jsp:setProperty property="price" name="book" param="price"/>
--%>
<!--
<jsp:setProperty property="*" name="book"/>
-->
<%--
<jsp:getProperty property="bookid" name="book"/>
<jsp:getProperty property="bname" name="book"/>
<jsp:getProperty property="price" name="book"/>
 --%>
<%
int []arr={1,2,3,4};
request.setAttribute("array",arr);
ArrayList a=new ArrayList();
a.add("a");
session.setAttribute("al",a);
HashMap h=new HashMap();
h.put("akash","yadav");
application.setAttribute("hm", h);
RequestDispatcher rd=request.getRequestDispatcher("ELDemo.jsp");
rd.forward(request,response);
%>

</body>
</html>
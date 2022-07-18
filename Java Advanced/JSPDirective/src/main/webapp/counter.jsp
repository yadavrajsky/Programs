<%@ page language="java" import="java.util.Random" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp" %>
  <%@ include file="index.html" %>
<%! int x=0; %>
<% 
Random r=new Random(); 
String colour="#"+r.nextInt(9999999);
//String clr=request.getParameter("clr");
int y=0,z=0;
if(request.getParameter("submit")!=null)
{
y=Integer.parseInt(request.getParameter("num1"));
z=Integer.parseInt(request.getParameter("num2"));
}
	//clr="white";
%>
<body bgcolor='<%=colour%>'>

<%= "You are visitor number"+(++x) %>
<%="Sum is "+(x+y) %>
</body>

</html>
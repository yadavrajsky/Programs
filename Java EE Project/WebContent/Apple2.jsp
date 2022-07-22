
<%@page import="com.beans.ProductBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.helper.GetConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ include file="HeaderLogout.html" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>

.btn1
{
padding:12px 14px;
font-size:18px;
width:100px;
background-color:orange;
color:white;
margin-top:10px;
margin-left:100px;

border:none;
outline:none;
}
.btn2
{
padding:12px 14px;
font-size:18px;
background-color:skyblue;
color:white;
margin-top:10px;
margin-left:100px;

border:none;
outline:none;
}
.btn3
{
padding:12px 14px;
font-size:18px;
background-color:orange;
color:white;
width:70px;
margin-top:10px;
margin-left:250px;
text-decoration:none;
text-align:center;
font-size:20px;
border:none;
outline:none;
}
.content
{ height:650px;
  padding:30px 200px;
  display: flex;
   flex-wrap: wrap;
  margin-bottom:40px;
}
.i1 ,.i2,.i3
{
width:300px;
height:520px;
border:1px solid #f1f1f1;
padding:14px 20px;
margin-right:20px;
margin-bottom:30px;
}
.img1
{
width:300px;
height:300px;
}
</style>
</head>
<body>
<%
if(request.getParameter("btn").equals("purchase"))
		{
		RequestDispatcher rd=request.getRequestDispatcher("Purchase.jsp");
		rd.forward(request,response);
		}
else
{
	if(request.getParameter("c1")==null)
	{
		session.removeAttribute("product0");
      
	}
 if(request.getParameter("c2")==null)
	{
		session.removeAttribute("product1");	
	}
	 if(request.getParameter("c3")==null)
	{
		session.removeAttribute("product2");
	}
}
%>
<%
Connection conn=new GetConnection().getConnection();
PreparedStatement ps=conn.prepareStatement("select * from products limit 3,3");
ResultSet rs=ps.executeQuery();
ProductBean []product=new ProductBean[3];
int i=0;
while(rs.next())
{
	product[i]=new ProductBean();
	product[i].setModel(rs.getString("model"));
	product[i].setCompany(rs.getString("company"));
	product[i].setFeatures(rs.getString("features"));
	product[i].setPrice(rs.getInt("price"));
	product[i].setImage(rs.getString("image"));
	i++;
}
session.setAttribute("product4",product[0]);
session.setAttribute("product5",product[1]);
session.setAttribute("product6",product[2]);
%>
<form action="Purchase.jsp" method="post">
<div class="content" >
<div class="i1">
<img class="img1" src="<%=product[0].getImage()%>">
<div>
<input type="checkbox" name="c4" value="<%=product[0].getModel()%>">Select to cart
<h5><%=product[0].getCompany() %></h5>

<h5><%=product[0].getModel() %></h5>
<h5><%=product[0].getPrice() %></h5>
<h5><%=product[0].getFeatures() %></h5>
</div></div>
<div class="i2"><img class="img1" src="<%=product[1].getImage()%>">
<div>
<input type="checkbox" name="c5" value="<%=product[1].getModel()%>">Select to cart
<h5><%=product[1].getCompany() %></h5>

<h5><%=product[1].getModel() %></h5>
<h5><%=product[1].getPrice() %></h5>
<h5><%=product[1].getFeatures() %></h5>
</div></div>
<div class="i3"><img class="img1" src="<%=product[2].getImage()%>">
<div>
<input type="checkbox" name="c6" value="<%=product[2].getModel()%>">Select to cart
<h5><%=product[2].getCompany() %></h5>

<h5><%=product[2].getModel() %></h5>
<h5><%=product[2].getPrice() %></h5>
<h5><%=product[2].getFeatures() %></h5>
</div></div>
<a class="btn3" href="Apple.jsp">prev</a>
<input class="btn1" type="submit" value="next" >

<input class="btn2" type="submit" value="purchase" >
<p></p>
</div>

</form>
</body>
</html>
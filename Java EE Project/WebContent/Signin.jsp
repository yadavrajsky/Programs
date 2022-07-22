<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="csscodes/Signin.css">

</head>
<body>
<div  class="modal">
 <form action="LoginServlet" method="post">
 <div class="container1">

      <b>User Name</b><input type="text" placeholder="Enter Username" name="uname">

  <b>Password</b><input type="password" placeholder="Enter Password" name="pass">
        
    <button type="submit">Login</button>
    
      <input type="checkbox" checked="checked" name="remember"> Remember me
  </div>

    <div class="container2">
<a class="cancelbtn" href="Home.jsp">Cancel</a>
 <span class="psw">Forgot <a href="#">password?</a></span>
    </div>

  </form>
  </div>
  </body>
  </html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EL</title>
</head>
<body>
${param.bookid}
${param.bname}
${param.price}
${requestScope.array[0]}
${requestScope.array[1]}
${requestScope.array[2]}
${sessionScope.al[0] }
${applicationScope.hm["akash"] }
${cookie.JSESSIONID.value }
<% session.invalidate(); %>
</body>
</html>
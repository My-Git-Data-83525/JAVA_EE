<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Error Page</h2>
Some error occured. please contact your vendor.</br>
Email:omdhavale2001@gmail.com<br/><br/>
Error:<% exception.getMessage();%>
</body>
</html>
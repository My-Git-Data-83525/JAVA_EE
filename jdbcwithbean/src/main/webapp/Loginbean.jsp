
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login bean</title>
</head>
<body>
<jsp:useBean id="lb" class="jspapp.LoginBean"/>
<jsp:setProperty name="lb" property="email" param="email" />
<jsp:setProperty name="lb" property="password" param="passwd"/>
<% lb.authetication(); %>
<% if(lb.getUser()!=null){ %>
Welcome,<jsp:getProperty name="lb" property="email"/>
<% }else{ %>
Login failed!
<%} %>
</body>
</html>
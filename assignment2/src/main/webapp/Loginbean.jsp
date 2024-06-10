
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login bean</title>
</head>
<body>
<jsp:useBean id="lb" class="assignment2.beans.LoginBean"/>
<jsp:setProperty name="lb" property="email" param="email" />
<jsp:setProperty name="lb" property="password" param="passwd"/>
<% lb.Login(); %>
<% if(lb.getUser()!=null){ %>
Welcome,<jsp:getProperty name="lb" property="email"/>
<% }else{ %>
Login failed!
<%} %>
</body>
</html>
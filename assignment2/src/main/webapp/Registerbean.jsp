
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login bean</title>
</head>
<body>
<jsp:useBean id="ns" class="assignment2.beans.NewUserBeans"/>
<jsp:setProperty name="ns" property="firstName" param="fname" />
<jsp:setProperty name="ns" property="lastName" param="lname"/>
<jsp:setProperty name="ns" property="email" param="email" />
<jsp:setProperty name="ns" property="password" param="passwd"/>
<jsp:setProperty name="ns" property="date" param="date"/>
<% int n=ns.RegisterUser(); %>
<% System.out.printf("%s",n); %>
<% if(n!=0){%>
<a href="login.jsp">Login Here</a>
<%}else { %>
Registration failed!!
<% } %>

</body>
</html>
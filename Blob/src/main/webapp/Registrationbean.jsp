<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page import="com.sunbeam.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="rb" class="com.sunbeam.beans.RegisterBean"
		scope="page" />
	<jsp:setProperty name="rb" property="*" />  
	<div style="text-align: center">
	${rb.Register()}
	<c:choose>
		<c:when test="${rb.getCount()==1}">
			Registered Successfully!!<br/>
			<a href="index.jsp">Login</a>
		</c:when>
		<c:otherwise>
			<p style="color: red">Registration failed!!<br/><br/>
			try again!!! <br/><br/> <a href="newuser.jsp">Registration here</a>
		</c:otherwise>
	</c:choose>
	</div>
</body>
</html>
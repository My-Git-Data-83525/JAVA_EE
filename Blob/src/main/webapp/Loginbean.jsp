<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session"/>
	<jsp:setProperty name="lb" property="*"/>
	${ lb.Login() }
	<c:choose>
		<c:when test="${lb.user!=null}">
			${hiihiiohi }		
		</c:when>
		<c:otherwise>
			Hello, ${lb.email} <br/>
			Invalid email or password. <br/><br/>
			<a href="index.jsp">Login Again</a>		
		</c:otherwise>
	</c:choose>
</body>
</html>
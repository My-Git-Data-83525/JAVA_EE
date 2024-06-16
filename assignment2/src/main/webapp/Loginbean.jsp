
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login bean</title>
</head>
<body>

	<jsp:useBean id="lb" class="assignment2.beans.LoginBean" scope="session" />
	<jsp:setProperty name="lb" property="*" />
	${lb.Login()}
	<c:choose>	
		<c:when test="${lb.user.role=='voter'}">
			<c:redirect url="CandListbean.jsp" />
		</c:when>
		<c:when test="${lb.user.role=='admin'}">
			<c:redirect url="adminList.jsp" />
		</c:when>
		<c:otherwise>
			<a href="newuser.jsp">Register Here</a>
			Login failed!
		</c:otherwise>
	</c:choose>
</body>
</html>
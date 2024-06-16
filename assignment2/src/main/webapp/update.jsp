<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="ub" class="assignment2.beans.UpdateBean" />
	<jsp:setProperty name="ub" property="*" />
	<form method="post" action="adminList.jsp">
		${ub.UpdateCandidate()}
		Candidate information Updated Successfully!!
		<c:redirect url="adminList.jsp" />	
	</form>
</body>
</html>
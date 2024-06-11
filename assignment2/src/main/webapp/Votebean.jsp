<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="vb" class="assignment2.beans.VoteBean"/>
<jsp:setProperty property="candidateid" name="vb" param="candidate"/>
<jsp:setProperty property="userid" name="vb" value="${lb.user.id}"/>
Hello!, ${lb.user.email}
<c:choose>
<c:when test="${lb.user.status==0}">
${vb.checkVote()}
<br/><hr/>
Thank! You for Voting...
<br/>
<a href="logout.jsp">LogOut</a>
</c:when>
<c:otherwise>
You have already voted!
<br/>
<a href="logout.jsp">LogOut</a>
</c:otherwise>
</c:choose>
</body>
</html>
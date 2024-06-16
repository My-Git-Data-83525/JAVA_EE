<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="ec" class="assignment2.beans.EditCandidate"/>
<jsp:setProperty property="candidateId" name="ec" param="id"/>
${ec.editCandidate()}
<form method="post" action="update.jsp">
<input type="hidden" name="id" value="${ec.candidate.id }" />
Name:<input type="text" name="name" value="${ec.candidate.name }" />
Party:<input type="text" name="party" value="${ec.candidate.party }">
<input type="hidden" name="votes" value="${ec.candidate.votes }" />
<input type="submit" name="update candidate"/>
</form>
</body>
</html>
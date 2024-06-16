<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="ac" class="assignment2.beans.Announcement" scope="application"/>
<jsp:setProperty property="ann" name="ac" param="ann"/>
</body>
</html>
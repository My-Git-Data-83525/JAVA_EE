<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>
		Welcome ! Home of Spring MVC <br>
		<c:url var="url" value="/test/multiply?num1=123&num2=456" />
		<a href="${url}">Test Model Map with Request Parameter</a> <br>
		<c:url var="url" value="/post/view?categoryName=Book" />
		<a href="${url}">category</a>
	</h5>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>show all products</title>
</head>
<body>
	<form method="post" action="purchesBean.jsp">
		<table>
			<thead>
				<tr>
					<td>Product id</td>
					<td>product Name</td>
					<td>product Price</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${sessionScope.product_bean.showList()}">
					<tr>
						<td>${p.id}</td>
						<td>${p.name}</td>
						<td>${p.price}</td>
						<td><input type="radio" name="productId" value="${p.id}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<label>Enter a Quantity</label>
		<input type="number" name="quantity"/>
		<input type="submit">
</body>
</html>
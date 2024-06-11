<%@page import="java.util.List"%>
<%@page import="assignment2.pojo.Candidate"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="cl" class="assignment2.beans.CandlistBean" />
	<form method="post" action="Votebean.jsp">
		<h1 style="text-align: center;">Online Voting</h1>
		<div align="center">
			<table border="1" width="50%" style="text-align: center">
				<thead>
					<tr bgcolor="grey">
						<th>Id</th>
						<th>Name</th>
						<th>Party</th>
						<th>Vote</th>
					</tr>
				</thead>
				<tbody>
					${cl.candList()}
					<c:forEach var="c" items="${cl.getList()}">
						<tr>
							<td>${c.getId()}</td>
							<td>${c.getName()}</td>
							<td>${c.getParty()}</td>
							<td><a href="Edit.jsp?id=${c.id}"><img height="24" width="24" src="Image/edit.jpeg"></a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
			<br />
			<br /> <input type="submit" value="Vote" />
		</div>
	</form>
</body>
</html>
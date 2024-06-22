<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Product Form</title>
</head>
<body>
	<form action="addCategoryProcess.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter Category Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Enter Category description</td>
				<td><input type="text" name="description" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Add A Category" /></td>
			</tr>
		</table>
	</form>

</body>
</html>
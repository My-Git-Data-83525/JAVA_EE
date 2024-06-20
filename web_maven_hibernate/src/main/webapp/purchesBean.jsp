<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="background-color:lightgrey ;margin: auto;">
	<jsp:setProperty property="*" name="product_bean"/>
		<table>
			<tr>
				<td>${sessionScope.product_bean.purches()}</td>
			</tr>
		</table>
	</div>
</body>
</html>
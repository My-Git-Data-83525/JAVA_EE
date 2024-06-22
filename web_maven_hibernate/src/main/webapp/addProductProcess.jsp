<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add product page</title>
</head>
<%-- data transfer fro m request params to JB --%>
<body>
<jsp:setProperty property="*" name="product_bean"/>
<h5>${sessionScope.product_bean.addNewProduct()}</h5>
</body>
</html>
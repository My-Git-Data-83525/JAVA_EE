<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
<%!

// fields (of generated servlet class)
		int count = 0;
		// methods (of generated servlet class)
		public void jspInit() {
			System.out.println("demo1 jspInit() called.");
		}
		public void jspDestroy() {
			System.out.println("demo1 jspDestroy() called.");
}%>
<br/><br/>
<%
Date d=new Date();
out.println(d);
%>
<br/><br/>
<% count++; %>
<% if(count%2==0){ %>
Even Count: <%=count%>
<%} else {%>
  Odd count:<%= count %> 
  <%} %>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Product Status</title>
</head>
<body>
<%
	if (request.getParameter("status").equals("success")) { %>
		<h2>Successfully deleted product </h2>
	
	<% } else { %>
	  <h1>Failed to delete :(</h1>		
	<% } %>
<a href="View.html">View products</a>
<a href="MainMenu.jsp">Back to main menu</a>
</body>
</html>
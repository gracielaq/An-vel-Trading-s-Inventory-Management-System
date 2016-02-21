<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product Status</title>
</head>
<body>
<%
	if (request.getParameter("success").equals("true")) { %>
		<h2>Successfully added product! </h2>
		<br/>
		<p>Product: ${productbean.product_description}</p>
		<p>Quantity: ${productbean.quantity}</p>
		<p>Unit Price: ${productbean.unit_price}</p>
		<p>Supplier: ${productbean.supplier}</p> 
	<% } else { %>
	  <h1>Failed to add product. :(</h1>		
	<% } %>
<a href="MainMenu.jsp">back to main menu</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product Status</title>
</head>
<body>
<%
	if (request.getParameter("status").equals("true")) { %>
		<h2>Successfully added product! </h2>
		<br/>
		<p>Product: ${productbean.product_description}</p>
		<p>Quantity: ${productbean.quantity}</p>
		<p>Unit Price: ${productbean.unit_price}</p>
		<p>Supplier: ${productbean.supplier}</p> 
	<% } else { %>
	  <h1>Failed to add product. :(</h1>		
	<% } %>
<a href=AddProduct.jsp>Add another product</a>
<a href="MainMenu.jsp">Back to main menu</a>
</body>
</html>
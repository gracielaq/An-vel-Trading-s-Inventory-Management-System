<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delivery Status</title>
</head>
<body>
<%
	if (request.getParameter("status").equals("true")) { %>
		<h2>Successfully added delivery! </h2>
		<br/>
		<p>Driver ${deliveryBean.Driver}</p>
		<p>Helper: ${deliveryBean.Helper}</p>
		<p>Plate Number: ${deliveryBean.PlateNum}</p>
		<p>Coding Day: ${deliveryBean.CodingDay}</p> 
		<p>Delivery Date: ${deliveryBean.DeliveryDate}</p> 
		<p>Product Code:${deliveryBean.product_code}</p>
	<% } else { %>
	  <h1>Failed to add delivery. :(</h1>		
	<% } %>
<a href=Delivery.jsp>Add another delivery</a>
<a href="MainMenu.jsp">Back to main menu</a>
</body>
</html>
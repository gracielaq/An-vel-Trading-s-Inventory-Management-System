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
		<p>Driver ${deliveryBean.driver}</p>
		<p>Helper: ${deliveryBean.helper}</p>
		<p>Plate Number: ${deliveryBean.plateNum}</p>
		<p>Coding Day: ${deliveryBean.codingDay}</p> 
		<p>Delivery Date: ${deliveryBean.deliveryDate}</p> 
		<p>Product Code:${deliveryBean.productCode}</p>
	<% } else { %>
	  <h1>Failed to add delivery. :(</h1>		
	<% } %>
<a href=Delivery.jsp>Add another delivery</a>
<a href="MainMenu.jsp">Back to main menu</a>
</body>
</html>
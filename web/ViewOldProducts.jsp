<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session = "false" %>
     <% if (request.getSession(false) == null) {
	response.sendRedirect("index.jsp");
	return;} %>
<jsp:useBean id="productrecords" type="java.sql.ResultSet" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Old Products</title>
</head>
<body>
<%
HttpSession sesh=request.getSession();
if(sesh.getAttribute("isAdmin")!=null){ %>
	<form action="SearchProducts.html">
	SEARCH:<input type="text" name="searchQuery"/>
	<input type="submit"/>
</form>
<h1>PRODUCTS</h1>
	<div style="height:200px;overflow:auto;">
	<table border="1" width="100%" cellpadding="3" cellspacing="3">
		<tr>
			
			<th align="center">Product Code</th>
			<th align="center">Supplier</th>
			<th align="center">Delivery Date</th>
			<th align="center">Date Received</th>
			<th align="center">Delivery Charge</th>
			<th align="center">DR_SI</th><!-- for customer discount -->
			<th align="center">Quantity</th>
			<th align="center">Product Description</th>
			<th align="center">Unit Price</th>
			<th align="center">Discount</th>
			<th align="center">Total Amount</th>
			<th align="center">Mode of Payment</th>
			<th align="center">Check Number</th>
			<th align="center">Recover</th>
			<th align="center">Delete</th>
		</tr>
		
			<% 
				while(productrecords.next()) {	
			%>
			
				<tr>
					<td><%=productrecords.getInt("product_code")%></td>
					<td><%=productrecords.getString("supplier")%></td>
					<td><%=productrecords.getString("delivery_date")%></td>
					<td><%=productrecords.getString("date_received")%></td>
					<td><%=productrecords.getString("delivery_charge")%></td>
					<td><%=productrecords.getString("DR_SI")%></td>
					<td><%=productrecords.getString("quantity")%></td>
					<td><%=productrecords.getString("product_description")%></td>
					<td><%=productrecords.getDouble("unit_price")%></td>
					<td><%=productrecords.getDouble("discount_add")%></td>
					<td><%=productrecords.getDouble("total_amount")%></td>
					<td><%=productrecords.getString("mode_of_payment")%></td>
					<td><%=productrecords.getInt("check_no")%></td>
					<td align="center">
					  <a href="productmaintenanceOld.html?product_code=<%=productrecords.getInt("product_code")%>&action=recover">
					  	recover
					  </a>
					</td>
					<td align="center">
					  <a href="productmaintenanceOld.html?product_code=<%=productrecords.getInt("product_code")%>&action=delete">
					  	delete
					  </a>
					</td>
				</tr>		
	<% } %>
		
	</table></div>
	<a href="MainMenu.jsp">Back to Main Menu</a>
<%} else{%>
<h1> you are not allowed in this section </h1>
<a href="index.jsp">Please log-in.</a>
<%}%>
</body>
</html>
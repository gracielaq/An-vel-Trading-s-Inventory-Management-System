<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session = "false" %>
     <% if (request.getSession(false) == null) {
	response.sendRedirect("index.jsp");
	return;} %>
<jsp:useBean id="delivered" type="java.sql.ResultSet" scope="request"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Products</title>
	<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.min.css">
	<script src="js/jquery-1.12.0.min.js"></script>
	<script src="js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" class="init">
        $(document).ready(function() {
            $('#tables').DataTable( {
                "order": [[ 3, "desc" ]]
            } );
        } );
    </script>
</head>
<body>
<%
HttpSession sesh=request.getSession();
if(sesh.getAttribute("isAdmin")!=null){ %>

<h1>PRODUCTS</h1>
	<div >
	<table id="tables" border="1" width="100%" cellpadding="3" cellspacing="3">
		<thead>
		<tr>
			
			<th align="center">Delivery Number</th>
			<th align="center">Batch No.</th>
			<th align="center">Sell Number</th>
			<th align="center">Driver</th>
			<th align="center">Helper</th>
			<th align="center">Plate Number</th>
			<th align="center">Coding Day</th>
			<th align="center">Delivery Date</th>
		</tr>
		</thead>
		<tfoot>
		<tr>
			
			<th align="center">Delivery Number</th>
			<th align="center">Batch No.</th>
			<th align="center">Sell Number</th>
			<th align="center">Driver</th>
			<th align="center">Helper</th>
			<th align="center">Plate Number</th>
			<th align="center">Coding Day</th>
			<th align="center">Delivery Date</th>
		</tr>
		</tfoot>
		
			<% 
				while(delivered.next()) {	
			%>
			
				<tr>
					<td><%=delivered.getInt("DeliveryNum")%></td>
					<td><%=delivered.getInt("batch_no")%></td>
					<td><%=delivered.getString("sell_no")%></td>
					<td><%=delivered.getString("Driver")%></td>
					<td><%=delivered.getString("Helper")%></td>
					<td><%=delivered.getString("PlateNum")%></td>
					<td><%=delivered.getString("CodingDay")%></td>
					<td><%=delivered.getString("DeliveryDate")%></td>
				</tr>		
	<% } %>
		
	</table></div>
	<a href="MainMenu.jsp">Back to Main Menu</a>


</body>
<%} else{%>
<h1> you are not allowed in this section </h1>
<a href="index.jsp">Please log-in.</a>
<%}%>
</html>
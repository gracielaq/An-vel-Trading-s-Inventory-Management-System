<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="productrecords" type="java.sql.ResultSet" scope="request"/>
    
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


<h1>PRODUCTS</h1>
	<div >
	<table id="tables" border="1" width="100%" cellpadding="3" cellspacing="3">
		<thead>
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
				
		</tr>
		</thead>
		<tfoot>
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
			
		</tr>
		</tfoot>
		
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
					
				</tr>		
	<% } %>
		
	</table></div>
	<a href="MainMenu.jsp">Back to Main Menu</a>


</body>
</html>
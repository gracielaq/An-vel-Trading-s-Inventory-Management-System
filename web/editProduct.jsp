<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session = "false" %>
     <% if (request.getSession(false) == null) {
	response.sendRedirect("index.jsp");
	return;} %>
<html>
<head>
    <title>Edit Product</title>
</head>
<%HttpSession session=request.getSession();
if(session.getAttribute("isAdmin").equals("admin")){ %>
<body>
<!-- private int product_code, quantity, DR_SI, check_no;
    private double unit_price, discount_add, total_amount, delivery_charge;
    private java.sql.Date delivery_date, date_recieved;
    private String product_description,
            mode_of_payment, supplier;
-->
<form action="update.html" title="productform" method="post">
    <p>Product code: ${productBean.product_code}</p>
    <input type="hidden" name="product_code"value="${productBean.product_code}">
    <p>Product Name: ${productBean.product_name}</p>
    <input type="hidden" name="product_name" value="${productBean.product_name}">
    <p>Quantity:<input type="number" name="quantity" value="${productBean.quantity}"/></p>
    <p>Supplier:<input type="text"  name="supplier" value="${productBean.supplier}" ></p>
   	<p>Category:<select name="category" selected="${productBean.category}"> 
    	<option value="cebu">Cebu</option>
	    <option value="tenzen">Tenzen</option>
	    <option value="euro">Euro</option>
    	<option value="homewise">Homewise</option>
   	 	<option value="tiletrim">Tiletrim</option>
    	<option value="door">Door</option>
    	<option value="grout">Grout</option>
    	<option value="adhesive">Adhesive</option>
    	<option value="waterCloset">Water Closet</option>
    </select>
   	</p>
   	<p>Size:<input type="text" name="size" value="${productBean.size }"></p>
    <p>DR_SI:<input type="number" name="dr_si" value="${productBean.DR_SI}"/></p>
    <p>Unit Price:<input type="number" name="unit_price" value="${productBean.unit_price}" /></p>
    <p>Discount:<input type="number" name="discount_add" value="${productBean.discount_add}" /></p>
    <p>Total Amount:<input type="number" name="total_amount" value="${productBean.total_amount}" /></p>
    <p>Delivery Charge:<input type="number" name="delivery_charge" value="${productBean.delivery_charge}" /></p>
    <p>Delivery Date:<input type="date" name="delivery_date" value="${productBean.delivery_date}"/></p>
    <p>Date Received:<input type="date" name="date_received" value="${productBean.date_received}"/> </p>
    <p>product description:<input type="text" name="product_description" value="${productBean.product_description}"/></p>
    <p>mode of payment: <input type="text" name="mode_of_payment" value="${productBean.mode_of_payment}"/></p>
    <p>Check No:<input type="number" name="check_no" value="${productBean.check_no}"/></p>
   	<p>Status:<input type="text" name="status" value="${productBean.status}"/></p>
    <p><input type="submit" value="Update"/></p>
   	<a href="EditView.html">Go Back</a>
</form>
</body>
<%} else{%>
<h1> you are not allowed in this section </h1>
<a href="index.jsp">Please log-in.</a>
<%}%>
</html>

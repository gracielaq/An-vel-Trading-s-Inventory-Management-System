<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session = "false" %>
     <% if (request.getSession(false) == null) {
	response.sendRedirect("index.jsp");
	return;} %>
<html>
<head>
    <title>DELETE PRODUCT</title>
</head>
<body>
<%
HttpSession sesh=request.getSession();
if(sesh.getAttribute("isAdmin").equals("admin")){ %>
<h1>Are you sure you want to delete this product?</h1>
<p>Product Code: ${productBean.product_code}</p>
<p>Product Name: ${productBean.product_name}</p>


<form action="deleteProductMe.html" method="post">
    <p>delete this product?</p>
    <input type="hidden" name="id" value="${productBean.product_code}"/>
    <p>Yes<input type="radio" name="action" value="yes"/></p>
    <p>No<input type="radio" name="action" value="no"/></p>
<input type="submit"/>
</form>
</body>
<%} else{%>
<h1> you are not allowed in this section </h1>
<a href="index.jsp">Please log-in.</a>
<%}%>
</html>

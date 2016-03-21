
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product Status</title>
</head>
<body>
<%
    if(request.getParameter("status").equals("true")){
%>
    <p>PRODUCT UPDATED SUCCESSFULLY</p>
<% }else{%>

<p>PRODUCT UPDATE FAILED</p>
<%}%>
<a href="MainMenu.jsp">back to main menu</a>
</body>
</html>

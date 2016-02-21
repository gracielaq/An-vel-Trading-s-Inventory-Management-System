<%--
  Created by IntelliJ IDEA.
  User: Jude
  Date: 2/22/2016
  Time: 2:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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

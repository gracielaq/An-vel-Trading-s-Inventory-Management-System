<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="accounts" type="java.sql.ResultSet" scope="request"/>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Accounts</title>
</head>
<%
HttpSession sesh=request.getSession();
if(sesh.getAttribute("isAdmin").equals("admin")){ %>
<body>
	<form action="SearchProducts.html">
	SEARCH:<input type="text" name="searchQuery"/>
	<input type="submit"/>
</form>
<h1>ACCOUNTS</h1>
	<div style="height:200px;overflow:auto;">
	<table border="1" width="100%" cellpadding="3" cellspacing="3">
		<tr>
			
			<th align="center">Username</th>
			<th align="center">Password</th>
			<th align="center">E-mail</th>
			<th align="center">First Name</th>
			<th align="center">Last Name</th>
			<th align="center">isAdmin</th>
			
		</tr>
		
			<% 
				while(accounts.next()) {	
			%>
			
				<tr>
					<td><%=accounts.getString("username")%></td>
					<td><%=accounts.getString("password")%></td>
					<td><%=accounts.getString("email")%></td>
					<td><%=accounts.getString("firstName")%></td>
					<td><%=accounts.getString("lastName")%></td>
					<td><%=accounts.getString("isAdmin")%></td>
					
				</tr>		
	<% } %>
		
	</table></div>
	<a href="MainMenu.jsp">Back to main menu</a>
</body>
<%} else{%>
<h1> you are not allowed in this section </h1>
<a href="index.jsp">Please log-in.</a>
<%}%>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page session = "false" %>
     <% if (request.getSession(false) == null) {
	response.sendRedirect("index.jsp");
	return;} %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Account</title>
</head>
<body>
<%
HttpSession sesh=request.getSession();
if(sesh.getAttribute("isAdmin").equals("admin")){ %>
<form action="addAccount.html" method="post"> 
	<p>First Name:<input type="text" name="firstName" required="required"/></p>
	<p>Last Name:<input type="text" name="lastName" required="required"/></p>
	<p>E-mail:<input type="email" name="email" required="required"/></p>
	<p>Username<input type="text" name="username" required="required"/></p>
	<p>ACCOUNT TYPE:</p>
	<input type="radio" name="isAdmin" value="true" checked> Admin<br>
	<input type="radio" name="isAdmin" value="false"> staff<br>
	<p>Password:<input type="password" name="password" id="txtPassword" required="required"/></p>
	<p>Confirm Password:<input type="password" name="password" id="txtConfirmPassword"  required="required"/></p>
 <input type="submit" id="btnSubmit" value="Submit" onclick="return Validate()" />
<a href="MainMenu.jsp">Back to Main Menu</a>
</form>
<script type="text/javascript">
    function Validate() {
        var password = document.getElementById("txtPassword").value;
        var confirmPassword = document.getElementById("txtConfirmPassword").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }
</script>
</body>
<%} else{%>
<h1> you are not allowed in this section </h1>
<a href="index.jsp">Please log-in.</a>
<%}%>
</html>
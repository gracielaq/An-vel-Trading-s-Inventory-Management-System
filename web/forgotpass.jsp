<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Password</title>
</head>
<body>
<form action="retrievepw.html" method="post"> 
<p>Username<input type="text" name="username" required="required"/></p>
<p>Email<input type="email" name="email" required="required"/></p>
<p>Old Password:<input type="password" name="oldpass" required="required"/></p>
<p>New Password:<input type="password" name="newpass" required="required"/></p>
<input type="submit" value="Submit"  />
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Account</title>
</head>
<body>
<form action="addAccount.html" method="post">
	<p>First Name<input type="text" name="firstName" required="required"/></p>
	<p>Last Name<input type="text" name="lastName" required="required"/></p>
	<p>E-mail<input type="email" name="email" required="required"/></p>
	<p>Username<input type="text" name="username" required="required"/></p>
	<p>Password<input type="password" name="password" required="required"/></p>
	<p><input type="submit" value="Register"/>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<%
		String login_msg=(String)request.getAttribute("error");  
		if(login_msg!=null)
		out.println("<font color=red size=4px>"+login_msg+"</font>");
	%>
<form action="uservalidation.html" method="post">
	<p>Username:<input type="text" name="username" required="required"/></p>	
	<p>Password:<input type="password" name="password" required="required"/></p>
	<p><input type="submit" value="Login"/>
</form>
	<a href=forgotpass.jsp>Forgot Password?</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>

</head>
<body onload="getMessages();">
<%
    String login_msg = (String) request.getAttribute("error");
    if (login_msg != null)
        out.println("<font color=red size=4px>" + login_msg + "</font>");
%>
<form action="uservalidation.html" method="post">
    <p>Username:<input type="text" name="username" required="required"/></p>
    <p>Password:<input type="password" name="password" required="required"/></p>
    <p><input type="submit" value="Login"/>
</form>
<a href=forgotpass.jsp>Forgot Password?</a>

<!--

<h1>SHOUT-OUT!</h1>
<form>
    <table>
        <tr>
            <td>Your name:</td>
            <td><input type="text" id="status" name="status"/></td>
        </tr>
        <tr>
            <td>Your shout:</td>
            <td><input type="text" id="message" name="message" /></td>
        </tr>
        <tr>
            <td><input type="button" onclick="postMessage();" value="SHOUT" /></td>
        </tr>
    </table>
</form>-->
<h2> Current Shouts </h2>
<div id="content">
    <% if (application.getAttribute("messages") != null) {%>
    <%= application.getAttribute("messages")%>
    <% }%>
</div>

<script>
    function postMessage() {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("POST", "Notifications?t="+new Date(), false);
        xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        var nameText = escape(document.getElementById("status").value);
        var messageText = escape(document.getElementById("message").value);
        document.getElementById("message").value = "";
        xmlhttp.send("status="+nameText+"&message="+messageText);
    }
    var messagesWaiting = false;
    function getMessages(){
        if(!messagesWaiting){
            messagesWaiting = true;
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange=function(){
                if (xmlhttp.readyState==4 && xmlhttp.status==200) {
                    messagesWaiting = false;
                    var contentElement = document.getElementById("content");
                    contentElement.innerHTML = xmlhttp.responseText + contentElement.innerHTML;
                }
            }
            xmlhttp.open("GET", "Notifications?t="+new Date(), true);
            xmlhttp.send();
        }
    }
    setInterval(getMessages, 500);
</script>
</body>
</html>
<%@ page import="anvel.model.SoldBean" %>
<%@ page import="anvel.model.ProductBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sell Product Status</title>
</head>
<body onload="postMessage();">
	<%
	if (request.getParameter("status").equals("true")) { %>
		<h2>Successfully sold product! </h2>
		<a href="DeliveryPage.html"> Deliver Products</a>
	<% } else { %>
	  <h1>Failed to sell. :(</h1>		
	<% } %>

    <p>BACK TO <a href="MainMenu.jsp">MAIN MENU</a> </p>
<!--<form>
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
        </table>-->
</form>
</body>
<script type="text/javascript">
    function postMessage() {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("POST", "Notifications?t="+new Date(), false);
        xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        //var nameText = escape(document.getElementById("status").value);
       // var messageText = escape(document.getElementById("message").value);
       // document.getElementById("message").value = "";
        xmlhttp.send("status="+"${productBean.product_name}"+"&message="+"SOLD");
        if(parseInt("${productBean.quantity}")<=5){
            xmlhttp.send("status="+"${productBean.product_name}"+"&message="+"KOKONTI NA LANG HUY!!");
        }
    }

</script>


</html>
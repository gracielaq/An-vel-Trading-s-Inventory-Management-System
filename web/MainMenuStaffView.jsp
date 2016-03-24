<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="/js/notif.js"></script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Menu</title>
</head>
<%
HttpSession sesh=request.getSession();
if(sesh.getAttribute("isAdmin").equals("staff")){ %>
<body>
	<form action="AddProduct.jsp" method="post">
		<input type="Submit" value="Add Product">
	</form>
	
	<form action="SellProducts.html" method="post">
		<input type="Submit" value="Sell Product">
	</form>
	
	<form action="View.html" method="post">
		<input type="Submit" value="View Products">
	</form>
	
	<form action="DeliveryPage.html">
		<input type="Submit" value="Delivery">
	</form>
	
	<form action="Reports.html" method="post">
		<input type="Submit" value="Reports">
	</form>


	<h2> Current NOTIFICATIONS </h2>
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
			var nameText = escape(document.getElementById("name").value);
			var messageText = escape(document.getElementById("message").value);
			document.getElementById("message").value = "";
			xmlhttp.send("name="+nameText+"&message="+messageText);
		}
		var messagesWaiting = false;
		function getMessages(){
			while(!messagesWaiting){
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
<%} else{%>
<h1> you are not allowed in this section </h1>
<a href="index.jsp">Please log-in.</a>
<%}%>
</html>
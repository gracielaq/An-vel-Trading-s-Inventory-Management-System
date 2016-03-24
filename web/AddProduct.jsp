<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page session = "false" %>
     <% if (request.getSession(false) == null) {
	response.sendRedirect("index.jsp");
	return;} %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Product</title>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" >

        function yesnoCheck() {
            if (document.getElementById('yesCheck').checked) {
                document.getElementById('ifYes').style.visibility = 'visible';
            } else {
                document.getElementById('ifYes').style.visibility = 'hidden';
            }
        }
        function recalculateSum() {
            var num1 = parseInt(document.getElementById("qty").value);
            var num2 = parseInt(document.getElementById("prc").value);
            var num3 = parseInt(document.getElementById("delC").value);
            var num4 = parseInt(document.getElementById("disc").value);
            var discPercent = num4 * 0.01;
            var total = (num1*num2) + num3;
            var discount = discPercent*total;
            
            var amount = total - discount;
            document.getElementById("Total").value = amount;

        }

    </script>
</head>
<body>
<%
HttpSession sesh=request.getSession();
if(sesh.getAttribute("isAdmin").equals("admin")||sesh.getAttribute("isAdmin").equals("staff")){ %>
<form action="AddProduct.html" method="post">

<h1>Add Product</h1>
    <p>Product Code<input type="text" name="product_code" required="required"/></p>
   	<p>Product Name<input type="text" name="product_name" required="required"/></p>
    
    <p>Delivery Date<input type="date" name="delivery_date" required="required"/></p>
    <p>Date Received<input type="date" name="date_received" required="required"/></p>
    <p>DR/SI #<input type="number" name="dr_si" required="required"/>
    <p>Quantity<input type="number" name="quantity" value="0" onblur="recalculateSum()" id="qty" required="required"/>
    </p>
    <p>Delivery Charge<input type="number" name="delivery_charge" value="0.00" onblur="recalculateSum()" id="delC"/></p>
    <p>Supplier:<input type="text" name="supplier"/></p>
    <p>Category <select name="category"> 
    <option value="cebu">Cebu</option>
    <option value="tenzen">Tenzen</option>
    <option value="euro">Euro</option>
    <option value="homewise">Homewise</option>
    <option value="tiletrim">Tiletrim</option>
    <option value="door">Door</option>
    <option value="grout">Grout</option>
    <option value="adhesive">Adhesive</option>
    <option value="waterCloset">Water Closet</option>
    </select></p>
    <p>Product Size: <input type="text" name="size" placeholder="(e.g. 5x5, 41kg)"/> </p>
    <p>Product Description:</p>
    <p><textarea name="product_description" rows="5" cols="10">Enter product description here.</textarea>
    <p>Unit Price<input type="number" name="unit_price" value="0.00"  onblur="recalculateSum()" id="prc"
                        required="required"/>
    <p>Discount<input type="number" name="discount_add" onblur="recalculateSum()" value="0" id="disc"/>%</p>
    <p>Total Amount <input id="Total" value="0" step="any" name="total_amount"/></p>
    <p>Mode of Payment</p>
   	<input type="radio"  onclick="javascript:yesnoCheck();" name="mode_of_payment" value="cash" id="noCheck">Cash <br>
	<input type="radio" onclick="javascript:yesnoCheck();" name="mode_of_payment" value="check" id="yesCheck" >Check<br>
	<div id="ifYes" style="visibility:hidden">
   	 	<p>Check Number:<input type="text" name="check"/></p>
	 </div>
	 <input type="submit" value="Submit"  />
</form>
<%if (sesh.getAttribute("isAdmin").equals("admin")) {%>
	<a href="MainMenu.jsp">back to Main Menu</a>
<%} %>
<%if (sesh.getAttribute("isAdmin").equals("staff")) {%>
	<a href="MainMenuStaffView.jsp">back to Main Menu</a>
<%} %>
</body>
<%} else{%>
<h1> you are not allowed in this section </h1>
<a href="index.jsp">Please log-in.</a>
<%}%>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sell Product Details</title>
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
<form action="SellProductMaintenance.html" method="post">
	 <p>Product Code: ${productBean.product_code}</p>
	 <input type="hidden" name="product_code" value="${productBean.product_code}"/>
	 <p>Quantity:<input type="number" name="quantity" value="${productBean.quantity}" onblur="recalculateSum()" id="qty" max="${productBean.quantity}"/></p>
	 <p>Unit Price:<input value="${productBean.unit_price}" name="unit_price" onblur="recalculateSum()" id="prc"></p>
	 <p>Product Description: ${productBean.product_description}</p>
	 <p>Delivery Charge<input type="number" name="delivery_charge" value="0.00" onblur="recalculateSum()" id="delC"/></p>
	 <p>Discount: <input type="number" name="discount_sell" onblur="recalculateSum()" value="0" id="disc">%</p>
	 <p>Total Amount: <input type="number" name="total_amount" id="Total"></p>
	 <p>Customer: <input type="text" name="customer_name" required="required"></p>
	 <p>TIN:<input type="text" name="tin" required="required"></p>
	 <p>Address: <input type="text" name="address"></p>
	 <p>Date: <input type="date" name="date" required="required" min="2000-01-01"/></p>
	  <p>Mode of Payment</p>
   		<input type="radio"  onclick="javascript:yesnoCheck();" name="mode_of_payment" value="cash" id="noCheck">Cash <br>
		<input type="radio" onclick="javascript:yesnoCheck();" name="mode_of_payment" value="check" id="yesCheck" >Check<br>
		<div id="ifYes" style="visibility:hidden">
   	 		<p>Check Number:<input type="text" name="check"/></p>
</div>
	<input type="Submit" value="Submit">
</form>
<a href="MainMenu.jsp">Go Back to Main Menu</a>
</body>
</html>
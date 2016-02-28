<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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

<form action="AddProduct.html" method="post">

<h1>Add Product</h1>
    <p>Product Code<input type="number" name="product_code" required="required"/></p>
    <p>Delivery Date<input type="date" name="delivery_date" required="required"/></p>
    <p>Date Received<input type="date" name="date_received" required="required"/></p>
    <p>DR/SI #<input type="number" name="dr_si" required="required"/>
    <p>Quantity<input type="number" name="quantity" value="0" onblur="recalculateSum()" id="qty" required="required"/>
    </p>
    <p>Delivery Charge<input type="number" name="delivery_charge" value="0.00" onblur="recalculateSum()" id="delC"/></p>
    <p>Supplier:<input type="text" name="supplier"/></p>
    <p>Product Description</p>
    <p><textarea name="product_description" rows="5" cols="10">Enter product description here.</textarea>
    <p>Unit Price<input type="number" name="unit_price" value="0.00"  onblur="recalculateSum()" id="prc"
                        required="required"/>
    <p>Discount<input type="number" name="discount_add" onblur="recalculateSum()" value="0" id="disc"/>%</p>
    <p>Total Amount <input id="Total" value="0" name="total_amount"/></p>
    <p>Mode of Payment</p>
   	<input type="radio"  onclick="javascript:yesnoCheck();" name="mode_of_payment" value="cash" id="noCheck">Cash <br>
	<input type="radio" onclick="javascript:yesnoCheck();" name="mode_of_payment" value="check" id="yesCheck" >Check<br>
	<div id="ifYes" style="visibility:hidden">
   	 	<p>Check Number:<input type="text" name="check"/></p>
	 </div>
	 <input type="submit" value="Submit"  />
</form>
<a href="MainMenu.jsp">back to Main Menu</a>

</body>
</html>
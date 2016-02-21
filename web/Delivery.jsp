<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delivery</title>
</head>
<body>
	<form action="Delivery.html" onsubmit="return validatePlate()" method="post">
		<p>Driver:<input type="text" name="driver" required="required"></p>
		<p>Helper:<input type="text" name="helper" required="required"></p>
		<p>No. of Boxes:<input type="text" name="boxes" required="required"></p>
		<p>Plate No. of Delivery Truck:<input type="text" onblur="validatePlate();" id="plate" name="plateNo" required="required"></p>
		<p id="plateValid"></p>
		<p>Coding of Truck: <select name="Days">
  			<option value="mon">Monday</option>
  			<option value="tues">Tuesday</option>
 			<option value="wed">Wednesday</option>
  			<option value="thurs">Thursday</option>
  			<option value="fri">Friday</option>
		</select></p>
		<p>Delivery Date:<input type="date" name="deliveryDate" required="required"></p>
		<input type="submit" value="Submit">
	</form>

<script type="text/javascript">
	function validate(plateNo) {
		var re = "/(^[a-zA-Z][a-zA-Z][a-zA-Z] [0-9][0-9][0-9]$)|(^[a-zA-Z][a-zA-Z][a-zA-Z] [0-9][0-9][0-9][0-9]$)/";
		return re.test(plateNo);
	}
	function validatePlate(){

		var plateNo = document.getElementById("plate");

		if (validate(plateNo)) {
            return true;

		} else {
            window.alert("Wrong plate number");
            return false;
        }
	}

</script>
</body>
</html>
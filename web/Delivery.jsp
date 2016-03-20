<%@ page import="anvel.model.SoldBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--<jsp:useBean id="rs" type="java.sql.ResultSet" scope="request"/>--%>
<%!%>
<%
    ArrayList<SoldBean> productsForSelling = new ArrayList<SoldBean>();
    if(request.getAttribute("productsForDelivery")!=null){
        productsForSelling=(ArrayList)request.getAttribute("productsForDelivery");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Delivery</title>

    <script src="js/jquery-1.12.0.min.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
        jQuery(function ($) {
            //form submit handler
            $('#deliveryform').submit(function (e) {
                //check atleat 1 checkbox is checked
                if (!$('.products').is(':checked')) {
                    //prevent the default form submit if it is not checked
                    window.alert("You must check at least one product.")
                    e.preventDefault();
                }
            })
        })
    </script>
</head>
<body>

<form action="Delivery.html"   id="deliveryform" onsubmit="return validatePlate()" method="post">
    <p>Driver:<input type="text" name="driver" required="required"></p>
    <p>Helper:<input type="text" name="helper" required="required"></p>
    <p>Plate No. of Delivery Truck:<input type="text" onblur="validatePlate();" placeholder="(e.g. ABC 1234)" id="plate"
                                          name="plateNum" required="required"></p>
    <p id="plateValid"></p>


    <p>CHOOSE PRODUCTS YOU WANT TO ORDER:</p>
    <%
        for(int x=0;x<productsForSelling.size();x++){
    %>
    <p><%=productsForSelling.get(x).getProduct_name()%>--<%=productsForSelling.get(x).getQuantity()%><input type="checkbox" value="<%=productsForSelling.get(x).getProduct_code()%>"/></p>
    <%}
    %>
<%--
    <%while (rs.next()) {%>
    <p>
        <input type="checkbox" class="products" name="productsOrdered[]"
               value="<%=rs.getString("product_code")%>"/><%=rs.getString("product_name")%>
    </p>
    <%
        }
    %>

--%>


    <!--
    <p>Coding of Truck: <select name="Days">
          <option value="Monday">Monday</option>
          <option value="Tuesday">Tuesday</option>
         <option value="Wednesday">Wednesday</option>
          <option value="Thursday">Thursday</option>
          <option value="Friday">Friday</option>
    </select></p>-->
    <p>Delivery Date:<input type="date" name="deliveryDate" required="required"></p>
    <p>Product code:<input type="text" name="product_code" required="required"></p>

    <input type=submit>
</form>

<script type="text/javascript">
    function validate(plateNo) {
        var re = "/(^[a-zA-Z][a-zA-Z][a-zA-Z] [0-9][0-9][0-9]$)|(^[a-zA-Z][a-zA-Z][a-zA-Z] [0-9][0-9][0-9][0-9]$)/";
        return re.test(plateNo);
    }
    function validatePlate() {

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
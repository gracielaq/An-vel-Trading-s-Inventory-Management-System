<%@ page import="anvel.model.SoldBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--<jsp:useBean id="rs" type="java.sql.ResultSet" scope="request"/>--%>
<%!%>
<%
    ArrayList<SoldBean> selectedProducts = new ArrayList<SoldBean>();
    if (request.getAttribute("selectedProducts") != null) {
        productsForSelling = (ArrayList) request.getAttribute("selectedProducts");
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

<form action="Delivery.html" id="deliveryform" onsubmit="return validatePlate()" method="post">
    <p>Driver:<input type="text" name="driver" required="required"></p>
    <p>Helper:<input type="text" name="helper" required="required"></p>
    <p>Plate No. of Delivery Truck:<input type="text" onblur="validatePlate();" placeholder="(e.g. ABC 1234)" id="plate"
                                          name="plateNum" required="required"></p>
    <p id="plateValid"></p>


    <p>PRODUCTS ORDERED</p>
        <table  cellspacing="0" align="left" width="30%" cellpadding="2">
            <thead>
            <tr>

                <th>SELL NO.</th>
                <th>PRODUCT CODE</th>
                <th>PRODUCT NAME</th>
                <th>QUANTITY</th>
                <th>CUSTOMER NAME</th>
                <th>ADDRESS</th>
            </tr>
            </thead>
    <%
        for(SoldBean sold: selectedProducts){
    %>
            <tr>
                <td><%=sold.getSell_no()%>
                </td>
                <td><%=sold.getProduct_code()%>
                </td>
                <td><%=sold.getProduct_name()%>
                </td>
                <td><%=sold.getQuantity()%>
                </td>
                <td><%=sold.getCustomer_name()%>
                </td>
                <td><%=sold.getAddress()%>
                </td>
            </tr>

    </table>
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
<%--
  Created by IntelliJ IDEA.
  User: Jude
  Date: 2/22/2016
  Time: 1:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- private int product_code, quantity, DR_SI, check_no;
    private double unit_price, discount_add, total_amount, delivery_charge;
    private java.sql.Date delivery_date, date_recieved;
    private String product_description,
            mode_of_payment, supplier;
-->
<form action="updateProduct.html" title="productform">
    <p>product_code: ${productBean.product_code}</p>
    <p>quantity:<input type="number" name="quantity" value="${productBean.quantity}"/></p>
    <p>DR_SI:<input type="number" name="DR_SI" value="${productBean.DR_SI}"/></p>
    <p>quantity:<input type="number" name="check_no" value="${productBean.quantity}"/></p>
    <p>unit price:<input type="number" name="unit_price" value="${productBean.unit_price}" /></p>
    <p>Discount:<input type="number" name="discount_add" value="${productBean.discount_add}" /></p>
    <p>total_amount:<input type="number" name="total_amount" value="${productBean.total_amount}" /></p>
    <p>delivery charge:<input type="number" name="delivery_charge" value="${productBean.delivery_charge}" /></p>
    <p>delivery date:<input type="date" name="delivery_date" value="${productBean.delivery_date}"/></p>
    <p>date_recieved:<input type="date" name="date_recieved" value="${productBean.date_recieved}}"/> </p>
    <p>product description:<input name="product_description" value="${productBean.product_description}"/></p>
    <p>mode of payment: <input name="mode_of_payment" value="${productBean.mode_of_payment}"/></p>
    <p>supplier:<input  name="supplier" value="${productBean.supplier}" ></p>
    <p><input type="submit"/></p>
</form>
</body>
</html>

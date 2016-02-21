<%--
  Created by IntelliJ IDEA.
  User: Jude
  Date: 2/22/2016
  Time: 2:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>aDELETE PRODUCT</title>
</head>
<body>
<h1>are you sure you want to delete this product??</h1>
<p>product_code: ${productBean.product_code}</p>
<p>quantity:${productBean.quantity}</p>
<p>DR_SI:${productBean.DR_SI}</p>
<p>quantity:${productBean.quantity}</p>
<p>unit price:${productBean.unit_price}</p>
<p>Discount:${productBean.discount_add}</p>
<p>total_amount:${productBean.total_amount}</p>
<p>delivery charge:${productBean.delivery_charge}</p>
<p>delivery date:${productBean.delivery_date}</p>
<p>date_recieved:${productBean.date_recieved} </p>
<p>product description:${productBean.product_description}</p>
<p>mode of payment: ${productBean.mode_of_payment}</p>
<p>supplier:${productBean.supplier}</p>

<form action="/deleteProduct.html">
    <p>delete this product?</p>
    <input type="hidden" value="${productBean.product_code}"/>
    <input type="radio" name="action" value="yes"/>
    <input type="radio" name="action" value="no"/>
    <input type="submit"/>
</form>
</body>
</html>

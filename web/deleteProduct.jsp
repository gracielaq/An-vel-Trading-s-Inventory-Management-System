<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DELETE PRODUCT</title>
</head>
<body>
<h1>Are you sure you want to delete this product?</h1>
<p>product_code: ${productBean.product_code}</p>
<p>quantity:${productBean.quantity}</p>
<p>DR_SI:${productBean.DR_SI}</p>
<p>quantity:${productBean.quantity}</p>
<p>unit price:${productBean.unit_price}</p>
<p>Discount:${productBean.discount_add}</p>
<p>total_amount:${productBean.total_amount}</p>
<p>delivery charge:${productBean.delivery_charge}</p>
<p>delivery date:${productBean.delivery_date}</p>
<p>date_received:${productBean.date_received} </p>
<p>product description:${productBean.product_description}</p>
<p>mode of payment: ${productBean.mode_of_payment}</p>
<p>supplier:${productBean.supplier}</p>

<form action="deleteProductMe.html" method="post">
    <p>delete this product?</p>
    <input type="hidden" name="id" value="${productBean.product_code}"/>
    <p>Yes<input type="radio" name="action" value="yes"/></p>
    <p>No<input type="radio" name="action" value="no"/></p>
<input type="submit"/>
</form>
</body>
</html>

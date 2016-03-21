<%@ page import="anvel.model.DeliveryBean" %>
<%@ page import="anvel.model.SoldBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    DeliveryBean deliveryBean = new DeliveryBean();
    ArrayList<SoldBean> selectedProducts = new ArrayList<>();

    if (request.getAttribute("deliveryBean") != null) {
        deliveryBean = (DeliveryBean) request.getAttribute("deliveryBean");
    } else {
        deliveryBean = null;
    }

    if (request.getAttribute("selectedProducts") != null) {
        selectedProducts = (ArrayList) request.getAttribute("selectedProducts");
    } else {
        selectedProducts = null;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Delivery Status</title>
</head>
<body>
<%
    if (request.getParameter("status").equals("success")) { %>
<h2>Successfully added delivery! </h2>
<p>DELIVERY BATCH NUMBER:<%=deliveryBean.getBatch_no()%>
</p>
<p>DRIVER:<%=deliveryBean.getBatch_no()%>
</p>
<p>HELPER:<%=deliveryBean.getHelper()%>
</p>
<p>PLATE NUMBER:<%=deliveryBean.getPlateNum()%>
</p>
<p>CODING DAY:<%=deliveryBean.getCodingDay()%>
</p>
<p>DELIVERY DATE:<%=deliveryBean.getDeliveryDate()%>
</p>
<p>PRODUCTS DELIVERED</p>
<table>
    <thead>
    <tr>
        <th>
            SELL NO.
        </th>
        <th>
            PRODUCTS
        </th>
        <th>
            QUANTITY
        </th>
    </tr>
    </thead>
    <%for (SoldBean sold : selectedProducts) {%>
    <tr>
        <td><%=sold.getSell_no()%>
        </td>
        <td><%=sold.getProduct_name()%>
        </td>
        <td><%=sold.getQuantity()%>
        </td>
    </tr>
    <%}%>
</table>


<%
} else { %>
<h1>Failed to add delivery. :(</h1>
<% } %>
<a href=DeliveriesPage.html>Add another delivery</a>
<a href="MainMenu.jsp">Back to main menu</a>
</body>
</html>
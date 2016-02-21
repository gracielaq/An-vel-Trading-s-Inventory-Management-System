<%--
  Created by IntelliJ IDEA.
  User: Jude
  Date: 2/21/2016
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="soldrecords" type="java.sql.ResultSet" scope="request"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
</form>
<h1>PRODUCTS</h1>
<div style="height:200px;overflow:auto;">
    <table border="1" width="100%" cellpadding="3" cellspacing="3">
        <tr>

            <th align="center">Product Code</th>
            <th align="center">unit price</th>
            <th align="center">quantity</th>
            <th align="center">product description</th>
            <th align="center">discount_sell</th>
            <th align="center">total amount</th><!-- for customer discount -->
            <th align="center">note quantity</th>
            <th align="center">note description</th>
            <th align="center">customer name</th>
            <th align="center">TIN</th>
            <th align="center">Address</th>
            <th align="center">date</th>
            <th align="center">Mode of Pyt</th>
            <th align="center">Check Number</th>
            <th align="center">Action-Edit</th>
            <th align="center">Action-Delete</th>
        </tr>

        <%
            while(soldrecords.next()) {
        %>

        <tr>
            <td><%=soldrecords.getString("product_code")%></td>
            <td><%=soldrecords.getString("unit_price")%></td>
            <td><%=soldrecords.getString("quantity")%></td>
            <td><%=soldrecords.getString("product_description")%></td>
            <td><%=soldrecords.getString("discount_sell")%></td>
            <td><%=soldrecords.getString("total_amount")%></td>
            <td><%=soldrecords.getString("note_quantity")%></td>
            <td><%=soldrecords.getString("note_description")%></td>
            <td><%=soldrecords.getString("customer_name")%></td>
            <td><%=soldrecords.getString("tin")%></td>
            <td><%=soldrecords.getString("address")%></td>
            <td><%=soldrecords.getString("date")%></td>
            <td><%=soldrecords.getString("mode_of_payment")%></td>
            <td><%=soldrecords.getInt("check_no")%></td>
            <td align="center">
                <a href="productmaintenance.html?product_code=<%=soldrecords.getInt("product_code")%>&action=edit">
                    edit
                </a>
            </td>
            <td align="center">
                <a href="productmaintenance.html?product_code=<%=soldrecords.getInt("product_code")%>&action=delete">
                    delete
                </a>
            </td>
        </tr>
        <% } %>

    </table></div>

</body>
</html>

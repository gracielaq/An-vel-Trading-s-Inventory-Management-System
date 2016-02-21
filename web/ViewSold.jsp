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
<body><!--
/*FOR SELL:*/
CREATE TABLE `Sell` (
`product_code` int(11) NOT NULL,
`unit_price` double NOT NULL,
`quantity` int(11) NOT NULL,
`product_description` varchar(999) DEFAULT NULL,
`discount_sell` double DEFAULT NULL,
`total_amount` double DEFAULT NULL,
`note_quantity` int(11) DEFAULT NULL,
`note_description` varchar(999) DEFAULT NULL,
`customer_name` varchar(200) NOT NULL,
`tin` varchar(200) NOT NULL,
`address` varchar(200) NOT NULL,
`date` datetime NOT NULL,
`mode_of_payment` varchar(45) NOT NULL,
`check_no` int(11) DEFAULT NULL,
PRIMARY KEY (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1; -->
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
            <th align="center">Discount</th>
            <th align="center">Total Amount</th>
            <th align="center">Mode of Pyt</th>
            <th align="center">Check Number</th>
            <th align="center">Action-Edit</th>
            <th align="center">Action-Delete</th>
        </tr>

        <%
            while(soldrecords.next()) {
        %>

        <tr>
            <td><%=soldrecords.getInt("product_code")%></td>
            <td><%=soldrecords.getString("supplier")%></td>
            <td><%=soldrecords.getString("delivery_date")%></td>
            <td><%=soldrecords.getString("date_received")%></td>
            <td><%=soldrecords.getString("delivery_charge")%></td>
            <td><%=soldrecords.getString("DR_SI")%></td>
            <td><%=soldrecords.getString("quantity")%></td>
            <td><%=soldrecords.getString("product_description")%></td>
            <td><%=soldrecords.getDouble("unit_price")%></td>
            <td><%=soldrecords.getDouble("discount_add")%></td>
            <td><%=soldrecords.getDouble("total_amount")%></td>
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

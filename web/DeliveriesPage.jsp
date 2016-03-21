<%@ page import="java.util.ArrayList" %>
<%@ page import="anvel.model.SoldBean" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Jude
  Date: 3/21/2016
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.min.css"/>
<link rel="stylesheet" type="text/css" href="css/select.dataTables.min.css"/>
<%
    ArrayList<SoldBean> productsForSelling = new ArrayList<SoldBean>();
    if (request.getAttribute("productsForDelivery") != null) {
        productsForSelling = (ArrayList) request.getAttribute("productsForDelivery");
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>DELIVER PAGE</title>
    <script src="js/jquery-1.12.0.min.js"></script>
    <script src="js/jquery.dataTables.min.js"></script>
    <script src="js/dataTables.select.min.js"></script>
    <script type="text/javascript" class="init">
        $(document).ready(function () {
            $('#example').DataTable({
                "order": [[ 1, "asc" ]]
            });
        });
    </script>
</head>
<h1>SELECT ITEMS FOR DELIVERY</h1>
<body>
<form action="DeliveryProcess.html">
    <table id="example" class="display" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>selected</th>
            <th>SELL NO.</th>
            <th>PRODUCT CODE</th>
            <th>PRODUCT NAME</th>
            <th>QUANTITY</th>
            <th>CUSTOMER NAME</th>
            <th>ADDRESS</th>
        </tr>
        </thead>

        <tfoot>
        <tr>
            <th>selected</th>
            <th>SELL NO.</th>
            <th>PRODUCT CODE</th>
            <th>PRODUCT NAME</th>
            <th>QUANTITY</th>
            <th>CUSTOMER NAME</th>
            <th>ADDRESS</th>
        </tr>
        </tfoot>

        <%for (SoldBean bean : productsForSelling) {%>
        <tr>
            <td><input type="checkbox" name="selectedproducts" value="<%=bean.getProduct_code()%>"onclick="updateCheckedNumbers()"/></td>
            <td><%=bean.getSell_no()%>
            </td>
            <td><%=bean.getProduct_code()%>
            </td>
            <td><%=bean.getProduct_name()%>
            </td>
            <td><%=bean.getQuantity()%>
            </td>
            <td><%=bean.getCustomer_name()%>
            </td>
            <td><%=bean.getAddress()%>
            </td>
        </tr>
        <%}%>
    </table>
    <input type="submit" value="submit"/>
</form>
<p id="checkedNumbers"></p>
</body>

</html>
<script type="text/javascript">
    function updateCheckedNumbers() {
        var p = document.getElementById('checkedNumbers')
        p.innerHTML = "items selected:" + document.querySelectorAll('input[type="checkbox"]:checked').length
    }
</script>
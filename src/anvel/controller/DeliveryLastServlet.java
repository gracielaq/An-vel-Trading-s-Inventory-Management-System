package anvel.controller;

import anvel.model.BeanFactory;
import anvel.model.DeliveryBean;
import anvel.model.SoldBean;
import anvel.utility.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@WebServlet("/DeliveryPageLastPart.html")

public class DeliveryLastServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Connection connection;

    public void init() throws ServletException {
        connection = SQLOperations.getConnection();
        if (connection != null) {
            System.out.println("CONNECTED");
        } else {
            System.out.println("NULL CONNECTION");
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int batch_no = getCurrentBatchno(connection);
        String driver = request.getParameter("driver");
        String helper = request.getParameter("helper");
        String plateNum = request.getParameter("plateNum").toUpperCase();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date DeliveryDate;
        try {
            DeliveryDate = new java.sql.Date(sdf.parse(request.getParameter("deliveryDate")).getTime());
        } catch (ParseException e) {
            DeliveryDate = null;
            e.printStackTrace();
        }


        //get all selected na checkbox
        String[] tempSellNoArray = request.getParameterValues("sell_no");

        DeliveryBean deliveryBean = BeanFactory.getDeliveryBeanInstance(batch_no, driver, helper, "", plateNum, DeliveryDate);

        //initialize arraylist at ilagay na ang mga bean ng mga nakuhang soldproducts
        ArrayList<SoldBean> selectedProducts = new ArrayList<>();

        String directory = "/deliveryStatus.jsp";

        try {
            for (String x : tempSellNoArray) {
                //lalagay na ang mga kada transactions sa db

                insertDeliveryBean(BeanFactory.getDeliveryBeanInstance(batch_no, driver, helper, x, plateNum, DeliveryDate)
                        , connection);
                //lalagay sa arraylist for output
                selectedProducts.add(DeliveryContinuationServlet.findSoldProduct(x, connection));
                //update na delivery status sa sell
                updateDeliveredStatus(Integer.parseInt(x), connection);
            }

            //meaning nalagyan lahat
            directory+="?status=success";
        } catch (Exception e) {
            directory += "?status=failed";
            e.printStackTrace();
        }

        request.setAttribute("selectedProducts", selectedProducts);
        request.setAttribute("deliveryBean", deliveryBean);

        getServletContext().getRequestDispatcher(directory).forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public static int getCurrentBatchno(Connection connection) {
        try {
            int x = 0;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from deliverydb");
            while (rs.next()) {
                x = rs.getInt("batch_no");
            }
            if (x != 0)
                return x;
            else return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }

    }

    public static void updateDeliveredStatus(int sell_no, Connection connection) {
        try {
            Statement statement = connection.createStatement();

            statement.execute("UPDATE sell SET delivery_pickup_status='delivered' WHEre sell_no=" + sell_no);
            System.out.println(sell_no + " product has been updated to sold");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void insertDeliveryBean(DeliveryBean deliveryBean, Connection connection) throws SQLException {
        String query = "INSERT INTO `deliverydb` (`batch_no`,`Driver`,`Helper`,`PlateNum`,`CodingDay`,`DeliveryDate`,`sell_no`)" +
                "VALUES (?, ?, ?, ?, ?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, deliveryBean.getBatch_no());
        preparedStatement.setString(2, deliveryBean.getDriver());
        preparedStatement.setString(3, deliveryBean.getHelper());
        preparedStatement.setString(4, deliveryBean.getPlateNum());
        preparedStatement.setString(5, deliveryBean.getCodingDay());
        preparedStatement.setString(6, "" + deliveryBean.getDeliveryDate());
        preparedStatement.setString(7, deliveryBean.getSell_no());
        preparedStatement.execute();
        System.out.println("added " + deliveryBean.getSell_no() + "to deliverydb");


    }

}

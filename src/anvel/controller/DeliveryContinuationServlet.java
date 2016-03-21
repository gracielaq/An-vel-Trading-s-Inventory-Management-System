package anvel.controller;

import anvel.model.BeanFactory;
import anvel.model.SoldBean;
import anvel.utility.sql.SQLOperations;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Jude on 3/21/2016.
 */
@WebServlet("/DeliveryPagePart2.html")
public class DeliveryContinuationServlet extends HttpServlet {
    Connection connection;
    public void init() throws ServletException{
        connection= SQLOperations.getConnection();
        if(connection!=null) {
            System.out.println("DeliveryContinuationServlet-- CONNECTED");
        }else{
            System.out.println("DeliveryContinuationServlet-- NULL CONNECTION");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get all selected na checkbox
        String[] tempProductCodeArray=request.getParameterValues("selectedProducts");

        //initialize arraylist at ilagay na ang mga bean ng mga nakuhang soldproducts
        ArrayList<SoldBean> selectedProducts= new ArrayList<>();
        for(String x: tempProductCodeArray){
            selectedProducts.add(findSoldProduct(x,connection));
        }
        request.setAttribute("selectedProducts",selectedProducts);
        getServletContext().getRequestDispatcher("/DeliveriesPageContinuation.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    public static SoldBean findSoldProduct(String number, Connection connection){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM SELL WHERE sell_no=?");
            preparedStatement.setString(1,number);
            ResultSet rs = preparedStatement.executeQuery();
            //paginitialize ng soldbean
            SoldBean soldBean=new SoldBean();
            while(rs.next()) {
                 soldBean = BeanFactory.getSoldBeanInstance(rs.getString("product_code"), rs.getString("product_name"), rs.getDouble("unit_price")
                        , rs.getInt("quantity"), rs.getString("product_description"), rs.getDouble("discount_sell"), rs.getInt("note_quantity")
                        , rs.getString("note_description"), rs.getString("customer_name"), rs.getString("tin"), rs.getString("address")
                        , rs.getDate("date"), rs.getString("mode_of_payment"), rs.getInt("check_no"), rs.getString("size")
                        , rs.getString("delivery_pickup_status"), rs.getInt("sell_no"), rs.getString("category"));
            }
            return soldBean;

        } catch (SQLException e) {
            System.out.println("FINDSOLDPRODUCT-- CANNOT FIND SELL_NO "+number);
            e.printStackTrace();
            return null;
        }

    }
}

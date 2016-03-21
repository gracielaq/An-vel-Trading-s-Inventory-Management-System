package anvel.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import anvel.model.BeanFactory;
import anvel.model.SoldBean;
import anvel.utility.sql.SQLOperations;

/**
 * Servlet implementation class DeliveryServlet
 */
@WebServlet("/DeliveryPage.html")
public class DeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection connection;
	public void init() throws ServletException{
		connection = SQLOperations.getConnection();
		if(connection!=null)System.out.println("CONNECTED");
		else System.out.println("NULL CONNECTION");
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet rs = SQLOperations.getEligibleDeliveries(connection);
        //sabi raw online mas safe daw na gamitin yung Arraylist, kasi database cursor
        //daw yun e, madalas magkaerror
        ArrayList<SoldBean> productsForDelivery= new ArrayList<SoldBean>();
        try {
            while(rs.next()){
                productsForDelivery.add(BeanFactory.getSoldBeanInstance(rs.getString("product_code"), rs.getString("product_name"), rs.getDouble("unit_price")
                        , rs.getInt("quantity"), rs.getString("product_description"), rs.getDouble("discount_sell")
                        , rs.getInt("note_quantity"), rs.getString("note_description"), rs.getString("customer_name")
                        , rs.getString("tin"), rs.getString("address"), rs.getDate("date"),rs.getString("mode_of_payment"),
                        rs.getInt("check_no"), rs.getString("size"),rs.getString("delivery_pickup_status"), rs.getInt("sell_no"),rs.getString("category")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("productsForDelivery", productsForDelivery);
		getServletContext().getRequestDispatcher("/DeliveriesPage.jsp").forward(request, response);
		
	}

}

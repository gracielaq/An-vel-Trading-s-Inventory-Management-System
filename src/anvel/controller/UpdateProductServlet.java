package anvel.controller;

import anvel.model.BeanFactory;
import anvel.model.ProductBean;
import anvel.utility.sql.SQLOperations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;

@WebServlet("/update.html")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;

    public void init() throws ServletException {
        connection = SQLOperations.getConnection();
        if (connection != null) {
        	System.out.println("CONNECTED");
        //	System.out.println("i'm here at update product");
        }
        else {System.out.println("NULL CONNECTION");}
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher= null;
    	try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            String product_code = request.getParameter("product_code");
            String product_name=request.getParameter("product_name");
            java.sql.Date delivery_date = new java.sql.Date(sdf.parse(request.getParameter("delivery_date")).getTime());
            java.sql.Date date_received = new java.sql.Date(sdf.parse(request.getParameter("date_received")).getTime());
            int dR_SI = Integer.parseInt(request.getParameter("dr_si"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            double delivery_charge = Double.parseDouble(request.getParameter("delivery_charge"));
            String supplier = request.getParameter("supplier");
            String product_description = request.getParameter("product_description");
            String size = request.getParameter("size");
            String category = request.getParameter("category");
            Double unit_price = Double.parseDouble(request.getParameter("unit_price"));
            Double discount_add = Double.parseDouble((request.getParameter("discount_add")));
            Double total_amount = Double.parseDouble(request.getParameter("total_amount"));
            String mode_of_payment = request.getParameter("mode_of_payment");
            String status=request.getParameter("status");
            
            int check_no = 0;

            try {
                check_no = Integer.parseInt(request.getParameter("check_no"));
            } catch (Exception e) {
            	e.printStackTrace();
            }

            ProductBean productbean = BeanFactory.getProductBeanInstance(product_code, product_name,delivery_date,
            		date_received, dR_SI, quantity, delivery_charge,supplier,category, product_description, 
            		size, unit_price,discount_add, total_amount, mode_of_payment, check_no, status);
            
            int recordsAffected=
					SQLOperations.updateProduct(productbean,product_code,connection);
            
            request.setAttribute("product", productbean);
            
            if(recordsAffected >0){
            	dispatcher = getServletContext().getRequestDispatcher("/updateProductStatus.jsp?status=true");
            }
            else{
            	dispatcher = getServletContext().getRequestDispatcher("/updateProductStatus.jsp?status=false");
            }
            dispatcher.forward(request, response);

        } catch (Exception e) {
        	e.printStackTrace();
        }



    }

   
}

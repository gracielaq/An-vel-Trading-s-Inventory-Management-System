package anvel.controller;
import anvel.utility.sql.SQLOperations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by Jude on 2/22/2016.
 */
@WebServlet("deleteProduct.html")
public class DeleteProductServlet extends HttpServlet {
    Connection connection;
    public void init() throws ServletException {
        connection = SQLOperations.getConnection();
        if(connection == null){
            System.out.println("NULL CONNECTION");
        }
        else{
            System.out.println("CONNECTED");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try{
    	RequestDispatcher dispatcher = null; 
    	if(request.getParameter("action").equals("yes")){
           int product_code=Integer.parseInt((String)request.getAttribute("productBean"));
           
           SQLOperations.transferProduct(product_code, connection);
			SQLOperations.deleteProduct(product_code, connection);
			ResultSet rs = 
					  SQLOperations.getAllProducts(connection);
			request.setAttribute("recordAdmins", rs);
			dispatcher = 
			 getServletContext().getRequestDispatcher("/View.html");	
           
        }else{
            response.sendRedirect("/View.html");
        }
    }catch (Exception e) {
		System.err.println("Exception e - " + e.getMessage());
		e.printStackTrace();
	} 
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

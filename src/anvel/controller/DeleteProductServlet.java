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
@WebServlet("/deleteProductMe.html")
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
    	doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  try{
    	    	RequestDispatcher dispatcher = null; 
    	    	String directory = "/deleteProductStatus.jsp";
    	    	if(request.getParameter("action").equals("yes")){
    	    	   System.out.println(request.getAttribute("productBean"));
    	           int product_code=Integer.parseInt(request.getParameter("id"));
    	           
    	           SQLOperations.transferProduct(product_code, connection);
    	           SQLOperations.deleteProduct(product_code, connection);
    	           directory+="?status=success";
    	           getServletContext().getRequestDispatcher(directory).forward(request,response);
    	           
    	        }else{
    	            response.sendRedirect("View.html");
    	        }
    	    }catch (Exception e) {
    			System.err.println("Exception e - " + e.getMessage());
    			e.printStackTrace();
    		} 
    }
}

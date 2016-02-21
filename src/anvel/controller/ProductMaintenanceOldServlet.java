package anvel.controller;

import anvel.model.ProductBean;
import anvel.utility.sql.SQLOperations;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by GQ on 2/22/2016.
 */
@WebServlet("/productmaintenanceOld.html")
public class ProductMaintenanceOldServlet extends HttpServlet {
    Connection connection;
    public void init () throws ServletException{
        connection = SQLOperations.getConnection();
        if(connection!=null){
            System.out.println("CONNECTED");
        }
        else
        {
            System.out.println("NULL CONNECTION");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int product_code=Integer.parseInt(request.getParameter("product_code"));
        System.out.println(request.getParameter("product_code"));
        String directory;
        	if(request.getParameter("action").equals("recover")){
        		ProductBean productBean = SQLOperations.findProduct(product_code,connection);
        		SQLOperations.transferProductOld(product_code, connection);
  	           	SQLOperations.deleteProductOld(product_code, connection);
        		request.setAttribute("productBean",productBean);
        		directory="/ViewOld.html";
        	}else if(request.getParameter("action").equals("delete")){
        		SQLOperations.deleteProductOld(product_code, connection);
        		directory="/ViewOld.html";
        	}else{
        		directory="/MainMenu.jsp";
        	}
        
        getServletContext().getRequestDispatcher(directory).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

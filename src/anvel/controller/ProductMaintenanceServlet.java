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
 * Created by Jude on 2/21/2016.
 */
@WebServlet("/productmaintenance.html")
public class ProductMaintenanceServlet extends HttpServlet {
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
        	if(request.getParameter("action").equals("edit")){
        		directory="/editProduct.jsp";
        		ProductBean productBean = SQLOperations.findProduct(product_code,connection);
        		request.setAttribute("productBean",productBean);
        	}else if(request.getParameter("action").equals("delete")){
        		directory="/deleteProduct.jsp";
        		ProductBean productBean = SQLOperations.findProduct(product_code,connection);
        		request.setAttribute("productBean",productBean);
        	}else{
        		directory="/MainMenu.jsp";
        	}
        
        getServletContext().getRequestDispatcher(directory).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

package anvel.controller;

import anvel.utility.sql.SQLOperations;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by Jude on 2/21/2016.
 */
@WebServlet("/SearchProduct.html")
public class SearchProductServlet extends HttpServlet {
    Connection connection;
    public void init() throws ServletException{
        connection= SQLOperations.getConnection();
        if(connection!=null)System.out.println("CONNECTED");
        else System.out.println("NULL CONNECTION");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchQuery=request.getParameter("searchQuery");
        ResultSet rs = SQLOperations.searchProductsDatabase(searchQuery,connection);
        request.setAttribute("productrecords",rs);
        getServletContext().getRequestDispatcher("/ViewProduct.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

package anvel.controller;

import anvel.utility.sql.SQLOperations;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by Jude on 3/21/2016.
 */
@WebServlet("/DeliveryPageLastPart.html")

public class DeliveryLastServlet extends HttpServlet {
    Connection connection;

    public void init() throws ServletException{
        connection = SQLOperations.getConnection();
        if(connection!=null){
            System.out.println("CONNECTED");
        }else{
            System.out.println("NULL CONNECTION");
        }
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

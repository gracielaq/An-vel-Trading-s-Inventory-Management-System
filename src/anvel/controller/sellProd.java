package anvel.controller;

import anvel.utility.sql.SQLOperations;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SellProducts.html")
public class sellProd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
	public void init() throws ServletException {
		connection = SQLOperations.getConnection();
        if(connection!= null) System.out.println("CONNECTED");
        else System.out.println("NULL CONNECTION");

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

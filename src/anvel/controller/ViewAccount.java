package anvel.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import anvel.utility.sql.SQLOperations;

/**
 * Servlet implementation class ViewAccount
 */
@WebServlet("/ViewAccount.html")
public class ViewAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet rs = SQLOperations.getAllAccounts(connection);
		request.setAttribute("accounts",rs);
		getServletContext().getRequestDispatcher("/ViewAccounts.jsp").forward(request,response);
	}

}

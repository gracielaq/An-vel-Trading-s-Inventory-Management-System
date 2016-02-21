package anvel.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import anvel.model.AccountBean;
import anvel.utility.sql.SQLOperations;


@WebServlet("/uservalidation.html")
public class ValidateLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	
	public void init() throws ServletException {
		connection = SQLOperations.getConnection();
		if (connection != null) {
			System.out.println("Login connection is READY.");
		} else {
			System.err.println("Login connection is NULL.");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("username")!=null &&request.getParameter("password")!=null){
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			if(SQLOperations.loginCheck(username, password, connection)){
				System.out.println("successful connection!");
					
				AccountBean admin = 
				  SQLOperations.searchAdmin(username, connection);
				request.setAttribute("Admin", admin);
				
				getServletContext().getRequestDispatcher("/MainMenu.jsp").forward(request, response);
			}
			else{
				request.setAttribute("error","Invalid Username or Password");
				System.out.println("Invalid username or password");
				RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}
			
		}
		else
		{
			getServletContext().getRequestDispatcher("/ErrorLogin.jsp").forward(request, response);
		}
	}

}

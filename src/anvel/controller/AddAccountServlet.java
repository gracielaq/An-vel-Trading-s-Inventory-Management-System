package anvel.controller;

import anvel.model.AccountBean;
import anvel.model.BeanFactory;

import anvel.utility.sql.SQLOperations;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddAccount.html")
public class AddAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;

	public void init() throws ServletException {
        connection = SQLOperations.getConnection();
        if(connection!=null){
            System.out.println("AddAccount-Connected!");
        }
        else{
            System.out.println("AddAccount- not connected!");
        }
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username, password, email, firstName, lastName, isAdmin;
        username= request.getParameter("username");
        password= request.getParameter("password");
        email = request.getParameter("email");
        firstName=request.getParameter("firstName");
        lastName=request.getParameter("lastName");
        isAdmin=request.getParameter("isAdmin");

        //pupunta sa status ng page
        String directory = "/accountAddStatus.jsp";
        AccountBean accountBean = BeanFactory.getInstance(username,password,email,firstName,lastName,isAdmin);
        if(SQLOperations.addAccount(accountBean, connection)){
            directory+="?status=success";
        }else{
            directory+="?status=failed";
        }
        getServletContext().getRequestDispatcher(directory).forward(request,response);
	}

}

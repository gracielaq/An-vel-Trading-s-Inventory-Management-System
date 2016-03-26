package anvel.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import anvel.model.AccountBean;
import anvel.model.BeanFactory;
import anvel.utility.Security;
import anvel.utility.sql.SQLOperations;
import anvel.utility.EmailUtility;

@WebServlet("/retrievepw.html")
public class PWRetrieval extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private String host;
	    private String port;
	    private String user;
	    private String pass;

	Connection connection;
	public void init() throws ServletException {
		
		 ServletContext context = getServletContext();
	     host = context.getInitParameter("host");
	     port = context.getInitParameter("port");
	     user = context.getInitParameter("user");
	     pass = context.getInitParameter("pass");
        connection = SQLOperations.getConnection();
        if(connection!=null){
            System.out.println("RetrievePass-Connected!");
        }
        else{
            System.out.println("RetrievePass- not connected!");
        }
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username =  request.getParameter("username");
		String email = request.getParameter("email");
		String oldpass=request.getParameter("oldpass");
		String newpass=request.getParameter("newpass");
		String directory = "result.jsp";
		String password, firstName, lastName;
		System.out.println(SQLOperations.checkUser(username, connection));
		if(SQLOperations.checkUser(username, connection)){
			ResultSet rs = SQLOperations.getUser(username, connection);
			try {
				while(rs.next())
				{
					password = Security.decrypt(rs.getString("password"));
					if (password.equals(oldpass)){
						if(SQLOperations.updatePass(username, newpass, connection)>=1){
							password=newpass;
							firstName = rs.getString("firstname");
							lastName = rs.getString("lastname");
							String isAdmin = rs.getString("isadmin");
					
							String subject = "Password Retrieval";
							String content = "Good Day "+firstName + " "+lastName + "! BOBO mo naman kinakalimutan mo password mo. Pero eto na, bigay ko na sayo. Baka magiyak ka pa e. Your password is " + password;
					
							String resultMessage = "";
				
							System.out.println("email add: "+email);
							System.out.println("password "+password);
							EmailUtility.sendEmail(host, port, user, pass, email, subject,
									content);
							resultMessage = "The e-mail was sent successfully";
							System.out.print(resultMessage);
			            }
						else{
							directory += "?message='Update Failed'";
							getServletContext().getRequestDispatcher(directory).forward(request,response);
						}
					}
					else{
						directory += "?message='password incorrect'";
						getServletContext().getRequestDispatcher(directory).forward(request,response);
					}
					
				
				}
			 } catch (Exception ex) {
		            ex.printStackTrace();
		        } finally {
		            getServletContext().getRequestDispatcher("/successfulPWR.jsp").forward(
		                    request, response);
		        }	
			
		}
		else
		{
			directory += "?message='username not found'";
			getServletContext().getRequestDispatcher(directory).forward(request,response);}	
		
		
	}
	

}

package anvel.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import anvel.utility.MyPdfCreator;
import anvel.utility.sql.SQLOperations;

/**
 * Servlet implementation class productsreport
 */
@WebServlet("/productsreport.jsp")
public class productsreport extends HttpServlet {
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
		ResultSet rs = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
			
		
		String query = "Select * from product where date_received >=? AND date_received < ?";
		//String query = "Select * from product";
		try {
			String fileName=request.getParameter("fileName");
			java.sql.Date date1 = new java.sql.Date(sdf.parse(request.getParameter("date1")).getTime());
			java.sql.Date date2 = new java.sql.Date(sdf.parse(request.getParameter("date2")).getTime());
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setDate(1, date1);
			pstmt.setDate(2, date2);
			rs=pstmt.executeQuery();
			request.setAttribute("productrecords",rs);
			MyPdfCreator.generatePDF(rs, fileName);
			getServletContext().getRequestDispatcher("/ViewProduct.jsp").forward(request,response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		request.setAttribute("accounts",rs);
	}

}

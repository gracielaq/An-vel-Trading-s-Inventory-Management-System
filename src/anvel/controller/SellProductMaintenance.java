package anvel.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import anvel.model.BeanFactory;
import anvel.model.ProductBean;
import anvel.model.SoldBean;
import anvel.utility.sql.SQLOperations;


@WebServlet("/SellProductMaintenance.html")
public class SellProductMaintenance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;

	public void init() throws ServletException {
		connection = SQLOperations.getConnection();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            String product_code = request.getParameter("product_code");
	            String product_name = request.getParameter("product_name");
	            java.sql.Date date = new java.sql.Date(sdf.parse(request.getParameter("date")).getTime());
	            
	            String customer_name=request.getParameter("customer_name");
	            int quantity=Integer.parseInt(request.getParameter("quantity"));
	            
	            String tin=request.getParameter("tin");
	            String product_description=request.getParameter("product_description");
	            Double unit_price=Double.parseDouble(request.getParameter("unit_price"));
	            Double discount_sell=Double.parseDouble((request.getParameter("discount_sell")));
	            Double total_amount= Double.parseDouble(request.getParameter("total_amount"));
	            String mode_of_payment=request.getParameter("mode_of_payment");
	            int note_quantity=Integer.parseInt(request.getParameter("quantity"));
	            String note_description=request.getParameter("product_description");
	            String address=request.getParameter("address");
	            int check_no=0;
	            
	            String query = "Select * from product where product_code=?";
	            PreparedStatement pstmt = connection
						.prepareStatement(query);
				pstmt.setString(1, product_code);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()){
				int oldQty= rs.getInt("quantity");
				int newQty= oldQty-quantity;
			
	           try{
	            check_no=Integer.parseInt(request.getParameter("check_no"));
	            }
	           catch(Exception e){
	        	 
	            }
	           ProductBean productbean = BeanFactory.getInstance(product_code, rs.getString("product_name"),rs.getDate("delivery_date"), 
	            		rs.getDate("date_received"), rs.getInt("DR_SI"), newQty, rs.getDouble("delivery_charge"),rs.getString("supplier"),rs.getString("category"), rs.getString("product_description"), 
	            		rs.getString("size"), rs.getDouble("unit_price"),rs.getDouble("discount_add"), rs.getDouble("total_amount"), rs.getString("mode_of_payment"), rs.getInt("check_no"), rs.getString("status"));
		        
	           
	           
	           	SoldBean soldbean =BeanFactory.getInstance(product_code, rs.getString("product_name"),unit_price, quantity, product_description, discount_sell, 
	            			 note_quantity, note_description, customer_name, tin, address, date, mode_of_payment, check_no,rs.getString("size"));
	            
				 
	           	if (connection != null) {
	           		
	           		
	           		
	                if (SQLOperations.addSoldProduct(product_code,soldbean, connection)) {
	                	SQLOperations.updateProduct(productbean,product_code,connection);
	                    System.out.println("item successfully inserted");
	                    request.setAttribute("productbean", soldbean);
	                    //TODO
	                    getServletContext().getRequestDispatcher(
	                            "/sellProductStatus.jsp?status=true").forward(request,
	                            response);
	                } else {
	                    //TODO
	                    getServletContext().getRequestDispatcher(
	                            "/sellProductStatus.jsp?status=false").forward(request,
	                            response);
	                }
	            } else {
	                System.out.print("invalid connection");
	            }
				}
	        } catch (NumberFormatException | ParseException e) {

	            e.printStackTrace();
	        } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	    }
	}



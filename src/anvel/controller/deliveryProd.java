package anvel.controller;

import anvel.utility.sql.SQLOperations;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import anvel.model.ProductBean;
import anvel.model.BeanFactory;
import anvel.model.DeliveryBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@WebServlet("/Delivery.html")
public class deliveryProd extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Connection connection;

    public void init() throws ServletException {
        connection = SQLOperations.getConnection();
        if (connection != null) {
            System.out.println("Connected!");
        } else {
            System.out.print("Null connection");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //try {
            String product_code[]=request.getParameterValues("productsOrdered[]");
            ArrayList<ProductBean> tempproductbeans= new ArrayList<ProductBean>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String driver = request.getParameter("driver");
            String helper=request.getParameter("helper");
            String plateNum=request.getParameter("plateNum");

            String coding=request.getParameter("Days");
         //   java.sql.Date deliveryDate = new java.sql.Date(sdf.parse(request.getParameter("deliveryDate")).getTime());

/*

            for(String x: product_code){
                DeliveryBean deliveryBean=BeanFactory.getDeliveryBeanInstance(driver,helper,x,plateNum,"",deliveryDate);
              //  tempproductbeans.add(SQLOperations.findProduct(x,connection);
                SQLOperations.addDelivery(deliveryBean,connection);
            }

            ProductBean[] productBean= tempproductbeans.toArray(new ProductBean[tempproductbeans.size()]);
            //for every product na inorder

            for(ProductBean product:productBean){
                DeliveryBean deliverybean= BeanFactory.getAccountBeanInstance(driver,)
                SQLOperations.addDelivery();
            }



*/
            
            
            //DeliveryBean deliveryBean = BeanFactory.getProductBeanInstance(driver,helper,product_code,plateNum,coding,deliveryDate);
/*
            if (connection != null) {
                if (SQLOperations.addDelivery(deliveryBean, connection)) {
                    System.out.println("delivery successfully inserted");
                    request.setAttribute("deliveryBean", deliveryBean);
                    //TODO
                    getServletContext().getRequestDispatcher(
                            "/deliveryStatus.jsp?status=true").forward(request,
                                    response);
                } else {
                    //TODO
                    getServletContext().getRequestDispatcher(
                            "/deliveryStatus.jsp?status=false").forward(request,
                                    response);
                }
            } else {
                System.out.print("invalid connection");
            }

        } catch (NumberFormatException  e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

    }
}

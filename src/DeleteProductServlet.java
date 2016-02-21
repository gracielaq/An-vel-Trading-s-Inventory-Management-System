import anvel.utility.sql.SQLOperations;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by Jude on 2/22/2016.
 */
@WebServlet("/deleteProduct.html")
public class DeleteProductServlet extends HttpServlet {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("action").equals("yes")){
            //TODO
        }else{
            response.sendRedirect("/View.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

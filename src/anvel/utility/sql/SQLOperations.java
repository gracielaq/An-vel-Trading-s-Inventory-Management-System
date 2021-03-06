package anvel.utility.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import anvel.model.*;
import anvel.utility.Security;

public class SQLOperations implements SQLCommands {

    private static Connection connection;

    private SQLOperations() {
    }

    private static Connection getDBConnection() {
        try {
            InitialContext context = new InitialContext();
            DataSource dataSource = (DataSource) context
                    .lookup("java:comp/env/jdbc/UST-3CSC-DS");

            if (dataSource != null) {
                connection = dataSource.getConnection();
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getConnection() {
        return (connection != null) ? connection : getDBConnection();
    }

    public static ResultSet getAllSold(Connection connection) {

        ResultSet rs = null;
        try {
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(GET_ALL_SOLD_PRODUCTS);
        } catch (SQLException sqle) {
            System.out.println("SQLException - getALLEmployees: "
                    + sqle.getMessage());
            return rs;
        }
        return rs;
    }
    
    public static ResultSet getAllDelivered(Connection connection) {

        ResultSet rs = null;
        try {
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(GET_ALL_DELIVERED);
        } catch (SQLException sqle) {
            System.out.println("SQLException - getALLDelivered: "
                    + sqle.getMessage());
            return rs;
        }
        return rs;
    }

    // to do!!
    public static boolean addSoldProduct(String product_code, SoldBean soldBean,
                                         Connection connection) {

        try {

            PreparedStatement pstmt = connection
                    .prepareStatement(ADD_SOLD_PRODUCT);

            pstmt.setString(1, soldBean.getProduct_code());
            pstmt.setString(2, soldBean.getProduct_name());
            pstmt.setInt(3, soldBean.getQuantity());
            pstmt.setInt(4, soldBean.getNote_quantity());
            pstmt.setString(5, soldBean.getNote_description()+"- SOLD");
            pstmt.setString(6, soldBean.getProduct_description());
            pstmt.setDouble(7, soldBean.getUnit_price());
            pstmt.setDouble(8, soldBean.getDiscount_sell());
            pstmt.setDouble(9, soldBean.getTotal_amount());
            pstmt.setString(10, soldBean.getMode_of_payment());
            pstmt.setInt(11, soldBean.getCheck_no());
            pstmt.setString(12, soldBean.getSize());
            pstmt.setString(13, soldBean.getCustomer_name());
            pstmt.setString(14, soldBean.getTin());
            pstmt.setString(15, soldBean.getAddress());
            pstmt.setDate(16, soldBean.getDate());
            pstmt.setString(17,soldBean.getDelivery_pickup_status());
            pstmt.setString(18,soldBean.getCategory());

            pstmt.executeUpdate(); // execute insert statement
        } catch (SQLException sqle) {
            System.out.println("SQLException - addSoldProduct: "
                    + sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return true;

    }
 
    public static ResultSet getAllProducts(Connection connection) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement(GET_ALL_PRODUCTS);
            ResultSet rs = statement.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.print("getAllProducts Method Error:");
            e.printStackTrace();
            return null;
        }

    }

    public static ResultSet getAllAccounts(Connection connection) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement(GET_ALL_ACCOUNTS);
            ResultSet rs = statement.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.print("getAllProducts Method Error:");
            e.printStackTrace();
            return null;
        }

    }
    
    public static boolean checkUser(String uname, Connection connection)
	{
		boolean login = false;
		ResultSet rs = null;
		
		try{
			PreparedStatement pstmt = connection.prepareStatement(CHECK_USER);
			pstmt.setString(1, uname);
			rs=pstmt.executeQuery();
			rs=pstmt.getResultSet();
			login=rs.next();
			}
		catch(SQLException e)
		{
			System.out.println("hayss");
			e.printStackTrace();
		}return login;
		
	}
    
    public static ResultSet isAdmin(String username, Connection connection)
  	{
  		
  		ResultSet rs = null;
  		
  		try{
  			PreparedStatement pstmt = connection.prepareStatement(IS_ADMIN);
  			pstmt.setString(1, username);
  			rs=pstmt.executeQuery();
  			rs=pstmt.getResultSet();
  			rs.next();
  			return rs;
  			}
  		catch(SQLException e)
  		{
  			System.out.println("IsAdmin probs");
  			e.printStackTrace();
  		}return null;
  		
  	}
    
    public static ResultSet getUser(String username, Connection connection)
	{
		ResultSet rs = null;
		
		try{
			PreparedStatement pstmt = connection.prepareStatement(SELECT_USER);
			pstmt.setString(1, username);
			rs=pstmt.executeQuery();
			rs=pstmt.getResultSet();
			
			}
		catch(SQLException e)
		{
			System.out.println("hayss");
			e.printStackTrace();
		}return rs;
		
	}

    public static ResultSet getAllOldProducts(Connection connection) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement(GET_ALL_OLD_PRODUCTS);
            ResultSet rs = statement.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.print("getAllOldProducts Method Error:");
            e.printStackTrace();
            return null;
        }

    }

    public static int updateProduct(ProductBean product, String product_code,
                                    Connection connection) {
		/*
		String UPDATE_PRODUCT = "update product set "
			+ "supplier=?,product_name=?"+ "delivery_date=?," + "date_received=?,"
			+ "delivery_charge=?," + "DR_SI=?," + "quantity=?,"
			+ "product_description=?," + "unit_price=?," + "discount_add=?,"
			+ "total_amount=?," +"mode_of_payment=?,check_no=?,size=?,category=?,status=? "+ "where product_code=?";
		 */
        int updated = 0;
        try {
            connection.setAutoCommit(false);
            PreparedStatement pstmt = connection
                    .prepareStatement(UPDATE_PRODUCT);
            pstmt.setString(1, product.getSupplier());
            pstmt.setString(2, "" + product.getProduct_name());

            pstmt.setDate(3,  product.getDelivery_date());
            pstmt.setDate(4, product.getDate_received());
            pstmt.setDouble(5,  product.getDelivery_charge());
            pstmt.setString(6, "" + product.getDR_SI());
            pstmt.setInt(7,product.getQuantity());
            pstmt.setString(8, product.getProduct_description());
            pstmt.setDouble(9, product.getUnit_price());
            pstmt.setDouble(10, product.getDiscount_add());
            pstmt.setDouble(11,product.getTotal_amount());
            pstmt.setString(12, product.getMode_of_payment());
            pstmt.setInt(13, product.getCheck_no());
            pstmt.setString(14, product.getSize());
            pstmt.setString(15, product.getCategory());
            pstmt.setString(16, product.getStatus());
            pstmt.setString(17, product_code);

            updated = pstmt.executeUpdate();
            connection.commit();
        } catch (SQLException sqle) {
            System.out.println("SQLException - updateItem: "
                    + sqle.getMessage());

            try {
                connection.rollback();
            } catch (SQLException sql) {
                System.err.println("Error on Update Connection Rollback - "
                        + sql.getMessage());
            }
            return updated;
        }
        return updated;
    }
    public static int updatePass( String username, String newpass, Connection connection) {

    	int updated = 0;
    	try {
    		connection.setAutoCommit(false);
    		PreparedStatement pstmt = connection.prepareStatement(UPDATE_PASS);
    		pstmt.setString(1, newpass);
    		pstmt.setString(2, username);
    		updated = pstmt.executeUpdate();
    		connection.commit();
    	} catch (SQLException sqle) {
    		System.out.println("SQLException - updatePass: "
    				+ sqle.getMessage());

    		try {
    			connection.rollback();
    		} catch (SQLException sql) {
    			System.err.println("Error on Update Connection Rollback - "
    					+ sql.getMessage());
    		}
    			return updated;
    	}
    	return updated;
    }
    public static boolean addProduct(ProductBean product, Connection connection) {
        try {
			/*
			String ADD_PRODUCT = "insert into Product(product_code,product_name, supplier ,delivery_date,date_received, 
			delivery_charge,DR_SI,quantity,size,product_description,unit_price,discount_add,total_amount,mode_of_payment,
			check_no,category,status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			 */
            PreparedStatement pstmt = connection.prepareStatement(ADD_PRODUCT);
            pstmt.setString(1, product.getProduct_code());
            pstmt.setString(2, product.getProduct_name());
            pstmt.setString(3, product.getSupplier());
            pstmt.setDate(4, product.getDelivery_date());
            pstmt.setDate(5, product.getDate_received());
            pstmt.setDouble(6, product.getDelivery_charge());
            pstmt.setInt(7, product.getDR_SI());
            pstmt.setInt(8, product.getQuantity());
            pstmt.setString(9, product.getSize());
            pstmt.setString(10, product.getProduct_description());
            pstmt.setDouble(11, product.getUnit_price());
            pstmt.setDouble(12, product.getDiscount_add());
            pstmt.setDouble(13, product.getTotal_amount());
            pstmt.setString(14, product.getMode_of_payment());
            pstmt.setInt(15, product.getCheck_no());
            pstmt.setString(16, product.getCategory());
            pstmt.setString(17, product.getStatus());


            pstmt.execute();
        } catch (SQLException sqle) {
            System.out.println("SQLException - addProduct: "
                    + sqle.getMessage());
            return false;
        }
        return true;

    }

    public static ProductBean findProduct(String product_code, Connection connection) {

        ProductBean productbean = null;

        try {
            PreparedStatement pstmt = connection
                    .prepareStatement(SEARCH_PRODUCT);
            pstmt.setString(1, product_code);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                productbean = BeanFactory.getProductBeanInstance(
                        rs.getString("product_code"),
                        rs.getString("product_name"),
                        rs.getDate("delivery_date"),
                        rs.getDate("date_received"),
                        rs.getInt("dR_SI"),
                        rs.getInt("quantity"),
                        rs.getDouble("delivery_charge"),
                        rs.getString("supplier"),
                        rs.getString("category"),
                        rs.getString("product_description"),
                        rs.getString("size"),
                        rs.getDouble("unit_price"),
                        rs.getDouble("discount_add"),
                        rs.getDouble("total_amount"),
                        rs.getString("mode_of_payment"),
                        rs.getInt("check_no"),
                        rs.getString("status"));
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException - findProduct: "
                    + sqle.getMessage());
            return productbean;
        }
        return productbean;
    }

    public static ResultSet searchProductsDatabase(String searchQuery, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_FOR_SOLD_PRODUCTS);
            ResultSet rs = preparedStatement.executeQuery();
            return rs;
        } catch (Exception e) {
            System.out.println("searchProductsdatabase error");
            e.printStackTrace();
            return null;
        }
    }

    // TO DO
	/*
	 * public static synchronized int deleteItem(int id, Connection connection)
	 * { int updated = 0;
	 * 
	 * try { connection.setAutoCommit(false); PreparedStatement pstmt =
	 * connection.prepareStatement(DELETE_ITEM); pstmt.setInt(1, id); updated =
	 * pstmt.executeUpdate(); connection.commit(); } catch (SQLException sqle) {
	 * System.out.println("SQLException - deleteITEM: " + sqle.getMessage());
	 * 
	 * try { connection.rollback(); } catch (SQLException sql) {
	 * System.err.println("Error on Delete Connection Rollback - " +
	 * sql.getMessage()); } return updated; } return updated; }
	 */
    public static boolean loginCheck(String username, String password,
                                     Connection connection) {
        boolean login = false;
        ResultSet rs = null;
        try {
            PreparedStatement pstmt = connection.prepareStatement(LOGIN_CHECK);

            pstmt.setString(1, username);
            pstmt.setString(2, Security.encrypt(password));
            rs = pstmt.executeQuery();
            login = rs.first();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return login;
    }

    public static AccountBean searchAdmin(String username, Connection connection) {

        AccountBean acc = new AccountBean();

        try {
            PreparedStatement pstmt = connection.prepareStatement(SEARCH_ADMIN);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));
                acc.setFirstName(rs.getString("firstName"));
                acc.setLastName(rs.getString("lastName"));
                acc.setEmail(rs.getString("email"));
            }
        } catch (SQLException sqle) {
            System.out.println("SQLException - searchIntern:"
                    + sqle.getMessage());
            return acc;
        }
        return acc;

    }

    public static boolean addAccount(AccountBean accountBean, Connection connection) {
        try {
			/*FOR LOGINS(staff)
			CREATE TABLE `accounts` (
			`username` varchar(200) NOT NULL,
			`password` varchar(200) NOT NULL,
			`email` varchar(300) NOT NULL,
			`firstName` varchar(100) NOT NULL,
			`lastName` varchar(100) NOT NULL,
			`isAdmin` varchar(10) NOT NULL,
			PRIMARY KEY (`username`)
			) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

            PreparedStatement preparedStatement = connection.prepareStatement("Insert into accounts(username, password," +
                    "email," +
                    "firstname," +
                    "lastname," +
                    "isAdmin) VALUES (?,?,?,?,?,?)");
            preparedStatement.setString(1, accountBean.getUsername());
            preparedStatement.setString(2, accountBean.getPassword());
            preparedStatement.setString(3, accountBean.getEmail());
            preparedStatement.setString(4, accountBean.getFirstName());
            preparedStatement.setString(5, accountBean.getLastName());
            preparedStatement.setString(6, accountBean.getIsAdmin());
            preparedStatement.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("addAccount Exception " + e);
            return false;
        }
    }

    //for trucks
    public static ResultSet getTrucks(Connection connection) {
        ResultSet resultSet;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from trucks");
            resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (Exception e) {
            System.out.println("getTrucks Error - " + e.getMessage());
            return null;
        }
    }

    public static boolean addDelivery(DeliveryBean deliveryBean, Connection connection) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(ADD_DELIVERY);

            pstmt.setString(1, deliveryBean.getDriver());
            pstmt.setString(2, deliveryBean.getHelper());
            pstmt.setString(3, deliveryBean.getPlateNum());
            pstmt.setString(4, deliveryBean.getCodingDay());
            pstmt.setDate(5, deliveryBean.getDeliveryDate());
            return true;
        } catch (Exception e) {
            System.out.println("ADD DELIVERY ERROR-" + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static boolean transferProduct(String id,
                                          Connection connection) {

        try {
            PreparedStatement pstmt = connection.prepareStatement(TRANSFER_PRODUCT);
            pstmt.setString(1, id);
            pstmt.executeUpdate(); // execute insert statement
        } catch (SQLException sqle) {
            System.out.println("SQLException - transferProduct: " + sqle.getMessage());
            sqle.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean transferProductOld(String product_code,
                                             Connection connection) {

        try {
            PreparedStatement pstmt = connection.prepareStatement(TRANSFER_PRODUCT_OLD);
            pstmt.setString(1, product_code);
            pstmt.executeUpdate(); // execute insert statement
        } catch (SQLException sqle) {
            System.out.println("SQLException - transferProduct: " + sqle.getMessage());
            return false;
        }
        return true;
    }

    public static synchronized int deleteProduct(String product_code, Connection connection) {
        int updated = 0;

        try {
            connection.setAutoCommit(false);
            PreparedStatement pstmt = connection.prepareStatement(DELETE_PRODUCT);
            pstmt.setString(1, product_code);
            updated = pstmt.executeUpdate();
            connection.commit();
        } catch (SQLException sqle) {
            System.out.println("SQLException - deleteProduct: " + sqle.getMessage());

            try {
                connection.rollback();
            } catch (SQLException sql) {
                System.err.println("Error on Delete Connection Rollback - " + sql.getMessage());
            }
            return updated;
        }

        return updated;
    }

    public static synchronized int deleteProductOld(String product_code, Connection connection) {
        int updated = 0;

        try {
            connection.setAutoCommit(false);
            PreparedStatement pstmt = connection.prepareStatement(DELETE_PRODUCT_OLD);
            pstmt.setString(1, product_code);
            updated = pstmt.executeUpdate();
            connection.commit();
        } catch (SQLException sqle) {
            System.out.println("SQLException - deleteProduct: " + sqle.getMessage());

            try {
                connection.rollback();
            } catch (SQLException sql) {
                System.err.println("Error on Delete Connection Rollback - " + sql.getMessage());
            }
            return updated;
        }

        return updated;
    }

    public static ResultSet getEligibleDeliveries(Connection connection2) {
        try {
            Statement pstmt = connection2.createStatement();

            ResultSet rs = pstmt.executeQuery("SELECT * FROM SELL WHERE delivery_pickup_status LIKE 'fordelivery'");
            return rs;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

}

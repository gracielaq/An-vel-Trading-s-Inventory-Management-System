package anvel.utility.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.Calendar;

import javax.naming.spi.DirStateFactory;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import anvel.model.*;
import anvel.utility.Security;
import anvel.utility.sql.SQLCommands;

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

	/*
	 * FOR SELL: CREATE TABLE `Sell` ( `product_code` int(11) NOT NULL,
	 * `unit_price` double NOT NULL, `quantity` int(11) NOT NULL,
	 * `product_description` varchar(999) DEFAULT NULL, `discount` double
	 * DEFAULT NULL, `total_amount` double DEFAULT NULL, `note_quantity` int(11)
	 * DEFAULT NULL, `note_description` varchar(999) DEFAULT NULL,
	 * `customer_name` varchar(200) NOT NULL, `tin` varchar(200) NOT NULL,
	 * `address` varchar(200) NOT NULL, `date` datetime NOT NULL,
	 * `mode_of_payment` varchar(45) NOT NULL, PRIMARY KEY (`product_code`) )
	 * ENGINE=InnoDB DEFAULT CHARSET=latin1;
	 */

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

	// to do!!
	public static boolean addSoldProduct(int product_code, SoldBean soldBean,
			Connection connection) {
		/*
		 * String ADD_SOLD_PRODUCT = "insert into Product(" + "1product_code," +
		 * "2unit_price, " + "3quantity," + "4product_description, " +
		 * "5discount_sell," + "6total_amount," +"7note_quantity," +
		 * "8note_description," + "9customer_name," + "10tin," + "11address," +
		 * "12date," + "13mode_of_payment" + ") values(?,?,?,?,?,?,?,?,?,?,?)";
		 */

		// ITANONG KAILA MATT AT GQ
		/*
		 * ProductBean productBean = findProduct(product_code, connection);
		 * //update the new quantity to the product
		 * productBean.setQuantity(productBean
		 * .getQuantity()-soldBean.getQuantity()); //update to the database
		 * updateProduct(productBean, productBean.getProduct_code(),connection);
		 */
		try {

			PreparedStatement pstmt = connection
					.prepareStatement(ADD_SOLD_PRODUCT);
			// java.sql.Date date = new
			// java.sql.Date(Calendar.getInstance().getTime().getTime());
			pstmt.setInt(1, soldBean.getProduct_code());
			pstmt.setDouble(2, soldBean.getUnit_price());
			pstmt.setInt(3, soldBean.getQuantity());
			pstmt.setString(4, soldBean.getProduct_description());
			pstmt.setDouble(5, soldBean.getDiscount_sell());
			pstmt.setDouble(6, soldBean.getTotal_amount());
			pstmt.setInt(7, soldBean.getNote_quantity());
			pstmt.setString(8, soldBean.getNote_description());
			pstmt.setString(9, soldBean.getCustomer_name());
			pstmt.setString(10, soldBean.getTin());
			pstmt.setString(11, soldBean.getAddress());
			pstmt.setDate(12, soldBean.getDate());
			pstmt.setString(13, soldBean.getMode_of_payment());
			pstmt.executeUpdate(); // execute insert statement
		} catch (SQLException sqle) {
			System.out.println("SQLException - addSoldProduct: "
					+ sqle.getMessage());
			return false;
		}
		return true;

	}
 
	/*
	 * public static ResultSet searchProducts(String search,Connection
	 * connection,String[] sortby){ ResultSet rs=null; try { String query =
	 * SEARCH_STRING; if(sortby!=null){ query+=" order by"; for(int
	 * x=0;x<sortby.length;x++){
	 * if(sortby[x].equals("product_code"))query+=" product_code asc ";
	 * if(sortby[x].equals("quantity"))query+=" quantity asc ";
	 * if(sortby[x].equals("manufacturer"))query+=" manufacturer asc ";
	 * if(sortby[x].equals("item"))query+=" item asc ";
	 * if(x<sortby.length-1)query+=","; } System.out.print(query); }
	 * PreparedStatement pstmt = connection.prepareStatement(query);
	 * pstmt.setString(1,"%"+search+"%"); pstmt.setString(2,"%"+search+"%");
	 * pstmt.setString(3,"%"+search+"%"); pstmt.setString(4,"%"+search+"%");
	 * pstmt.setString(5,"%"+search+"%");
	 * 
	 * rs = pstmt.executeQuery(); } catch (SQLException e) {
	 * System.out.print("Searchproducts error-"); e.printStackTrace(); }
	 * 
	 * return rs;
	 * 
	 * }
	 */

	// FOR PRODUCTS DB
	/*
	 * CREATE TABLE `product` ( `product_code` int(11) NOT NULL, `delivery_date`
	 * datetime NOT NULL, `date_received` datetime NOT NULL, `delivery_charge`
	 * varchar(45) NOT NULL, `DR_SI` varchar(100) NOT NULL, `quantity` int(11)
	 * NOT NULL, `product_description` varchar(999) DEFAULT NULL, `unit_price`
	 * double NOT NULL, `discount` double DEFAULT NULL, `total_amount` double
	 * DEFAULT NULL, `mode_of_payment` varchar(45) NOT NULL, `supplier`
	 * varchar(200) NOT NULL, PRIMARY KEY (`product_code`) ) ENGINE=InnoDB
	 * DEFAULT CHARSET=utf8;
	 */
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

	public static int updateProduct(ProductBean product, int product_code,
			Connection connection) {
		/*
		 String UPDATE_PRODUCT = "update product set "
			+ "supplier=?," + "delivery_date=?," + "date_recieved=?,"
			+ "delivery_charge=?," + "DR_SI=?," + "quantity=?,"
			+ "product_description=?," + "unit_price=?," + "discount_add=?,"
			+ "total_amount=?," +"mode_of_payment=?,check_no=? "+ "where product_code=?";
		 */
		int updated = 0;
		try {
			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection
					.prepareStatement(UPDATE_PRODUCT);
			pstmt.setString(1, product.getSupplier());
			pstmt.setString(2, ""+product.getDelivery_date());
			pstmt.setString(3, ""+product.getDate_recieved());
			pstmt.setString(4, ""+product.getDelivery_charge());
			pstmt.setString(5, ""+product.getDR_SI());
			pstmt.setString(6, ""+product.getQuantity());
			pstmt.setString(7,product.getProduct_description());
			pstmt.setString(8, ""+product.getUnit_price());
			pstmt.setString(9, ""+product.getDiscount_add());
			pstmt.setString(10, ""+product.getTotal_amount());
			pstmt.setString(11, product.getMode_of_payment());
			pstmt.setInt(12, product.getCheck_no());
			pstmt.setInt(13, product_code);
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

	public static boolean addProduct(ProductBean product, Connection connection) {
		try {
			/*
			String ADD_PRODUCT = "insert into Product(delivery_date, date_recieved, delivery_charge, 
			DR_SI, quantity,product_description,unit_price,discount_add,total_amount,mode_of_payment,supplier,
			product_code) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			 */
			PreparedStatement pstmt = connection.prepareStatement(ADD_PRODUCT);

			pstmt.setDate(1, product.getDelivery_date());
			pstmt.setDate(2, product.getDate_recieved());
			pstmt.setDouble(3, product.getDelivery_charge());
			pstmt.setInt(4, product.getDR_SI());
			pstmt.setInt(5, product.getQuantity());
			pstmt.setString(6, product.getProduct_description());
			pstmt.setDouble(7, product.getUnit_price());
			pstmt.setDouble(8, product.getDiscount_add());
			pstmt.setDouble(9, product.getTotal_amount());
			pstmt.setString(10, product.getMode_of_payment());
			pstmt.setString(11, product.getSupplier());
			pstmt.setInt(12, product.getProduct_code());
			pstmt.setInt(13, product.getCheck_no());
			pstmt.execute();
		} catch (SQLException sqle) {
			System.out.println("SQLException - addProduct: "
					+ sqle.getMessage());
			return false;
		}
		return true;

	}

	public static ProductBean findProduct(int id, Connection connection) {

		ProductBean productbean = null;

		try {
			PreparedStatement pstmt = connection
					.prepareStatement(SEARCH_PRODUCT);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				productbean = BeanFactory.getInstance(
						rs.getInt("product_code"), 
						rs.getDate("delivery_date"),
						rs.getDate("date_recieved"),
						rs.getInt("dR_SI"),
						rs.getInt("quantity"),
						rs.getDouble("delivery_charge"),
						rs.getString("supplier"),
						rs.getString("product_description"),
						rs.getDouble("unit_price"),
						rs.getDouble("discount_add"),
						rs.getDouble("total_amount"),
						rs.getString("mode_of_payment"),
						rs.getInt("check_no"));
			}
		} catch (SQLException sqle) {
			System.out.println("SQLException - findProduct: "
					+ sqle.getMessage());
			return productbean;
		}
		return productbean;
	}

	public static ResultSet searchProductsDatabase(String searchQuery, Connection connection){
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_FOR_SOLD_PRODUCTS);
			ResultSet rs = preparedStatement.executeQuery();
			return rs;
		}
		catch (Exception e){
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

	public static boolean addAccount(AccountBean accountBean, Connection connection){
		try{
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
			preparedStatement.setString(1,accountBean.getUsername());
			preparedStatement.setString(2,accountBean.getPassword());
			preparedStatement.setString(3,accountBean.getEmail());
			preparedStatement.setString(4,accountBean.getFirstName());
			preparedStatement.setString(5,accountBean.getLastName());
			preparedStatement.setString(6,accountBean.getIsAdmin());
			preparedStatement.execute();
			return true;

		}catch(SQLException e){
			System.out.println("addAccount Exception "+e);
			return false;
		}
	}

    //for trucks
    public static ResultSet getTrucks(Connection connection){
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from trucks");
            resultSet = preparedStatement.executeQuery();
            return resultSet;
        }
        catch(Exception e){
            System.out.println("getTrucks Error - "+e.getMessage());
            return null;
        }
    }

    public static boolean addTruck(TruckBean truckBean, Connection connection){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_TRUCK);
            preparedStatement.setString(1,truckBean.getPlate_no());
            preparedStatement.setString(2,truckBean.getCoding());
            preparedStatement.setString(3,truckBean.getModel());
            return true;
        }catch(Exception e){
            System.out.println("ADD TRUCK ERROR-"+ e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}

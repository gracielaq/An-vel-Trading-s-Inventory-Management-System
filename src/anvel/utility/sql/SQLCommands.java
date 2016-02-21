package anvel.utility.sql;

public interface SQLCommands {

	
	/*LOGIN COMMANDS*/
	String LOGIN_CHECK="select username, password, email from accounts where username=? and password=?";
	String SEARCH_ADMIN="select * from accounts where username=?";

    /*/*FOR LOGINS(staff)
	CREATE TABLE `accounts` (
			`username` varchar(200) NOT NULL,
	`password` varchar(200) NOT NULL,
	`email` varchar(300) NOT NULL,
	`firstName` varchar(100) NOT NULL,
	`lastName` varchar(100) NOT NULL,
	`isAdmin` varchar(10) NOT NULL,
	PRIMARY KEY (`username`)
	) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

	//String ADD_ACCOUNT_STAFF= "insert into accounts(username,password,email,firstname,lastname,isAdmin) values (?,?,?,?,?,/) ";
	
	
	/*FOR SOLD*/

	  /*FOR SELL:
	   CREATE TABLE `Sell` (
		  `product_code` int(11) NOT NULL,
		  `unit_price` double NOT NULL,
		  `quantity` int(11) NOT NULL,
		  `product_description` varchar(999) DEFAULT NULL,
		  `discount` double DEFAULT NULL,
		  `total_amount` double DEFAULT NULL,
		  `note_quantity` int(11) DEFAULT NULL,
		  `note_description` varchar(999) DEFAULT NULL,
		  `customer_name` varchar(200) NOT NULL,
		  `tin` varchar(200) NOT NULL,
		  `address` varchar(200) NOT NULL,
		  `date` datetime NOT NULL,
		  `mode_of_payment` varchar(45) NOT NULL,
		  PRIMARY KEY (`product_code`)
		) ENGINE=InnoDB DEFAULT CHARSET=latin1;

	*/
	
	String GET_ALL_SOLD_PRODUCTS = "select * from sell";
	String SEARCH_SOLD_PRODUCT = "select * from sell where product_code=?";
	String UPDATE_SOLD_PRODUCT = "update sell set unit_price=?,"
			+ "quantity=?," + "product_description=?," + "discount=?,"
			+ "total_amount=?," + "note_quantity=?," + "note_description=?,"
			+ "customer_name=?," + "tin=?," + "address=?,"
			+ "date=?, checkNumber=?" + "where product_code=?";
	String ADD_SOLD_PRODUCT = "insert into Product(" 
			+ "product_code,"
			+ "unit_price, " 
			+ "quantity," 
			+ "product_description, "
			+ "discount_sell,"
			+ "total_amount,"
			+"note_quantity,"
			+ "note_description,"
			+ "customer_name,"
			+ "tin," 
			+ "address,"
			+ "date,"
			+ "mode_of_payment" 
			+ ") values(?,?,?,?,?,?,?,?,?,?,?)";
	
	String SEARCH_FOR_SOLD_PRODUCTS = "select * from product where"
			+ " product_code like ? OR "
			+ "unit_price like ? OR "
			+ "quantity like ? OR "
			+ "product_description like ? OR "
			+ "discount_sell like ? OR "
			+ "total_amount like ? OR "
			+ "note_quantity like ? OR "
			+ "note_description like ? OR "
			+ "customer_name like ? OR "
			+ "tin like ? OR "
			+ "address like ? OR" +
			"date  like ? OR" +
			"mode_of_payment like ?";


	String ADD_DELIVERY_REPORT = "insert into DeliveryDB(" 
			+ "DeliveryNum,"
			+ "Driver, " 
			+ "Helper," 
			+ "PlateNum, "
			+ "CodingDay,"
			+ "DeliveryDate"
			+ ") values(?,?,?,?,?,?)";
	
	String SEARCH_FOR_DELIVERY_REPORT = "select * from DeliveryDB where"
			+ "DeliveryNum like ? OR "
			+ "Driver like ? OR "
			+ "Helper like ? OR "
			+ "PlateNum like ? OR "
			+ "CodingDay like ? OR "
			+ "DeliveryDate like ? ";
	
	/*FOR Products:
	FOR Products:
		CREATE TABLE `Product` (
		  `product_code` int(11) NOT NULL,
		  `supplier` varchar(200) NOT NULL,
		  `delivery_date` datetime NOT NULL,
		  `date_received` datetime NOT NULL,
		  `delivery_charge` varchar(45) NOT NULL,
		  `DR_SI` varchar(100) NOT NULL,
		  `quantity` int(11) NOT NULL,
		  `product_description` varchar(999) DEFAULT NULL,
		  `unit_price` double NOT NULL,
		  `discount_add` double DEFAULT NULL,
		  `total_amount` double DEFAULT NULL,
		  `mode_of_payment` varchar(45) NOT NULL,
		  PRIMARY KEY (`product_code`)
		) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

	String GET_ALL_PRODUCTS = "select * from product";
	String SEARCH_PRODUCT = "select * from product where product_code=?";
	String UPDATE_PRODUCT = "update product set delivery_date=?,"
			+ "date_received=?," + "delivery_charge=?," + "DR_SI=?,"
			+ "quantity=?," + "product_description=?," + "unit_price=?,"
			+ "discount_add=?," + "total_amount=?," + "mode_of_payment=?,"
			+ "supplier=?" + "where product_code=?";
	String ADD_PRODUCT = "insert into Product(" + "delivery_date,"
			+ "date_recieved, " + "delivery_charge," + "DR_SI, " + "quantity,"
			+ "product_description," + "unit_price," + "discount_add,"
			+ "total_amount," + "mode_of_payment," + "supplier,"
			+ "product_code" + ") values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	String SEARCH_FOR_PRODUCTS = "select * from product where delivery_date like ? OR "
			+ "date_received like ? OR "
			+ "delivery_charge like ? OR "
			+ "DR_SI like ? OR "
			+ "quantity like ? OR "
			+ "product_description like ? OR "
			+ "unit_price like ? OR "
			+ "discount_add like ? OR "
			+ "total_amount like ? OR "
			+ "mode_of_payment like ? OR "
			+ "supplier like ? OR"
			+ " product_code like ?";


	String ADD_TRUCK = "insert into product(plate_no,coding,model) values (?,?,?)";
}

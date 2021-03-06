package anvel.model;

public class BeanFactory {

    public static AccountBean getAccountBeanInstance(String username, String password, String email,
                                                     String firstName, String lastName, String isAdmin) {
        AccountBean accountBean = new AccountBean();
        accountBean.setUsername(username);
        accountBean.setEmail(email);
        accountBean.setFirstName(firstName);
        accountBean.setLastName(lastName);
        accountBean.setIsAdmin(isAdmin);
        accountBean.setPassword(password);
        accountBean.encrypt();
        return accountBean;
    }
    /*FOR Products:*/
    /*
     CREATE TABLE `ProductsDB`.`Product` (
     `product_code` INT NOT NULL COMMENT '',
     `delivery_date` DATETIME NOT NULL COMMENT '',
     `date_received` DATETIME NOT NULL COMMENT '',
     `delivery_charge` VARCHAR(45) NOT NULL COMMENT '',
     `DR_SI` VARCHAR(100) NOT NULL COMMENT '',
     `quantity` INT NOT NULL COMMENT '',
     `product_description` VARCHAR(999) NULL COMMENT '',
     `unit_price` DOUBLE NOT NULL COMMENT '',
     `discount` DOUBLE NULL COMMENT '',
     `total_amount` DOUBLE NULL COMMENT '',
     `mode_of_payment` VARCHAR(45) NOT NULL COMMENT '',
     `supplier` varchar(200) NOT NULL,
     PRIMARY KEY (`product_code`)  COMMENT '');
     */

    /*
     public static ProductBean getProductBeanInstance(int product_code,int quantity,
     double unit_price, double discount, 
     java.sql.Date delivery_date, java.sql.Date date_recieved,
     String delivery_charge, int string,String product_description,
     String mode_of_payment, String supplier){
		
     ProductBean bean = new ProductBean(); 
     bean.setDelivery_date(delivery_date);
     bean.setDate_received(date_recieved);
     bean.setDiscount_add(discount);
     bean.setMode_of_payment(mode_of_payment);
     bean.setDR_SI(string);
     bean.setProduct_description(product_description);
     bean.setProduct_code(product_code);
     bean.setQuantity(quantity);
     bean.setUnit_price(unit_price);
     bean.setSupplier(supplier);
     bean.compute();
     return bean;
     }
	
     /*FOR SELL:
     CREATE TABLE `Sell` (
     `product_code` int(11) NOT NULL,
     `unit_price` double NOT NULL,
     `quantity` int(11) NOT NULL,
     `product_description` varchar(999) DEFAULT NULL,
     `discount_sell` double DEFAULT NULL,
     `total_amount` double DEFAULT NULL,
     `note_quantity` int(11) DEFAULT NULL,
     `note_description` varchar(999) DEFAULT NULL,
     `customer_name` varchar(200) NOT NULL,
     `tin` varchar(200) NOT NULL,
     `address` varchar(200) NOT NULL,
     `date` datetime NOT NULL,
     `mode_of_payment` varchar(45) NOT NULL,
     PRIMARY KEY (`product_code`)
     ) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/
    public static ProductBean getProductBeanInstance(String product_code, String product_name, java.sql.Date delivery_date,
                                                     java.sql.Date date_received, int dR_SI, int quantity, double delivery_charge,
                                                     String supplier, String category, String product_description, String size, double unit_price,
                                                     double discount_add, double total_amount, String mode_of_payment, int check_no, String status) {
        ProductBean pb = new ProductBean();
        pb.setProduct_code(product_code);
        pb.setProduct_name(product_name);
        pb.setDelivery_date(delivery_date);
        pb.setDate_received(date_received);
        pb.setDR_SI(dR_SI);
        pb.setQuantity(quantity);
        pb.setDelivery_charge(delivery_charge);
        pb.setSupplier(supplier);
        pb.setCategory(category);
        pb.setProduct_description(product_description);
        pb.setSize(size);
        pb.setUnit_price(unit_price);
        pb.setDiscount_add(discount_add);
        pb.setTotal_amount(total_amount);
        pb.setMode_of_payment(mode_of_payment);
        pb.setCheck_no(check_no);

        if(quantity<=0){
            pb.setStatus("OUT OF STOCK");
        } else
        if(quantity<=20) {
            pb.setStatus("CRITICAL");
        } else{
            pb.setStatus("OK");
        }


        return pb;
    }

    public static SoldBean getSoldBeanInstance(String product_code, String product_name, double unit_price, int quantity,
                                               String product_description, double discount_sell, int note_quantity,
                                               String note_description, String customer_name, String tin, String address, java.sql.Date date,
                                               String mode_of_payment, int check_no, String size,String delivery_pickup_status, int sell_no, String category) {

        SoldBean bean = new SoldBean();
        bean.setSell_no(sell_no);
        bean.setCategory(category);
        bean.setProduct_code(product_code);
        bean.setProduct_name(product_name);
        bean.setUnit_price(unit_price);
        bean.setQuantity(quantity);
        bean.setProduct_description(product_description);
        bean.setDiscount_sell(discount_sell);
        bean.setNote_quantity(note_quantity);
        bean.setNote_description(note_description);
        bean.setCustomer_name(customer_name);
        bean.setTin(tin);
        bean.setDate(date);
        bean.setAddress(address);
        bean.setMode_of_payment(mode_of_payment);
        bean.setCheck_no(check_no);
        bean.setSize(size);
        bean.setDelivery_pickup_status(delivery_pickup_status);
        
        
        bean.setAddress(address);
        bean.compute();
        return bean;
    }

    public static DeliveryBean getDeliveryBeanInstance(int batch_no, String Driver, String Helper, String sell_no, String plateNum
    		, java.sql.Date DeliveryDate, String destination, String items, String trucking, int quantity) {

        DeliveryBean db = new DeliveryBean();
        db.setBatch_no(batch_no);
        db.setDriver(Driver);
        db.setHelper(Helper);
        db.setSell_no(sell_no);
        db.setPlateNum(plateNum);
        db.setDeliveryDate(DeliveryDate);
        db.setDestination(destination);
        db.setItems(items);
        db.setTrucking(trucking);
        db.setQuantity(quantity);




        switch(plateNum.charAt(plateNum.length()-1)){
            case '1':
            case '2':db.setCodingDay("MONDAY");break;
            case '3':
            case '4':db.setCodingDay("TUESDAY");break;
            case '5':
            case '6':db.setCodingDay("WEDNESDAY");break;
            case '7':
            case '8':db.setCodingDay("THURSDAY");break;
            case '9':
            case '0':db.setCodingDay("FRIDAY");break;


        }
        return db;
    }

}

package anvel.model;

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
public class ProductBean {

    private int  quantity, DR_SI, check_no;
    private double unit_price, discount_add, total_amount, delivery_charge;
    private java.sql.Date delivery_date, date_received;
    private String product_code,product_description,product_name,
            mode_of_payment, supplier, size, category, status;

    public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void compute() {
        // (QTY * Unit Price) � (QTY* Unit Price*Discount)
        setTotal_amount((getQuantity() * getUnit_price())
                - (getQuantity() * getUnit_price() * getDiscount_add()));
    }

  

    public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public java.sql.Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(java.sql.Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public java.sql.Date getDate_received() {
        return date_received;
    }

    public void setDate_received(java.sql.Date date_received) {
        this.date_received = date_received;
    }

    public double getDelivery_charge() {
        return delivery_charge;
    }

    public void setDelivery_charge(double delivery_charge2) {
        this.delivery_charge = delivery_charge2;
    }

    public int getDR_SI() {
        return DR_SI;
    }

    public void setDR_SI(int DR_SI2) {
        DR_SI = DR_SI2;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getMode_of_payment() {
        return mode_of_payment;
    }

    public void setMode_of_payment(String mode_of_payment) {
        this.mode_of_payment = mode_of_payment;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getDiscount_add() {
        return discount_add;
    }

    public void setDiscount_add(double discount_add) {
        this.discount_add = discount_add;
    }

    public int getCheck_no() {
        return check_no;
    }

    public void setCheck_no(int check_no) {
        this.check_no = check_no;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    

}

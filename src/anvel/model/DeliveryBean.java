package anvel.model;

public class DeliveryBean {
	
	private String Driver;
	private String product_code;
	private String Helper;
	private String PlateNum;
	private String CodingDay;
	private java.sql.Date DeliveryDate;
	
	public String getDriver() {
		return Driver;
	}
	public void setDriver(String driver) {
		Driver = driver;
	}
	
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getHelper() {
		return Helper;
	}
	public void setHelper(String helper) {
		Helper = helper;
	}
	public String getPlateNum() {
		return PlateNum;
	}
	public void setPlateNum(String plateNum) {
		PlateNum = plateNum;
	}
	public String getCodingDay() {
		return CodingDay;
	}
	public void setCodingDay(String codingDay) {
		CodingDay = codingDay;
	}
	public java.sql.Date getDeliveryDate() {
		return DeliveryDate;
	}
	public void setDeliveryDate(java.sql.Date deliveryDate) {
		DeliveryDate = deliveryDate;
	}
	
	
}
